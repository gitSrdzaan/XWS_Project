package xml.team.rentacar.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xml.team.rentacar.dto.RentAdvertDTO;
import xml.team.rentacar.model.Car;
import xml.team.rentacar.model.PriceList;
import xml.team.rentacar.model.RentAdvert;
import xml.team.rentacar.service.CarService;
import xml.team.rentacar.service.PriceListService;
import xml.team.rentacar.service.RentAdvertService;


@RestController
@RequestMapping(value = "/oglas")
public class RentAdvertController {

	@Autowired
	private RentAdvertService rentService;
	
	@Autowired
	private CarService carService;
	
	@Autowired
	private PriceListService priceService;
	
	
	
	
	@GetMapping(value="/svi/{firmID}")
	public ResponseEntity<?> findAllRentAdvert(@PathVariable Long firmID){
		
		ArrayList<RentAdvert> raList = rentService.findFirmsAllRentAdvert(firmID);
		
		if(raList == null) {
			return new ResponseEntity<>("Greska u izlistavanju oglasa", HttpStatus.NOT_ACCEPTABLE);
		}
		
		return new ResponseEntity<>(raList,HttpStatus.OK);
	}
	
	@PostMapping(value = "/novi",consumes = "application/json", produces ="application/json")
	public ResponseEntity<?> addNewRentAdvert(@RequestBody RentAdvertDTO raDTO){
		
		Car car = carService.findCar(raDTO.getCarID());
		if(car == null) {
			return new ResponseEntity<>("Auto nije izabran", HttpStatus.BAD_REQUEST);
		}
		
		PriceList pl =  priceService.findPriceList(raDTO.getPriceListID());
		if(pl == null ) {
			return new ResponseEntity<> ("Greksa u cjenovniku", HttpStatus.BAD_REQUEST);
		}
		
		try {
			RentAdvert ra = new RentAdvert();
			ra.setCar(car);
			ra.setAdvertStartDate(raDTO.getAdvertStartDate());
			ra.setAdvertEndDate(raDTO.getAdvertEndDate());
			ra.setPriceList(pl);
			rentService.addRentAdvert(ra);
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Greska pri upisivanja oglasa", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
}
