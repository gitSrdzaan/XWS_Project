package xws.microservis.advertservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xws.microservis.advertservice.dto.AdvertDto;

import xws.microservis.advertservice.model.RentAdvert;
import xws.microservis.advertservice.repository.AdvertRepository;

import java.util.ArrayList;

@Service
@Transactional
public class AdvertService {

	@Autowired
	AdvertRepository advertRepository;
	
	@Autowired
	CarService carService;
	
	@Autowired
	PriceListService priceListService;
	
	
	public RentAdvert save(AdvertDto advertDto) {



		RentAdvert advert = advertRepository.findById(advertDto.getId()).orElse(new RentAdvert());
		/***
		 * TODO: GET CAR & GET PRICELIST
		 */
		advert.setAdvertEndDate(advertDto.getAdvertEndDate());
		advert.setAdvertStartDate(advertDto.getAdvertStartDate());
		advert.setCar(carService.findById(advertDto.getCarId()));
		advert.setPriceList(priceListService.findById(advertDto.getPriceListId()));
		if(advertDto.getPriceForRent() != 0.0 && advertDto.getPriceForRent() != null){
			advert.setPriceForRent(advertDto.getPriceForRent());

		}
		
		
		return advertRepository.save(advert);
	}

	public ArrayList<RentAdvert> findByUser(Long id) {

		return advertRepository.findByUserId(id);

	}

	public void deleteAdvert(Long advertId)  throws Exception{
		try{
			advertRepository.deleteById(advertId);

		}
		catch (Exception e){
			e.printStackTrace();
			throw  new Exception("Greska pri brisanju reklame");
		}

	}
}
