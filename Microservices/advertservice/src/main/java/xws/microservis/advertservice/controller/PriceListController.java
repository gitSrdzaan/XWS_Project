package xws.microservis.advertservice.controller;

import com.baeldung.springsoap.gen.GetCarRequest;
import com.baeldung.springsoap.gen.GetCarResponse;
import com.baeldung.springsoap.gen.GetPriceListRequest;
import com.baeldung.springsoap.gen.GetPriceListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import xws.microservis.advertservice.service.PriceListService;

@RestController
@RequestMapping("/pricelist")
@CrossOrigin(origins = "*")
@Endpoint
public class PriceListController {

    private static final String NAMESPACE_URI = "http://www.baeldung.com/springsoap/gen";

    @Autowired
    private PriceListService priceListService;


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPriceListRequest")
    @ResponsePayload
    public GetPriceListResponse addPriceListFromSoap(@RequestPayload GetPriceListRequest request) {
        try {
            GetPriceListResponse response = new GetPriceListResponse();

            response.setId(priceListService.addNewPriceListSoap(request));

            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}