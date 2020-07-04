package xml.team.rentacar.service;

import org.springframework.beans.factory.annotation.Autowired;

import xml.team.rentacar.model.PriceList;
import xml.team.rentacar.repository.PriceListRepository;

public class PriceListService {

	@Autowired
	private PriceListRepository repository;

	public PriceList findPriceList(Long priceListID) {
		// TODO Auto-generated method stub
		return repository.findById(priceListID).orElse(null);
	}
	
	
}
