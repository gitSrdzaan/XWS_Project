package xws.microservis.advertservice.service;

import java.util.Optional;

import com.baeldung.springsoap.gen.GetPriceListRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xws.microservis.advertservice.exception.PriceListNotFoundException;
import xws.microservis.advertservice.model.PriceList;
import xws.microservis.advertservice.repository.PriceListRepository;

@Service
@Transactional
public class PriceListService {
	
	@Autowired
	PriceListRepository priceListRepository;
	
	
	public PriceList findById(Long id) {
		
		Optional<PriceList> priceList = priceListRepository.findById(id);
		
		if(priceList.isPresent()) {
			
			return priceList.get();
		}else {
			throw new PriceListNotFoundException(id);
		}
	}

	public Long addNewPriceListSoap(GetPriceListRequest request){
		PriceList priceList = new PriceList(request.getPriceList());
		PriceList savedPL = priceListRepository.save(priceList);
		return savedPL.getId();
	}
}
