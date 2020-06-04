package xws.microservis.rentservice.services;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import xws.microservis.rentservice.dto.RentRequestBundleDTO;
import xws.microservis.rentservice.dto.RentRequestDTO;
import xws.microservis.rentservice.model.RentRequest;
import xws.microservis.rentservice.model.RentRequestBundle;
import xws.microservis.rentservice.model.RentRequestStatus;
import xws.microservis.rentservice.repository.RentRequestBundleRepository;
import xws.microservis.rentservice.repository.RentRequestRepository;

@Service
public class RentRequestService {

	@Autowired
	private RentRequestRepository rentRepository;
	
	@Autowired
	private RentRequestBundleRepository bundleRepository;
	
	//pronalazenje zahtjeva
	public RentRequestDTO findRentRequest(Long id) {
		
		RentRequest rr = rentRepository.findById(id).orElse(null);
		
		if(rr == null) {
			throw new NoSuchElementException();
		}
		return new RentRequestDTO(rr);
	}
	
	/**
	 * Cuvanje zahtjeva u bazi
	 * */
	public void saveRentRequest(RentRequestDTO rrDTO) throws Exception {
		RentRequest rr = new RentRequest();
		try {
			rr.setId(rrDTO.getId());
			rr.setAdvertSender(rrDTO.getAdvertSender());
			rr.setRentAdvert(rrDTO.getRentAdvert());
			rr.setReservationStart(rrDTO.getReservationStart());
			rr.setReservationEnd(rrDTO.getReservationEnd());
			rr.setStatus(rrDTO.getStatus());
			
			rentRepository.save(rr);
			
		}
		catch(Exception e) {
			throw new Exception("Neuspjesno sacuvan zahtjev");
		}
	}
	
	/**
	 * Cuvanje bundle zahtjeva u bazi
	 * */
	public void saveRentRequestBundle(RentRequestBundleDTO rrbDTO ) throws Exception{
		RentRequestBundle rrb = new RentRequestBundle();
		try {
			rrb.setId(rrbDTO.getId());
			rrb.setRentRequest(rrbDTO.getRentRequestList());
			
			bundleRepository.save(rrb);
		}
		catch(Exception e) {
			throw new Exception("Neuspjesno sacuvan bundle zahtjev DTO");
		}
	}
	public void saveRentRequestBundle(RentRequestBundle rrb ) throws Exception{
		//RentRequestBundle rrb = new RentRequestBundle();
		try {
			//rrb.setId(rrbDTO.getId());
			//rrb.setRentRequest(rrbDTO.getRentRequestList());
			
			bundleRepository.save(rrb);
		}
		catch(Exception e) {
			throw new Exception("Neuspjesno sacuvan bundle zahtjev");
		}
	}
	
	
	/**
	 * Kreiranje bundle zahtjeva
	 * */
	public RentRequestBundle createRentRequestBundel(List<RentRequestDTO> listRR) {
		
		RentRequestBundle rrb = new RentRequestBundle();
	
		
		for (RentRequestDTO rrDTO : listRR) {
			RentRequest rr = new RentRequest();
			rr.setId(rrDTO.getId());
			rr.setAdvertSender(rrDTO.getAdvertSender());
			rr.setRentAdvert(rrDTO.getRentAdvert());
			rr.setReservationStart(rrDTO.getReservationStart());
			rr.setReservationEnd(rrDTO.getReservationEnd());
			rr.setStatus(rrDTO.getStatus());
			
			rrb.getRentRequest().add(rr);
			
		}
		
		return rrb;
		
		
	}
	
	public RentRequestDTO setRentRequestStatus(Date start,Date end, RentRequestStatus status,Long id) {
    	
		RentRequest rr = rentRepository.findById(id).orElse(null);
		rr.setReservationStart(start);
		rr.setReservationEnd(end);
		rr.setStatus(status);
        
        
 
        
 
        rentRepository.save(rr);
        return new RentRequestDTO(rr);
    }
	
	
	
}
