package xws.microservis.rentservice.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Chart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private User client;

    @ManyToMany
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

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }
}
