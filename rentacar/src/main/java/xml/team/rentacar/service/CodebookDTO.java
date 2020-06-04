package xml.team.rentacar.service;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

public class CodebookDTO {
	
	private Long id;
    

	private List<String> car_model;
    private List<String> fuel_type;
    private List<String> car_class;
    private List<String> car_transmission;
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CodebookDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CodebookDTO(Long id, List<String> car_model, List<String> fuel_type, List<String> car_class,
			List<String> car_transmission) {
		super();
		this.id=id;
		this.car_model = car_model;
		this.fuel_type = fuel_type;
		this.car_class = car_class;
		this.car_transmission = car_transmission;
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
