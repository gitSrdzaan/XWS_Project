package xml.team.rentacar.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

//import org.hibernate.annotations.CascadeType;

@Entity
public class Codebook {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @Column
    @ElementCollection(targetClass = String.class)
    private List<String> car_model;

    @Column
    @ElementCollection(targetClass = String.class)
    private List<String> fuel_type;

    @Column
    @ElementCollection(targetClass = String.class)
    private List<String> car_class;

    @Column
    @ElementCollection(targetClass = String.class)
    private List<String> car_transmission;

    
	/*public Codebook(Long id, List<String> car_model, List<String> fuel_type, List<String> car_class,
			List<String> car_transmission) {
		super();
		this.id = id;
		this.car_model = car_model;
		this.fuel_type = fuel_type;
		this.car_class = car_class;
		this.car_transmission = car_transmission;
	}*/

	public Codebook() {
		//super();
		// TODO Auto-generated constructor stub
		this.car_class = new ArrayList<String>();
		this.car_model = new ArrayList<String>();
		this.car_transmission = new ArrayList<String>();
		this.fuel_type = new ArrayList<String>();
	}

	public List<String> getCar_model() {
		return car_model;
	}

	public void setCar_model(List<String> car_model) {
		this.car_model = car_model;
	}

	public List<String> getFuel_type() {
		return fuel_type;
	}

	public void setFuel_type(List<String> fuel_type) {
		this.fuel_type = fuel_type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<String> getCar_class() {
		return car_class;
	}

	public void setCar_class(List<String> car_class) {
		this.car_class = car_class;
	}

	public List<String> getCar_transmission() {
		return car_transmission;
	}

	public void setCar_transmission(List<String> car_transmission) {
		this.car_transmission = car_transmission;
	}


}
