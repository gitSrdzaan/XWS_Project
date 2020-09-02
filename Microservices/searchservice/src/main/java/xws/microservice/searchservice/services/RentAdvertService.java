package xws.microservice.searchservice.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xws.microservice.searchservice.dto.RentAdvertDTO;
import xws.microservice.searchservice.model.RentAdvert;
import xws.microservice.searchservice.repository.RentAdvertRepository;

@Service
public class RentAdvertService {

	@Autowired
	private RentAdvertRepository repository;
	
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
	//OVO SAM DODAO
	/*public ArrayList<RentAdvert> getAll() {

		return (ArrayList<RentAdvert>) repository.findAll();
	}*/

    public ArrayList<RentAdvert> findByDates(Date startDate, Date endDate,Long firmId) {

		return (ArrayList<RentAdvert>) repository.findByStartEndDate(startDate,endDate,firmId);
    }

    public ArrayList<RentAdvert> findByDatesUser(Date startDate, Date endDate, Long userID) {
		return (ArrayList<RentAdvert>) repository.findByStartEndDateUser(startDate,endDate,userID);
    }
}
