package xml.team.rentacar.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xml.team.rentacar.model.RentAdvert;
import xml.team.rentacar.repository.RentAdvertRepository;

@Service
public class RentAdvertService {

	@Autowired
	private RentAdvertRepository rentARepository;
	

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
	
	
}
