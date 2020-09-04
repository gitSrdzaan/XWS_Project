package xws.microservis.advertservice.controller;

import com.baeldung.springsoap.gen.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import xws.microservis.advertservice.dto.PriceListDTO;
import xws.microservis.advertservice.model.PriceList;
import xws.microservis.advertservice.mq.PriceListCreatedSender;
import xws.microservis.advertservice.mq.PriceListUpdatedSender;
import xws.microservis.advertservice.service.PriceListService;

@RestController
@RequestMapping(value = "/pricelist")
@CrossOrigin(origins = "*")
@Endpoint
public class PriceListController {

    private static final String NAMESPACE_URI = "http://www.baeldung.com/springsoap/gen";

    @Autowired
    private PriceListService priceListService;

    @Autowired
    private PriceListCreatedSender createdSender;

    @Autowired
    private PriceListUpdatedSender updatedSender;

    @PostMapping(value = "/new", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> createNewPriceList(@RequestBody PriceListDTO priceListDTO){

        PriceList retVal = priceListService.saveNew(priceListDTO);
        priceListDTO.setId(retVal.getId());

        createdSender.send(priceListDTO);

        return new ResponseEntity<>(retVal,HttpStatus.OK);
    }

    @PutMapping(value = "/modify", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> updatePriceList(@RequestBody PriceListDTO priceListDTO){


        PriceList retVal = priceListService.saveNew(priceListDTO);

        updatedSender.send(priceListDTO);

        return new ResponseEntity<>(retVal,HttpStatus.OK);

    }

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