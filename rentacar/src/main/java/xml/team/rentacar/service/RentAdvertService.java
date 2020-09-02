package xml.team.rentacar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import com.baeldung.soap.ws.client.generated.GetRentAdvertRequest;
import com.baeldung.soap.ws.client.generated.GetRentAdvertResponse;
import com.baeldung.soap.ws.client.generated.RentAdvertPort;
import com.baeldung.soap.ws.client.generated.RentAdvertPortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;
import xml.team.rentacar.dto.RentAdvertDTO;
import xml.team.rentacar.model.Car;
import xml.team.rentacar.model.Firm;
import xml.team.rentacar.model.PriceList;
import xml.team.rentacar.model.RentAdvert;
import xml.team.rentacar.repository.CarRepository;
import xml.team.rentacar.repository.FirmRepository;
import xml.team.rentacar.repository.PriceListRepository;
import xml.team.rentacar.repository.RentAdvertRepository;

@Service
public class RentAdvertService {

	@Autowired
	private RentAdvertRepository rentARepository;
	
	@Autowired
	private FirmRepository firmRepository;

	@Autowired
	private CarRepository carRepository;

	@Autowired
	private PriceListRepository priceListRepository;
	

	public ArrayList<RentAdvert> findAll() {
		// TODO Auto-generated method stub
		
		List<RentAdvert> raList = rentARepository.findAll();
		
		if(raList == null) {
			return null;
		}
		
		return (ArrayList<RentAdvert>) raList;
	}

	public RentAdvert findAdvert(Long advertId){
		RentAdvert rentAdvert = rentARepository.findById(advertId).orElse(null);
		if(rentAdvert == null){
			return null;
		}
		return  rentAdvert;
	}


	public void addRentAdvert(RentAdvert ra) throws Exception {
		// TODO Auto-generated method stub
		RentAdvert saved = new RentAdvert();
		try {
			saved = rentARepository.save(ra);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new Exception("Cuvanje oglasa nije uspjelo");
		}

		// SOAP
		RentAdvertPortService service = new RentAdvertPortService();
		RentAdvertPort rentAdvertPort = service.getRentAdvertPortSoap11();
		GetRentAdvertRequest getRentAdvertRequest = new GetRentAdvertRequest();

		System.out.println(ra.getAdvertEndDate().toString());

		try {
			com.baeldung.soap.ws.client.generated.RentAdvert rentAdvert = new com.baeldung.soap.ws.client.generated.RentAdvert(ra);
			rentAdvert.setId(saved.getId());
			rentAdvert.setAdvertEndDate(ra.getAdvertEndDate().toString());
			rentAdvert.setAdvertStartDate(ra.getAdvertStartDate().toString());
			getRentAdvertRequest.setRentAdvert(rentAdvert);
			GetRentAdvertResponse getRentAdvertResponse = rentAdvertPort.getRentAdvert(getRentAdvertRequest);
			ra.setForeignId(getRentAdvertResponse.getId());
		}catch (Exception e){

			System.out.println("Nije moguce poslati Advert.Mikroservis ne radi");
		}



	}


	public ArrayList<RentAdvert> findFirmsAllRentAdvert(Long firmID) {
		// TODO Auto-generated method stub
		Firm firm  = firmRepository.findById(firmID).orElse(null);
		if(firm == null) {
			throw new NoSuchElementException("Firma ne postoji");
		}
		
		List<RentAdvert> listRA = rentARepository.findByFirm(firm);
		
		if(listRA == null) {
			return null;
		}
		
		
		return (ArrayList<RentAdvert>) listRA;
	}


    public void modifyAdvert(RentAdvertDTO rentAdvertDTO) throws NoSuchElementException, Exception {
		RentAdvert rentAdvert = rentARepository.findById(rentAdvertDTO.getId()).orElse(null);

		if(rentAdvert == null){
			throw new NoSuchElementException("Rentacar: modifikacija reklame - ne postoji reklama");
		}

		rentAdvert.setAdvertStartDate(rentAdvertDTO.getAdvertStartDate());
		rentAdvert.setAdvertEndDate(rentAdvertDTO.getAdvertEndDate());
		Car car = carRepository.findById(rentAdvertDTO.getCarID()).orElse(null);
		if(car == null){
			throw new NoSuchElementException("Rentacar: modifikacija reklame - ne postoji auto");
		}

		rentAdvert.setCar(car);

		PriceList pl = priceListRepository.findById(rentAdvertDTO.getPriceListID()).orElse(null);

		if(pl == null){
			throw new NoSuchElementException("Rentacar: modifikacija reklame - ne postoji cjenovnik");

		}

		rentAdvert.setPriceList(pl);
		rentAdvert.setPriceForRent(rentAdvertDTO.getPriceForRent());

		try{
			rentARepository.save(rentAdvert);
		}
		catch (Exception e){
			e.printStackTrace();
			throw new Exception("Rentacar: modifikacija reklame");
		}






    }

	public void deleteRentAdvert(Long id) throws Exception, NoSuchElementException {

		RentAdvert ra = rentARepository.findById(id).orElse(null);

		if(ra == null){
			throw new NoSuchElementException("Rentacar: brisanje reklame - reklama ne postoji");
		}

		try {
			rentARepository.deleteById(id);
		}
		catch (Exception e){
			e.printStackTrace();
			throw new Exception("Rentacar: brisanje reklame");
		}
	}

	public ArrayList<RentAdvert> getAll() {

		return (ArrayList<RentAdvert>) rentARepository.findAll();
	}
}
