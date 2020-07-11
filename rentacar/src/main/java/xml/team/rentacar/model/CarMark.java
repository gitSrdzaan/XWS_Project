package xml.team.rentacar.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CarMark {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(unique = true)
	private String mark;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "mark")
	private List<CarModel> listModel;
	
	public CarMark() {
		this.listModel = new ArrayList<CarModel>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public List<CarModel> getListModel() {
		return listModel;
	}

	public void setListModel(List<CarModel> listModel) {
		this.listModel = listModel;
	}
	
}
