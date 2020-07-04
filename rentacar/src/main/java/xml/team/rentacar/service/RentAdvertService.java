package xml.team.rentacar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xml.team.rentacar.model.Firm;
import xml.team.rentacar.model.RentAdvert;
import xml.team.rentacar.repository.FirmRepository;
import xml.team.rentacar.repository.RentAdvertRepository;

@Service
public class RentAdvertService {

	@Autowired
	private RentAdvertRepository rentARepository;
	
	@Autowired
	private FirmRepository firmRepository;
	

	public ArrayList<RentAdvert> findAll() {
		// TODO Auto-generated method stub
		
		List<RentAdvert> raList = rentARepository.findAll();
		
		if(raList == null) {
			return null;
		}
		
		return (ArrayList<RentAdvert>) raList;
	}


	public void addRentAdvert(RentAdvert ra) throws Exception {
		// TODO Auto-generated method stub
		try {
			rentARepository.save(ra);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new Exception("Cuvanje oglasa nije uspjelo");
		}
		
	}


	public ArrayList<RentAdvert> findFirmsAllRentAdvert(Long firmID) {
		// TODO Auto-generated method stub
		Firm firm  = firmRepository.findById(firmID).orElse(null);
		if(firm == null) {
			throw new NoSuchElementException("Firma ne postoji");
		}
		
		List<RentAdvert> listRA = rentARepository.findByFirm(firm);
		
		if(listRA == null) {
			return null;
		}
		
		
		return (ArrayList<RentAdvert>) listRA;
	}
	
	
}
