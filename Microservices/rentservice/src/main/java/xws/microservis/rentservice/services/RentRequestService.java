package xws.microservis.rentservice.services;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import org.springframework.web.client.RestTemplate;
import xws.microservis.rentservice.dto.RentRequestBundleDTO;
import xws.microservis.rentservice.dto.RentRequestDTO;
import xws.microservis.rentservice.model.*;
import xws.microservis.rentservice.repository.*;

import javax.jws.soap.SOAPBinding;

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

	@Autowired
	private FirmRepository firmRepository;




	//pronalazenje zahtjeva
	public RentRequestDTO findRentRequest(Long id) {
		
		RentRequest rr = rentRRepository.findById(id).orElse(null);
		
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
			e.printStackTrace();
			throw new Exception("Neuspjesno sacuvan zahtjev");
		}

		/**
		 * TODO : MessageQueue implementacija
		 * */
		RestTemplate newRentRequset = new RestTemplate();
		ResponseEntity<Long> responseEntity = newRentRequset.getForEntity("http://localhost:8086/rentrequest/"+rr.getId(), Long.class);
	}
	
	/**
	 * Cuvanje bundle zahtjeva u bazi
	 * */
	public void saveRentRequestBundle(RentRequestBundleDTO rrbDTO ) throws Exception{
		RentRequestBundle rrb = new RentRequestBundle();
		try {
			//rrb.setId(rrbDTO.getId());
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
			System.out.println(rrb.getRentRequest());
			
			bundleRepository.save(rrb);
		}
		catch(Exception e) {
			throw new Exception("Neuspjesno sacuvan bundle zahtjev");
		}
	}
	
	
	/**
	 * Kreiranje bundle zahtjeva
	 * */
	public RentRequestBundle createRentRequestBundel(List<RentRequestDTO> listRR) throws Exception {
		
		RentRequestBundle rrb = new RentRequestBundle();
		ArrayList<RentRequest> rentRequestArrayList = new ArrayList<>();
	
		
		for (RentRequestDTO rrDTO : listRR) {
			RentRequest rr = new RentRequest();
			//rr.setId(rrDTO.getId());
			rr.setAdvertSender(userRepository.findById(rrDTO.getAdvertSender_Id()).orElse(null));
			rr.setRentAdvert(rentARepository.findById(rrDTO.getRentAdvert_Id()).orElse(null));
			rr.setReservationStart(rrDTO.getReservationStart());
			rr.setReservationEnd(rrDTO.getReservationEnd());
			rr.setStatus(RentRequestStatus.PENNDING);

			rrb.getRentRequest().add(rr);

			this.saveRentRequestBundle(rrb);
			rr.setRentRequestBundle(rrb);
			try{
				rentRRepository.save(rr);
			}
			catch(Exception e){
				e.printStackTrace();
				throw  new Exception("Greska pri cuvanju zahtjeva u bundle");
			}


		}




		return rrb;
		
		
	}
	
	public RentRequestDTO setRentRequestStatus(Date start,Date end, RentRequestStatus status,Long id) {
    	
		RentRequest rr = rentRRepository.findById(id).orElse(null);
		rr.setReservationStart(start);
		rr.setReservationEnd(end);
		rr.setStatus(status);
		/**
		 * TODO: obavjestiti o statusa requesta
		 * */
        
        
 
        
 
        rentRRepository.save(rr);
        return new RentRequestDTO(rr);
    }


    public ArrayList<RentRequest> getAll() {
		return (ArrayList<RentRequest>) rentRRepository.findAll();
    }

	public ArrayList<RentRequestBundle> getAllBundle() {
		return (ArrayList<RentRequestBundle>) bundleRepository.findAll();
	}

	public boolean findBundle(Long id) {

		RentRequestBundle bundle = this.bundleRepository.findById(id).orElse(null);
		if(bundle == null){
			return false;
		}
		return true;

	}

	public void setBundleStatus(RentRequestBundleDTO bundleDTO) throws Exception {
		RentRequestBundle bundle = this.bundleRepository.findById(bundleDTO.getId()).orElse(null);

		for(RentRequest request : bundle.getRentRequest()){
			request.setStatus(bundleDTO.getStatus());
		}



		try{
			this.bundleRepository.save(bundle);
		}
		catch (Exception e){
			e.printStackTrace();
			throw new Exception();
		}

		/**
		 * TODO : obavjestit da je doslo do promjene u bundle status
		 * */



	}

	public ArrayList<RentRequest> getOwnersAll(Long ownerId) {

		ArrayList<RentRequest> retList = new ArrayList<>();

		Firm firm = firmRepository.findById(ownerId).orElse(null);
		if(firm != null){
			findAllOwnerRentRequest(retList,firm.getId(),"firm");
		}
		else{
			User user = userRepository.findById(ownerId).orElse(null);
			findAllOwnerRentRequest(retList,user.getId(),"user");
		}

		return retList;


	}

	private void findAllOwnerRentRequest(ArrayList<RentRequest> retList, Long ownerId,String owner) {
		ArrayList<RentRequest> allRequest = (ArrayList<RentRequest>) rentRRepository.findAll();

		if(owner.equals("firm")){
			for(RentRequest iter : allRequest){
				if(iter.getRentAdvert().getFirm().getId() == ownerId){
					retList.add(iter);
				}

			}
		}
		else{
			for(RentRequest iter : allRequest){
				if(iter.getRentAdvert().getUser().getId() == ownerId){
					retList.add(iter);
				}

			}
		}



	}


	public ArrayList<RentRequestBundle> getAllOwnersBundle(Long ownerId) {
		ArrayList<RentRequestBundle> retList = new ArrayList<>();
		Firm firm = firmRepository.findById(ownerId).orElse(null);
		if(firm != null){
			findOwnersBundle(retList,ownerId, "firm");
		}
		else {
			User user = userRepository.findById(ownerId).orElse(null);
			findOwnersBundle(retList,user.getId(),"user");
		}



	}

	private void findOwnersBundle(ArrayList<RentRequestBundle> retList, Long ownerId, String owner) {
		ArrayList<RentRequestBundle> allBundles = (ArrayList<RentRequestBundle>) bundleRepository.findAll();

		for(RentRequestBundle iter : allBundles){
			if(ownerId == bundleOwner(iter,owner)){
				retList.add(iter);
			}
		}

	}

	private Long bundleOwner(RentRequestBundle iter, String owner) {
		if(owner.equals("firm")){
			return iter.getRentRequest().get(0).getRentAdvert().getFirm().getId();
		}
		else{
			return iter.getRentRequest().get(0).getRentAdvert().getUser().getId();
		}



	}


}
