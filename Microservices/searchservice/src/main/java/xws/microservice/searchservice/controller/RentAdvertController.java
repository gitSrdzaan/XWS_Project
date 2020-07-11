package xws.microservice.searchservice.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import xws.microservice.searchservice.dto.CarDTO;
import xws.microservice.searchservice.dto.RentAdvertDTO;
import xws.microservice.searchservice.model.*;
import xws.microservice.searchservice.services.CarService;
import xws.microservice.searchservice.services.FirmService;
import xws.microservice.searchservice.services.RentAdvertService;
import xws.microservice.searchservice.services.UserService;

@RestController
@RequestMapping(value = "/pretrazivanje")
public class RentAdvertController {

	@Autowired
	private RentAdvertService rentAdvertService;
	
	@Autowired
	private CarService carService;

	@Autowired
	private FirmService firmService;

	@Autowired
	private UserService userService;



	/**
	 * Ucitavanje podataka korisnika i pretraga za potrebnim oglasima
	 * */
	@PostMapping(value ="/podaci", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> searchForRentAdverts(@RequestBody SearchInfo searchInfo){


		ArrayList<RentAdvert> returnList = new ArrayList<>();

		ArrayList<Firm> firmArrayList = firmService.findAllFirmsByPlace(searchInfo.getCountry(),searchInfo.getCity());



		if(firmArrayList == null){
			return new ResponseEntity<>("Lista firmi je prazna za dato mjesto",HttpStatus.BAD_REQUEST);
		}

		try{
			for(Firm firm : firmArrayList){
				ArrayList<RentAdvert> rentAdverts = getAllAccessableRentAdverts(firm,searchInfo);
				if(rentAdverts == null){

					continue;
				}
				for(RentAdvert iterRentAdvert : rentAdverts){

					RentAdvert rentAdvert = computeAdvancedSearch(iterRentAdvert,searchInfo);
					if(rentAdvert == null){

						continue;
					}
					returnList.add(rentAdvert);
				}


			}

		}
		catch (Exception e){
			e.printStackTrace();
			return new ResponseEntity<>("Greska pri pretrazi oglasa",HttpStatus.INTERNAL_SERVER_ERROR);
		}

		/**
		 * lista user oglasa
		 * */
		ArrayList<User> userArrayList = userService.findUsersByLocation(searchInfo.getCountry(),searchInfo.getCity());

		if(userArrayList == null){
			return new ResponseEntity<>("Lista firmi je prazna za dato mjesto",HttpStatus.BAD_REQUEST);
		}
		try{
			for(User user : userArrayList){
				ArrayList<RentAdvert> rentAdverts = getAllAccessableRentAdvertsUser(user,searchInfo);
				if(rentAdverts == null){

					continue;
				}
				for(RentAdvert iterRentAdvert : rentAdverts){
					RentAdvert rentAdvert = computeAdvancedSearch(iterRentAdvert,searchInfo);
					if(rentAdvert == null){

						continue;
					}
					returnList.add(rentAdvert);
				}


			}

		}
		catch (Exception e){
			e.printStackTrace();
			return new ResponseEntity<>("Greska pri pretrazi oglasa",HttpStatus.INTERNAL_SERVER_ERROR);
		}


		return new ResponseEntity<>(returnList,HttpStatus.OK);
	}

	/**
	 * Svi oglasi usera koji zadovoljavaju kriterijume pretrage
	 * */
	private ArrayList<RentAdvert> getAllAccessableRentAdvertsUser(User user, SearchInfo searchInfo) {
		return rentAdvertService.findByDatesUser(
				searchInfo.getStartDate(),searchInfo.getEndDate(),user.getId());
	}

	/**
	 * Svi oglasi koji zadovoljavaju kriterijume  pretrage
	 * */
	private ArrayList<RentAdvert> getAllAccessableRentAdverts(Firm firm, SearchInfo searchInfo){
		return rentAdvertService.findByDates(
				searchInfo.getStartDate(),searchInfo.getEndDate(),firm.getId());
	}

	/**
	 * Oglas koji zadovoljava kirerijum napredne pretrage
	 * */
	private RentAdvert computeAdvancedSearch(RentAdvert rentAdvert, SearchInfo searchInfo){

		if(searchInfo.getCarMark() != null ){
			/*System.out.println("pretraga marka /t"+searchInfo.getCarMark());
			System.out.println("pretraga marka /t"+rentAdvert.getCar().getCarMark());*/
			if(!rentAdvert.getCar().getCarMark().equals(searchInfo.getCarMark())){
				return null;
			}
		}
		if(searchInfo.getCarModel() != null){
			if(!rentAdvert.getCar().getCarModel().equals(searchInfo.getCarModel())){
				return null;
			}
		}
		if(searchInfo.getCarClass() != null){
			if(!rentAdvert.getCar().getCarClass().equals(searchInfo.getCarClass())   ){
				return null;
			}
		}
		if(searchInfo.getCarFuel() != null){
			if(!rentAdvert.getCar().getCarFuel().getFuel().equals(searchInfo.getCarFuel())){
				return null;
			}
		}
		if(searchInfo.getTransmission() != null){
			if(!rentAdvert.getCar().getTransmission().getTransmission().equals(searchInfo.getTransmission()) ){
				return null;
			}
		}
		if(searchInfo.getKidsSeats() != null){
			if(rentAdvert.getCar().getKidsSeats() != null){
				if(rentAdvert.getCar().getKidsSeats() < searchInfo.getKidsSeats()){
					return null;
				}
			}
		}
		if(searchInfo.getCarMileage() != null){
			if(rentAdvert.getCar().getCarMileage() > searchInfo.getCarMileage()){
				return null;
			}
		}


		rentAdvert.setPriceForRent(computePriceOfRent(rentAdvert,searchInfo));


		if(searchInfo.getPriceLowerBound() != null ){
			if(rentAdvert.getPriceForRent() < searchInfo.getPriceLowerBound()){
				return null;
			}
		}
		if(searchInfo.getPriceUpperBound() != null){
			if(rentAdvert.getPriceForRent() > searchInfo.getPriceUpperBound()){
				return null;
			}
		}



		return rentAdvert;

	}
	/**
	 * Racunanje cijene oglasa za izadavanje
	 * */
	private Double computePriceOfRent(RentAdvert rentAdvert, SearchInfo searchInfo) {

		Double retPrice = 0.0;
		PriceList priceList = rentAdvert.getPriceList();

		//cijena za sve dane
		Long daysTime = searchInfo.getEndDate().getTime() - searchInfo.getStartDate().getTime();
		Integer days = Math.toIntExact(daysTime / (1000 * 60 * 60 * 24));
		retPrice = priceList.getPricePerDay()*days;

		//cijena za stetu
		if(searchInfo.isEnableCDW()){
			retPrice += priceList.getPriceCDW();
		}

		//cijena po kilometrazi
		if(searchInfo.getIntendingMileage() !=  null){
			if(rentAdvert.getCar().getMaxAllowedMileage() != 0){
				retPrice += priceList.getPricePerKilometer() *
						(searchInfo.getIntendingMileage() - rentAdvert.getCar().getMaxAllowedMileage());
			}
		}


		return retPrice;
	}


}
