package xws.microservis.rentservice.dto;

import java.util.List;

import xws.microservis.rentservice.model.RentRequest;
import xws.microservis.rentservice.model.RentRequestBundle;

public class RentRequestBundleDTO {

	private Long id;
	private List<RentRequest> rentRequestList;
	
	public RentRequestBundleDTO(RentRequestBundle rrb) {
		this.id = rrb.getId();
		this.rentRequestList = rrb.getRentRequest();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<RentRequest> getRentRequestList() {
		return rentRequestList;
	}

	public void setRentRequestList(List<RentRequest> rentRequestList) {
		this.rentRequestList = rentRequestList;
	}
}
