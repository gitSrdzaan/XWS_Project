package xml.team.rentacar.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity 
public class RentRequestBundle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "rentRequestBundle")
	private List<RentRequest> rentRequest;
	
	public RentRequestBundle() {
		this.rentRequest = new ArrayList<RentRequest>();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<RentRequest> getRentRequest() {
		return rentRequest;
	}

	public void setRentRequest(List<RentRequest> rentRequest) {
		this.rentRequest = rentRequest;
	}
}
