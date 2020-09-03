package xws.microservis.rentservice.services;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xws.microservis.rentservice.dto.RentAdvertDTO;
import xws.microservis.rentservice.exception.AdvertNotFoundException;
import xws.microservis.rentservice.model.Firm;
import xws.microservis.rentservice.model.PriceList;
import xws.microservis.rentservice.model.RentAdvert;
import xws.microservis.rentservice.model.User;
import xws.microservis.rentservice.repository.*;

@Service
public class RentAdvertService {
	@Autowired
	private RentAdvertRepository repository;

	@Autowired
	private CarRepository carRepository;

	@Autowired
	private PriceListRepository priceListRepository;

	@Autowired
	private FirmRepository firmRepository;

	@Autowired
	private UserRepository userRepository;



	public RentAdvert findByMonolitId(Long id){

		Optional<RentAdvert> rentAdvert = repository.findByMonolitId(id);

		if(rentAdvert.isPresent()){
			return rentAdvert.get();
		}
		else {
			throw new AdvertNotFoundException();
		}
	}
	
	//pronalazenje reklame
	public RentAdvertDTO findRentAdvertDTO(Long id) {
		RentAdvert ra = repository.findById(id).orElse(null);
		if(ra == null) {
			throw new NoSuchElementException();
		}
		
		return new RentAdvertDTO(ra);
	}
	
	public RentAdvert findRentAdvert(Long id) {
		RentAdvert ra = repository.findById(id).orElse(null);
		if(ra == null) {
			throw new NoSuchElementException();
		}
		
		return ra;
	}


	public Firm findFirm(RentAdvert ra) {

		return repository.findFirmByAdvert(ra.getId());


	}

	public void addNewRentAdvert(RentAdvertDTO advertDTO) {
		RentAdvert advert = repository.findById(advertDTO.getId()).orElse(new RentAdvert());
		
		dto2Advert(advertDTO,advert);

		Firm firm = firmRepository.findById(advertDTO.getOwner_id()).orElse(null);
		if(firm != null){
			advert.setFirm(firm);
		}
		else{
			User user = userRepository.findById(advertDTO.getOwner_id()).orElse(null);
			advert.setUser(user);

		}

		try {
			repository.save(advert);
		}
		catch (Exception e){
			e.printStackTrace();

		}

		
		
	}

	private void dto2Advert(RentAdvertDTO advertDTO, RentAdvert advert) {

		advert.setAdvertEndDate(advertDTO.getAdvertEndDate());
		advert.setAdvertStartDate(advertDTO.getAdvertStartDate());
		advert.setId(advertDTO.getId());
		advert.setPriceForRent(advertDTO.getPriceForRent());
		advert.setCar(carRepository.findById(advertDTO.getCarId()).orElse(null));
		advert.setPriceList(priceListRepository.findById(advertDTO.getPriceListId()).orElse(null));
	}
}
