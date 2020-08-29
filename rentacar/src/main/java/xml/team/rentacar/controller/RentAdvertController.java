package xml.team.rentacar.controller;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import xml.team.rentacar.dto.RentAdvertDTO;
import xml.team.rentacar.model.Car;
import xml.team.rentacar.model.Firm;
import xml.team.rentacar.model.PriceList;
import xml.team.rentacar.model.RentAdvert;
import xml.team.rentacar.service.CarService;
import xml.team.rentacar.service.FirmService;
import xml.team.rentacar.service.PriceListService;
import xml.team.rentacar.service.RentAdvertService;

import javax.websocket.server.PathParam;


@RestController
@RequestMapping(value = "/oglas")
public class RentAdvertController {

	@Autowired
	private RentAdvertService rentService;
	
	@Autowired
	private CarService carService;
	
	@Autowired
	private PriceListService priceService;

	@Autowired
	private FirmService firmService;
	
	
	
	
	@GetMapping(value="/svi/{firmID}", produces = "application/json")
	public ResponseEntity<?> findAllRentAdvert(@PathVariable Long firmID){
		
		ArrayList<RentAdvert> raList = rentService.findFirmsAllRentAdvert(firmID);
		
		if(raList == null) {
			return new ResponseEntity<>("Greska u izlistavanju oglasa", HttpStatus.NOT_ACCEPTABLE);
		}
		
		return new ResponseEntity<>(raList,HttpStatus.OK);
	}
	
	@PostMapping(value = "/novi",consumes = "application/json", produces ="application/json")
	public ResponseEntity<?> aoddNewRentAdvert(@RequestBody RentAdvertDTO raDTO){
		
		Car car = carService.findCar(raDTO.getCarID());
		if(car == null) {
			return new ResponseEntity<>("Auto nije izabran", HttpStatus.BAD_REQUEST);
		}
		
		PriceList pl =  priceService.findPriceList(raDTO.getPriceListID());
		if(pl == null ) {
			return new ResponseEntity<> ("Greksa u cjenovniku", HttpStatus.BAD_REQUEST);
		}

		Firm firm  = firmService.findFirm(raDTO.getFirm());
		if(firm == null){
			return new ResponseEntity<> ("Greksa u pronalzenju firme", HttpStatus.BAD_REQUEST);

		}
		
		try {
			RentAdvert ra = new RentAdvert();
			ra.setId(raDTO.getId());
			ra.setCar(car);
			ra.setAdvertStartDate(raDTO.getAdvertStartDate());
			ra.setAdvertEndDate(raDTO.getAdvertEndDate());
			ra.setPriceList(pl);
			ra.setPriceForRent(raDTO.getPriceForRent());
			ra.setFirm(firm);
			rentService.addRentAdvert(ra);
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Greska pri upisivanja oglasa", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(HttpStatus.OK);
		
	}

	@PutMapping(value = "/modify", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> modifyRentAdvert(@RequestBody RentAdvertDTO rentAdvertDTO){

		try{
			rentService.modifyAdvert(rentAdvertDTO);

		}
		catch (NoSuchElementException e){
			e.printStackTrace();
			return new ResponseEntity<>("Rentacar: izmjena reklame - los zahtjev",HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Rentacar: izmjena reklame",HttpStatus.INTERNAL_SERVER_ERROR);

		}


		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete/{id}", produces = "application/json")
	public ResponseEntity<?> deleteRentAdvert(@PathVariable ("id") Long id){
		try {
			rentService.deleteRentAdvert(id);
		} catch (NoSuchElementException ne){
			ne.printStackTrace();
			return new ResponseEntity<>("Rentacar: izmjena reklame - los zahtjev",HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Rentacar: brisanje reklame",HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
