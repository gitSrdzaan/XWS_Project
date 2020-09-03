package xml.team.rentacar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import com.baeldung.soap.ws.client.generated.GetPriceListRequest;
import com.baeldung.soap.ws.client.generated.GetPriceListResponse;
import com.baeldung.soap.ws.client.generated.PriceListPort;
import com.baeldung.soap.ws.client.generated.PriceListPortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;
import xml.team.rentacar.model.Firm;
import xml.team.rentacar.model.PriceList;
import xml.team.rentacar.repository.FirmRepository;
import xml.team.rentacar.repository.PriceListRepository;
@Service
public class PriceListService {

	@Autowired
	private PriceListRepository repository;
	
	@Autowired
	private FirmRepository firmRepository;

	public PriceList findPriceList(Long priceListID) {
		// TODO Auto-generated method stub
		return repository.findById(priceListID).orElse(null);
	}
	public ArrayList<PriceList> findAll(){
		List<PriceList> listPL = repository.findAll();
		if(listPL == null) {
			return null;
		}

		return (ArrayList<PriceList>) listPL;
	}
	public ArrayList<PriceList> findAllFirmPL(Long id) {
		// TODO Auto-generated method stub
		Firm firm = firmRepository.findById(id).orElse(null);
		if(firm == null) {
			throw new NoSuchElementException("Ne postoji firma sa tim ide");
		}
		
		List<PriceList> listPL = repository.findByFirm(firm);
		
		if(listPL == null) {
			return null;
		}
		
		
		return (ArrayList<PriceList>) listPL;
	}

	public void addNewPriceList(PriceList pl) throws Exception {

		// SOAP
		PriceListPortService service = new PriceListPortService();
		PriceListPort priceListPort = service.getPriceListPortSoap11();
		GetPriceListRequest getPriceListRequest = new GetPriceListRequest();


		try {
			com.baeldung.soap.ws.client.generated.PriceList priceList  = new com.baeldung.soap.ws.client.generated.PriceList(pl);
			getPriceListRequest.setPriceList(priceList);
			GetPriceListResponse getRentAdvertResponse = priceListPort.getPriceList(getPriceListRequest);
			pl.setForeignId(getRentAdvertResponse.getId());
		}catch (Exception e){

			System.out.println("Nije moguce poslati Price list.Mikroservis ne radi");
		}

		try {
			repository.save(pl);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new Exception("Greska pri cuvanju cjenovnika");
		}
	}
	
	
}
