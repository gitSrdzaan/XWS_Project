package xml.team.rentacar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xml.team.rentacar.model.Firm;
import xml.team.rentacar.model.PriceList;
import xml.team.rentacar.repository.FirmRepository;
import xml.team.rentacar.repository.PriceListRepository;
@Service
public class PriceListService {

	@Autowired
	private PriceListRepository repository;
	
	@Autowired
	private FirmRepository firmRepository;

	public PriceList findPriceList(Long priceListID) {
		// TODO Auto-generated method stub
		return repository.findById(priceListID).orElse(null);
	}

	public ArrayList<PriceList> findAllFirmPL(Long id) {
		// TODO Auto-generated method stub
		Firm firm = firmRepository.findById(id).orElse(null);
		if(firm == null) {
			throw new NoSuchElementException("Ne postoji firma sa tim ide");
		}
		
		List<PriceList> listPL = repository.findByFirm(firm);
		
		if(listPL == null) {
			return null;
		}
		
		
		return (ArrayList<PriceList>) listPL;
	}

	public void addNewPriceList(PriceList pl) throws Exception {
		try {
			repository.save(pl);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new Exception("Greska pri cuvanju cjenovnika");
		}
		// TODO Auto-generated method stub
		
	}
	
	
}
