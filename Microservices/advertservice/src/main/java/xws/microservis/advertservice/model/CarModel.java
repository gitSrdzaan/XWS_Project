package xws.microservis.advertservice.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CarModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column
	private String model;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "mark_id")
	private CarMark mark;
	
	@ManyToMany
	@JoinTable(
			name = "model_class",
			joinColumns = @JoinColumn(name = "model_id"),
			inverseJoinColumns = @JoinColumn(name = "car_class_id")
			)
	private List<CarClass> listCarClass;
	
	public CarModel() {
		this.listCarClass = new ArrayList<CarClass>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public CarMark getMark() {
		return mark;
	}

	public void setMark(CarMark mark) {
		this.mark = mark;
	}

	public List<CarClass> getListCarClass() {
		return listCarClass;
	}

	public void setListCarClass(List<CarClass> listCarClass) {
		this.listCarClass = listCarClass;
	}
	
	
}
