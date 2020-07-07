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
    private Long user_id;

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

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

}
