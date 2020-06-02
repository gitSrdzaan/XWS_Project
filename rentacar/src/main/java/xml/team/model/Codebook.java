package xml.team.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

//import org.hibernate.annotations.CascadeType;

@Entity
public class Codebook {
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<String> car_model;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<String> fuel_type;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<String> car_class;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<String> car_transmission;


}
