package xws.microservis.rentservice.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Chart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Long client_id;



    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "rent_advert_chart",
            joinColumns = @JoinColumn(name = "chart_id"),
            inverseJoinColumns = @JoinColumn(name = "rent_advert_id")
    )
    private List<RentAdvert> rentAdvertList;

    public Chart() {
        this.rentAdvertList = new ArrayList<RentAdvert>();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<RentAdvert> getRentAdvertList() {
        return rentAdvertList;
    }

    public void setRentAdvertList(List<RentAdvert> rentAdvertList) {
        this.rentAdvertList = rentAdvertList;
    }


    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }
}
