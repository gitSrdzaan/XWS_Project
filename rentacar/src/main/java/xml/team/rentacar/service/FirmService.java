package xml.team.rentacar.service;

import org.springframework.beans.factory.annotation.Autowired;

import xml.team.rentacar.model.Firm;
import xml.team.rentacar.repository.FirmRepository;

public class FirmService {

	@Autowired
	private FirmRepository repository;

	public  Firm findFirm(Long firmID) {
		// TODO Auto-generated method stub
		
		
		return repository.findById(firmID).orElse(null);
	}
	
}
