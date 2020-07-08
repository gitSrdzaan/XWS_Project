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
import xws.microservice.searchservice.model.Car;
import xws.microservice.searchservice.model.Firm;
import xws.microservice.searchservice.model.RentAdvert;
import xws.microservice.searchservice.model.SearchInfo;
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

	
	@GetMapping(path = "/pretrazivanjeAutomobila/{raId}")
	public ResponseEntity<?> searchRentAdvert(@PathVariable Long raId){

		RentAdvertDTO rentAdvert = new RentAdvertDTO();
		
		try {
			rentAdvert = rentAdvertService.findRentAdvert(raId);
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<>("Ne postoji oglas", HttpStatus.BAD_REQUEST);
		}
		
		//Car car = rentAdvert.getCar();
		
		try {
			CarDTO carDTO = carService.findCar(raId);
			if(carDTO == null) {
				return new ResponseEntity<>("Auto ne pripada oglasu", HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<>(carDTO, HttpStatus.OK);
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<>("Automobil ne postoji", HttpStatus.BAD_REQUEST);
		}
		
		/*
		try {
			List<RentAdvert> rentAdvert = rentAdvertService.searchRentAdvert(ra.getCar().getLongitude(), ra.getCar().getLatitude(), ra.getAdvertStartDate(), ra.getAdvertEndDate());
				return new ResponseEntity<>(rentAdvert.getClass(), HttpStatus.OK);
			
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<>("Ni jedan auto ne odgovara parametrima", HttpStatus.BAD_REQUEST);
		}	

		*/
	}


	/**
	 * Ucitavanje podataka korisnika i pretraga za potrebnim oglasima
	 * */
	@PostMapping(value ="/podaci", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> searchForRentAdverts(@RequestBody SearchInfo searchInfo){
		ArrayList<ArrayList<RentAdvert>> returnList = new ArrayList<>();

		ArrayList<Firm> firmArrayList = firmService.findAllFirmsByPlace(searchInfo.getCountry(),searchInfo.getCity());

		if(firmArrayList == null){
			return new ResponseEntity<>("Lista firmi je prazna za dato mjesto",HttpStatus.BAD_REQUEST);
		}

		try{
			for(Firm firm : firmArrayList){
				ArrayList<RentAdvert> rentAdverts = rentAdvertService.findByDates(
						searchInfo.getStartDate(),searchInfo.getEndDate(),firm.getId());
				if(rentAdverts == null){
					continue;
				}
				returnList.add(rentAdverts);

			}

		}
		catch (Exception e){
			e.printStackTrace();
			return new ResponseEntity<>("Greska pri pretrazi oglasa",HttpStatus.INTERNAL_SERVER_ERROR);
		}


		return new ResponseEntity<>(returnList,HttpStatus.OK);
	}
	
}
