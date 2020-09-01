/*package xml.team.rentacar.soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import xml.team.rentacar.repository.RentAdvertRepository;

import java.text.SimpleDateFormat;

@Endpoint
public class RentAdvertEndpoint {
   private static final String NAMESPACE_URI = "http://rentacar.com/rentadvert/xws";

    private RentAdvertRepository rentAdvertRepository;

    @Autowired
    public RentAdvertEndpoint(RentAdvertRepository rentAdvertRepository){
        this.rentAdvertRepository = rentAdvertRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getRentAdvertRequest")
    @ResponsePayload
    public GetRentAdvertResponse getRentAdvert(@RequestPayload GetRentAdvertRequest request){

        GetRentAdvertResponse response = new GetRentAdvertResponse();

        xml.team.rentacar.model.RentAdvert rentAdvert = rentAdvertRepository.findById(request.getId()).orElse(null);

        RentAdvert rentAdvertSoap = new RentAdvert();
        rentAdvertSoap.setId(rentAdvert.getId());
        rentAdvertSoap.setCarId(rentAdvert.getCar().getId());
        rentAdvertSoap.setPriceListId(rentAdvert.getPriceList().getId());

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String strDateStart = formatter.format(rentAdvert.getAdvertStartDate());
        String strDateEnd = formatter.format(rentAdvert.getAdvertEndDate());

        rentAdvertSoap.setAdvertEndDate(strDateEnd);
        rentAdvertSoap.setAdvertStartDate(strDateStart);
        rentAdvertSoap.setOwner("localhost:8080");

        response.setRentAdvert(rentAdvertSoap);

        return response;
    }



}
*/