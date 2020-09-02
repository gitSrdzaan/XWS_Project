package xws.microservis.advertservice.service;

import com.baeldung.springsoap.gen.GetRentAdvertRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xws.microservis.advertservice.dto.AdvertDto;

import xws.microservis.advertservice.exception.AdvertNotFoundException;
import xws.microservis.advertservice.model.Car;
import xws.microservis.advertservice.model.PriceList;
import xws.microservis.advertservice.model.RentAdvert;
import xws.microservis.advertservice.repository.AdvertRepository;
import xws.microservis.advertservice.repository.CarRepository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Optional;

@Service
@Transactional
public class AdvertService {

	@Autowired
	AdvertRepository advertRepository;
	
	@Autowired
	CarService carService;
	
	@Autowired
	PriceListService priceListService;

	@Autowired
	CarRepository carRepository;


	public RentAdvert findById(Long id){
		Optional<RentAdvert> rentAdvert = advertRepository.findById(id);

		if(rentAdvert.isPresent()){
			return rentAdvert.get();
		}
		else {
			throw new AdvertNotFoundException();
		}
	}

	public RentAdvert findByMonolitId(Long id){

		Optional<RentAdvert> rentAdvert = advertRepository.findByMonolitId(id);

		if(rentAdvert.isPresent()){
			return rentAdvert.get();
		}
		else {
			throw new AdvertNotFoundException();
		}
	}

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

	public Long addNewAdvertSoap(GetRentAdvertRequest request){
		RentAdvert rentAdvert = new RentAdvert();
		System.out.println(request.getRentAdvert().getId());
		rentAdvert.setMonolitId(request.getRentAdvert().getId());
		rentAdvert.setCar(carService.findById(request.getRentAdvert().getCarId()));
		rentAdvert.setPriceList(priceListService.findById(request.getRentAdvert().getPriceListId()));
		SimpleDateFormat formatter=new SimpleDateFormat("EEE MMM dd HH:mm:ss zzzz yyyy");
		try {
			rentAdvert.setAdvertEndDate(formatter.parse(request.getRentAdvert().getAdvertEndDate()));
			rentAdvert.setAdvertStartDate(formatter.parse(request.getRentAdvert().getAdvertStartDate()));
		}catch (Exception e){
			System.out.println("Datum za advert nije moguce parsirat");
			e.printStackTrace();
		}

		RentAdvert savedAdvert = advertRepository.save(rentAdvert);

		return savedAdvert.getId();
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
