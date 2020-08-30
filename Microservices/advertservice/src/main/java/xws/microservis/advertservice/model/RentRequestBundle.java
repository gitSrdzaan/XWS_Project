package xws.microservis.advertservice.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class RentRequestBundle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "rentRequestBundle")
    private List<RentRequest> rentRequest;

    public RentRequestBundle() {
        this.rentRequest = new ArrayList<RentRequest>();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<RentRequest> getRentRequest() {
        return rentRequest;
    }

    public void setRentRequest(List<RentRequest> rentRequest) {
        this.rentRequest = rentRequest;
    }


}
