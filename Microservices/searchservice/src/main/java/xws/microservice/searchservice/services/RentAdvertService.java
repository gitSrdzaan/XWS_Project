package xws.microservice.searchservice.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xws.microservice.searchservice.dto.RentAdvertDTO;
import xws.microservice.searchservice.model.Firm;
import xws.microservice.searchservice.model.Owner;
import xws.microservice.searchservice.model.RentAdvert;
import xws.microservice.searchservice.model.User;
import xws.microservice.searchservice.repository.CarRepository;
import xws.microservice.searchservice.repository.OwnerRepository;
import xws.microservice.searchservice.repository.PriceListRepository;
import xws.microservice.searchservice.repository.RentAdvertRepository;

@Service
public class RentAdvertService {

	@Autowired
	private RentAdvertRepository repository;

	@Autowired
	private OwnerRepository ownerRepository;

	@Autowired
	private CarRepository carRepository;

	@Autowired
	private PriceListRepository priceListRepository;
	
	public RentAdvertDTO findRentAdvert(Long id) {
		
		RentAdvert rentAdvert = repository.findById(id).orElse(null);
		
		if(rentAdvert == null)
			throw new NoSuchElementException();
		
		return new RentAdvertDTO(rentAdvert);
		
	}
	
	public List<RentAdvert> searchRentAdvert(double longitude, double latitude, Date advertStartDate, Date advertEndDate) {
		
		List<RentAdvert> rentAdvert = repository.findAll();
		List<RentAdvert> returnList = new ArrayList<RentAdvert>();

		
		/*for(RentAdvert ra : rentAdvert) {
			if(ra.getCar().getLongitude() == longitude && ra.getCar().getLatitude() == latitude && ra.getAdvertStartDate() == advertStartDate && ra.getAdvertEndDate() == advertEndDate) {
				returnList.add(ra);
			
			}
		}
*/
		return returnList;
	}


    public ArrayList<RentAdvert> findByDates(Date startDate, Date endDate,Long firmId) {

		return (ArrayList<RentAdvert>) repository.findByStartEndDate(startDate,endDate,firmId);
    }

    public ArrayList<RentAdvert> findByDatesUser(Date startDate, Date endDate, Long userID) {
		return (ArrayList<RentAdvert>) repository.findByStartEndDateUser(startDate,endDate,userID);
    }

    public void addNewRentAdvert(RentAdvertDTO advertDTO) {
		RentAdvert advert = this.repository.findById(advertDTO.getId()).orElse(new RentAdvert());

		dto2Advert(advertDTO,advert);

		Firm firm = ownerRepository.findOwnerFirm(advertDTO.getOwner_id());
		if(firm != null){
			advert.setOwner(firm);

		}
		else{
			User user = ownerRepository.findOwnerUser(advertDTO.getOwner_id());
			advert.setOwner(user);
		}



		this.repository.save(advert);


    }

	private void dto2Advert(RentAdvertDTO advertDTO, RentAdvert advert) {
		advert.setAdvertEndDate(advertDTO.getAdvertEndDate());
		advert.setAdvertStartDate(advertDTO.getAdvertStartDate());
		//advert.setId(advertDTO.getId());
		advert.setPriceForRent(advertDTO.getPriceForRent());
		advert.setCar(carRepository.findById(advertDTO.getCarId()).orElse(null));
		advert.setPriceList(priceListRepository.findById(advertDTO.getPriceListId()).orElse(null));


	}
}
