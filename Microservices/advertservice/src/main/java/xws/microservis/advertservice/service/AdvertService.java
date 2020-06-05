package xws.microservis.advertservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xws.microservis.advertservice.dto.AdvertDto;
import xws.microservis.advertservice.model.Advert;
import xws.microservis.advertservice.repository.AdvertRepository;

@Service
@Transactional
public class AdvertService {

	@Autowired
	AdvertRepository advertRepository;
	
	@Autowired
	CarService carService;
	
	@Autowired
	PriceListService priceListService;
	
	
	public Advert save(AdvertDto advertDto) {
		
		Advert advert = new Advert();
		/***
		 * TODO: GET CAR & GET PRICELIST
		 */
		advert.setAdvertEndDate(advertDto.getAdvertEndDate());
		advert.setAdvertStartDate(advertDto.getAdvertStartDate());
		advert.setCar(carService.findById(advertDto.getCarId()));
		advert.setPriceList(priceListService.findById(advertDto.getPriceListId()));
		
		
		return advertRepository.save(advert);
	}
}
