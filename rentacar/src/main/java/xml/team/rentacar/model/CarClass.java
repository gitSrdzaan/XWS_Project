package xml.team.rentacar.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class CarClass {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String carClass;
	
	@ManyToMany(mappedBy = "listCarClass")
	private List<CarModel> listCarModel = new ArrayList<CarModel>();
	
	public CarClass() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCarClass() {
		return carClass;
	}

	public void setCarClass(String carClass) {
		this.carClass = carClass;
	}

	public List<CarModel> getListCarModel() {
		return listCarModel;
	}

	public void setListCarModel(List<CarModel> listCarModel) {
		this.listCarModel = listCarModel;
	}

	
	
	
	
}
