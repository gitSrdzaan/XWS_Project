package xws.microservis.rentservice.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xws.microservis.rentservice.dto.RentRequestDTO;
import xws.microservis.rentservice.model.RentRequestBundle;
import xws.microservis.rentservice.model.RentRequestStatus;
import xws.microservis.rentservice.services.RentRequestService;

@RestController
@RequestMapping(value = "/iznajmljivanje")
public class RentRequestController {

	@Autowired
	private RentRequestService rentRService;
	
	
	@PostMapping(path = "/kreiranjeZahtjeva")
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
	
	@PostMapping(path = "/kreiranjeBundleZahtjeva")
	public ResponseEntity<?> createBundleRequest(@RequestBody List<RentRequestDTO> listRRDTO){
		RentRequestBundle rrb = new RentRequestBundle();
		if(listRRDTO != null || listRRDTO.size()>0) {
			try {
				 rrb = rentRService.createRentRequestBundel(listRRDTO);
				
			}
			catch(Exception e) {
				return new ResponseEntity<>("Greska u kreiranju bundle zahtjeva",HttpStatus.INTERNAL_SERVER_ERROR);
			}
			if(rrb == null) {
				return new ResponseEntity<>("Prazan bundle zahtjev ",HttpStatus.INTERNAL_SERVER_ERROR);
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
	
	@PostMapping(path = "/setRentRequestStatus")
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
