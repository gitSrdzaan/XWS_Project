package xml.team.rentacar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xml.team.rentacar.dto.RentRequestDTO;
import xml.team.rentacar.model.RentRequest;
import xml.team.rentacar.model.RentRequestBundle;
import xml.team.rentacar.model.RentRequestStatus;
import xml.team.rentacar.repository.RentAdvertRepository;
import xml.team.rentacar.repository.RentRequestBundleRepository;
import xml.team.rentacar.repository.RentRequestRepository;
import xml.team.rentacar.repository.UserRepository;

import xml.team.rentacar.dto.RentRequestBundleDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RentRequestService {

	@Autowired
	private RentRequestRepository rentRRepository;
	
	@Autowired
	private RentRequestBundleRepository bundleRepository;
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RentAdvertRepository rentARepository;
	
	//pronalazenje zahtjeva
	public RentRequestDTO findRentRequestDTO(Long id) {
		
		RentRequest rr = rentRRepository.findById(id).orElse(null);
		
		if(rr == null) {
			throw new NoSuchElementException();
		}
		return new RentRequestDTO(rr);
	}


	public RentRequest findRentRequest(Long id) {

		RentRequest rr = rentRRepository.findById(id).orElse(null);

		if(rr == null) {
			throw new NoSuchElementException();
		}
		return rr;
	}
	
	/**
	 * Cuvanje zahtjeva u bazi
	 * */
	public void saveRentRequestDTO(RentRequestDTO rrDTO) throws Exception {
		RentRequest rr = new RentRequest();
		try {
			//rr.setId(rrDTO.getId());
			rr.setAdvertSender(userRepository.findById(rrDTO.getAdvertSender_Id()).orElse(null));
			if(rr.getAdvertSender() == null){
				throw  new Exception("Korisnik koji salje zahtjev nije validan");
			}
			rr.setRentAdvert(rentARepository.findById(rrDTO.getRentAdvert_Id()).orElse(null));
			if(rr.getRentAdvert() == null){
				throw new Exception("Oglas nije izabran");
			}
			rr.setReservationStart(rrDTO.getReservationStart());
			rr.setReservationEnd(rrDTO.getReservationEnd());
			rr.setStatus(rrDTO.getStatus());
			
			rentRRepository.save(rr);
			
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
			for(Long rr_Id  : rrbDTO.getRentRequestList_Id()) {
				rrb.getRentRequest().add(rentRRepository.findById(rr_Id).orElse(null));
			}
			
			
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
			rr.setAdvertSender(userRepository.findById(rrDTO.getAdvertSender_Id()).orElse(null));
			rr.setRentAdvert(rentARepository.findById(rrDTO.getRentAdvert_Id()).orElse(null));
			rr.setReservationStart(rrDTO.getReservationStart());
			rr.setReservationEnd(rrDTO.getReservationEnd());
			rr.setStatus(rrDTO.getStatus());
			
			rrb.getRentRequest().add(rr);
			
		}
		
		return rrb;
		
		
	}
	
	public RentRequestDTO setRentRequestStatus(Date start, Date end, RentRequestStatus status, Long id) {
    	
		RentRequest rr = rentRRepository.findById(id).orElse(null);
		rr.setReservationStart(start);
		rr.setReservationEnd(end);
		rr.setStatus(status);
        
        
 
        
 
        rentRRepository.save(rr);
        return new RentRequestDTO(rr);
    }


	public ArrayList<RentRequest> getAll() {

		return (ArrayList<RentRequest>) rentRRepository.findAll();

	}


	public ArrayList<RentRequest> getAllPending() {

		return (ArrayList<RentRequest>) rentRRepository.findAllStatus(RentRequestStatus.PENNDING);

	}

	public void saveRentRequest(RentRequest rentRequest) throws Exception {
		try{
			rentRRepository.save(rentRequest);
		}
		catch(Exception e){
			e.printStackTrace();
			throw  new Exception("Greska pri cuvanju zahtjeva");
		}

	}

    public RentRequestBundle findRentRequestBundle(Long bundleId) {

		return bundleRepository.findById(bundleId).orElse(null);
    }

	public ArrayList<RentRequestBundle> getAllBundle() {
		return (ArrayList<RentRequestBundle>) bundleRepository.findAll();
	}
}
