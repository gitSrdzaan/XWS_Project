package xws.microservis.rentservice.controller;

import java.util.ArrayList;
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
import xws.microservis.rentservice.model.*;
import xws.microservis.rentservice.services.CarService;
import xws.microservis.rentservice.services.FirmService;
import xws.microservis.rentservice.services.RentAdvertService;
import xws.microservis.rentservice.services.RentRequestService;

@RestController
@RequestMapping(value = "/request")
public class RentRequestController {

	@Autowired
	private RentRequestService rentRService;
	@Autowired
	private RentAdvertService rentAService;
	@Autowired
	private FirmService firmService;
	@Autowired
	private CarService carService;


	@GetMapping(path = "/owner/{rentAdvertId}")
	public ResponseEntity<?> findOwner(@PathVariable Long rentAdvertId){
		RentAdvert ra = new RentAdvert();
		try {
		 ra = rentAService.findRentAdvert(rentAdvertId);
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<>("GRESKA Oglas ne postoji", HttpStatus.BAD_REQUEST);
		}

		Firm firm = rentAService.findFirm(ra);
		
		if(firm == null){
			return new ResponseEntity<>("Greska firma nije pronadjena",HttpStatus.NOT_FOUND);
		}
		FirmDTO firmDTO = new FirmDTO(firm);

		return new ResponseEntity<> (firmDTO,HttpStatus.OK);
		

		
	}
	
	
	
	@PostMapping(path = "/new",consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> createRentRequest(@RequestBody RentRequestDTO rrDTO) {
		
		if(rrDTO != null) {
			try {
				rrDTO.setStatus(RentRequestStatus.PENNDING);
				rentRService.saveRentRequest(rrDTO);
				return new ResponseEntity<>(HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>("Greska u cuvanju zahtjeva",HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		}
		return new ResponseEntity<>("Los zahtjev za rentiranje",HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping(path = "/new/bundle",consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> createBundleRequest(@RequestBody List<RentRequestDTO> listRRDTO){
		RentRequestBundle rrb = new RentRequestBundle();
		System.out.println("list " + listRRDTO);
		if(listRRDTO != null || listRRDTO.size()>0) {

			try {
				rrb = rentRService.createRentRequestBundel(listRRDTO);
				return new ResponseEntity<>(HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>("GRESKA u pravljenju bundle zahtjeva i cuvanja ",HttpStatus.INTERNAL_SERVER_ERROR);
			}


		}
		return new ResponseEntity<>("Greska u kreiranju bundle zahtjeva lista prazna",HttpStatus.BAD_REQUEST);

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

	@GetMapping(value = "/all", produces = "application/json")
	public ResponseEntity<?> getAllRentRequest(){
		ArrayList<RentRequest> rentRequestArrayList = rentRService.getAll();

		return new ResponseEntity<>(rentRequestArrayList, HttpStatus.OK);


	}

	@GetMapping(value = "/all/bundle",produces = "application/json")
	public ResponseEntity<?> getAllRentRequestBundle(){
		ArrayList<RentRequestBundle> rentRequestArrayList = rentRService.getAllBundle();

		return new ResponseEntity<>(rentRequestArrayList, HttpStatus.OK);


	}
	
	
	
	
}
