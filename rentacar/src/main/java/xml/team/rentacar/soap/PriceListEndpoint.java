/*package xml.team.rentacar.soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import xml.team.rentacar.model.PriceList;
import xml.team.rentacar.repository.PriceListRepository;

@Endpoint
public class PriceListEndpoint {

    private static final String NAMESPACE_URI = "http://rentacar.com/rentadvert/xws";

    private PriceListRepository priceListRepository;

    @Autowired
    public PriceListEndpoint(PriceListRepository priceListRepository){
        this.priceListRepository = priceListRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI , localPart = "getPriceListRequest")
    @ResponsePayload
    public GetPriceListResponse getPriceList(@RequestPayload GetPriceListRequest request){

        GetPriceListResponse response = new GetPriceListResponse();

        PriceList priceList = priceListRepository.findById(request.getId()).orElse(null);

        com.rentacar.rentadvert.xws.PriceList priceListSoap = new com.rentacar.rentadvert.xws.PriceList();

        priceListSoap.setId(priceList.getId());
        priceListSoap.setOwner("localhost:8080");
        priceListSoap.setPriceCDW(priceList.getPriceCDW());
        priceListSoap.setPricePerDay(priceList.getPricePerDay());
        priceListSoap.setPricePerKilometer(priceList.getPricePerKilometer());

        response.setPriceList(priceListSoap);

        return response;

    }

}*/
