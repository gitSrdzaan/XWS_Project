package xml.team.rentacar.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class CarModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column
	private String model;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mark_id")
	private CarMark mark;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "model")
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
