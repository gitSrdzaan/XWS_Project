package xws.microservis.rentservice.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xws.microservis.rentservice.dto.FirmDTO;
import xws.microservis.rentservice.dto.RentRequestDTO;
import xws.microservis.rentservice.model.Car;
import xws.microservis.rentservice.model.RentAdvert;
import xws.microservis.rentservice.model.RentRequestBundle;
import xws.microservis.rentservice.model.RentRequestStatus;
import xws.microservis.rentservice.services.CarService;
import xws.microservis.rentservice.services.FirmService;
import xws.microservis.rentservice.services.RentAdvertService;
import xws.microservis.rentservice.services.RentRequestService;

@RestController
@RequestMapping(value = "/iznajmljivanje")
public class RentRequestController {

	@Autowired
	private RentRequestService rentRService;
	@Autowired
	private RentAdvertService rentAService;
	@Autowired
	private FirmService firmService;
	@Autowired
	private CarService carService;
	
	
	@GetMapping(path = "/helloworld")
	public ResponseEntity<?> helloWorld(){
		return new ResponseEntity<> ("HelloWorld iznajmljivanje service", HttpStatus.OK);
	}
	
	
	@GetMapping(path = "/pronalezenjeVlasnika/{rentAdvertId}")
	public ResponseEntity<?> findOwner(@PathVariable Long rentAdvertId){
		RentAdvert ra = new RentAdvert();
		try {
		 ra = rentAService.findRentAdvert(rentAdvertId);
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<>("GRESKA Oglas ne postoji", HttpStatus.BAD_REQUEST);
		}
		
		Car car = ra.getCar();
		
		try {
			FirmDTO fDTO = firmService.findFirmByCar(car);
			if(fDTO == null) {
				return new ResponseEntity<>("GRESKA Auto nije firmin", HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<> (fDTO,HttpStatus.OK);
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<>("GRESKA Auto ne postoji u bazi", HttpStatus.BAD_REQUEST);
		}	
		
	}
	
	
	
	@PostMapping(path = "/kreiranjeZahtjeva",consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> createRentRequest(@RequestBody RentRequestDTO rrDTO) {
		
		if(rrDTO != null) {
			try {
				rrDTO.setStatus(RentRequestStatus.PENNDING);
				rentRService.saveRentRequest(rrDTO);
			} catch (Exception e) {
				return new ResponseEntity<>("Greska u cuvanju zahtjeva",HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		}
		return new ResponseEntity<>("Los zahtjev za rentiranje",HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping(path = "/kreiranjeBundleZahtjeva",consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> createBundleRequest(@RequestBody List<RentRequestDTO> listRRDTO){
		RentRequestBundle rrb = new RentRequestBundle();
		if(listRRDTO != null || listRRDTO.size()>0) {
			
			rrb = rentRService.createRentRequestBundel(listRRDTO);
				
			if(rrb == null) {
				return new ResponseEntity<>("GRESKA u pravljenju bundle zahtjeva ",HttpStatus.INTERNAL_SERVER_ERROR);
			}
			try {
				rentRService.saveRentRequestBundle(rrb);
			}
			catch(Exception e) {
				return new ResponseEntity<>("Greska u kreiranju bundle zahtjeva",HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<>("Greska u kreiranju bundle zahtjeva",HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
	@PostMapping(path = "/setRentRequestStatus", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> setRentRequestStatus(@RequestBody RentRequestDTO rentRDTO) {
		RentRequestDTO rrDTO = rentRService.findRentRequest(rentRDTO.getId());
		
		if(rrDTO != null) {
			try {
				rrDTO = rentRService.setRentRequestStatus(rentRDTO.getReservationStart(),rentRDTO.getReservationEnd(),rentRDTO.getStatus(),rentRDTO.getId());
				return new ResponseEntity<>("Status changed",HttpStatus.OK);
				
			} catch (Exception e) {
				return new ResponseEntity<>("Unexpected error",HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		}
		return new ResponseEntity<>("No rent request",HttpStatus.BAD_REQUEST);
	}
	
	
	
	
	
}
