package xml.team.rentacar.dto;



import xml.team.rentacar.model.RentRequest;
import xml.team.rentacar.model.RentRequestBundle;

import java.util.List;

public class RentRequestBundleDTO {

	private Long id;
	private List<Long> rentRequestList_Id;
	
	public RentRequestBundleDTO(RentRequestBundle rrb) {
		this.id = rrb.getId();
		for(RentRequest rr : rrb.getRentRequest()) {
			this.rentRequestList_Id.add(rr.getId());
		}
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Long> getRentRequestList_Id() {
		return rentRequestList_Id;
	}

	public void setRentRequestList_Id(List<Long> rentRequestList_Id) {
		this.rentRequestList_Id = rentRequestList_Id;
	}

	
}
