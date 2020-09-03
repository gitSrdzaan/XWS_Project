package xml.team.rentacar.controller;

import com.baeldung.springsoap.gen.GetRentRequestAnswerRequest;
import com.baeldung.springsoap.gen.GetRentRequestAnswerResponse;
import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.*;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import xml.team.rentacar.dto.RentRequestDTO;
import xml.team.rentacar.model.RentAdvert;
import xml.team.rentacar.model.RentRequest;
import xml.team.rentacar.model.RentRequestBundle;
import xml.team.rentacar.model.RentRequestStatus;
import xml.team.rentacar.service.RentAdvertService;
import xml.team.rentacar.service.RentRequestService;
import xml.team.rentacar.service.UserServiceImpl;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/request")
@CrossOrigin(origins = "*")
@Endpoint
public class RentRequestController {


    private static final String NAMESPACE_URI = "http://www.baeldung.com/springsoap/gen";

    @Autowired
    private RentRequestService rentRequestService;

    @Autowired
    private RentAdvertService rentAdvertService;

    @Autowired
    private UserServiceImpl userService;

    @GetMapping(value = "/all")
    public ResponseEntity<?> getAllRequests(){
        ArrayList<RentRequest> rentRequestArrayList =  rentRequestService.getAll();

        return new ResponseEntity<>(rentRequestArrayList,HttpStatus.OK);
    }


    @PostMapping(path = "/new" , consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> createRequest(@RequestBody RentRequestDTO rentRequestDTO){
        RentAdvert rentAdvert = rentAdvertService.findAdvert(rentRequestDTO.getRentAdvert_Id());
        if(rentAdvert == null){
            return new ResponseEntity<>("Ne postoji poslata reklama",HttpStatus.BAD_REQUEST );
        }
        RentRequest rentRequest = new RentRequest();
        try{
            rentRequest.setRentAdvert(rentAdvert);
            rentRequest.setReservationStart(rentRequestDTO.getReservationStart());
            rentRequest.setReservationEnd(rentRequestDTO.getReservationEnd());
            rentRequest.setStatus(RentRequestStatus.PENNDING);
            rentRequestService.addRentRequest(rentRequest);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Greska pri upisivanja rezervacije", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(rentRequest,HttpStatus.OK);
    }

    @GetMapping(value = "/all/bundle")
    public ResponseEntity<?> getAllRequestsBundle(){
        ArrayList<RentRequestBundle> rentRequestBundles = rentRequestService.getAllBundle();

        return new ResponseEntity<>(rentRequestBundles,HttpStatus.OK);
    }

    @GetMapping(value="/allPending", produces = "application/json")
    public ResponseEntity<?> getAllRequestsPending(){
        ArrayList<RentRequest> rentRequestArrayList =  rentRequestService.getAllPending();

        return new ResponseEntity<>(rentRequestArrayList,HttpStatus.OK);
    }

   @PutMapping(path = "/status" , consumes = "application/json", produces = "application/json")
   public ResponseEntity<?> setRentRequestStatus(@RequestBody RentRequestDTO rentRequestDTO){
        RentRequest rentRequest = rentRequestService.changeRentRequestStatus(rentRequestDTO);

        return new ResponseEntity<>(rentRequest, HttpStatus.OK);
   }

    /**
     * TODO: odobravanje ili odbijanje budnle zahtjeva
     *
     * */

    @PutMapping(value ="/denied/bundle/{bundleId}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> deniedBundleRequest(@PathVariable Long bundleId){
        RentRequestBundle rrb = rentRequestService.findRentRequestBundle(bundleId);
        if(rrb == null){
            return  new ResponseEntity<>("Greska pri odbijanju bundle zahtjeva", HttpStatus.BAD_REQUEST);
        }

        ArrayList<RentRequest> rentRequests = (ArrayList<RentRequest>) rrb.getRentRequest();
        for(RentRequest rentRequest : rentRequests){
            rentRequest.setStatus(RentRequestStatus.DENIED);
        }
        rrb.setRentRequest(rentRequests);
        try{
            rentRequestService.saveRentRequestBundle(rrb);
        }
        catch (Exception e){
            e.printStackTrace();
            return  new ResponseEntity<>("Greska pri uspisivanju odbijenog bundle zahtjeva", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PutMapping(value ="/accepted/bundle/{bundleId}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> acceptedBundleRequest(@PathVariable Long bundleId){
        RentRequestBundle rrb = rentRequestService.findRentRequestBundle(bundleId);
        if(rrb == null){
            return  new ResponseEntity<>("Greska pri odbijanju bundle zahtjeva", HttpStatus.BAD_REQUEST);
        }

        ArrayList<RentRequest> rentRequests = (ArrayList<RentRequest>) rrb.getRentRequest();
        for(RentRequest rentRequest : rentRequests){
            rentRequest.setStatus(RentRequestStatus.PAID);
        }
        rrb.setRentRequest(rentRequests);
        try{
            rentRequestService.saveRentRequestBundle(rrb);
        }
        catch (Exception e){
            e.printStackTrace();
            return  new ResponseEntity<>("Greska pri uspisivanju odbijenog bundle zahtjeva", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PayloadRoot(namespace =  NAMESPACE_URI , localPart = "getRentRequestAnswerRequest")
    @ResponsePayload
    public GetRentRequestAnswerResponse addNewRequestFromMS(@RequestPayload GetRentRequestAnswerRequest request){

        try{
            GetRentRequestAnswerResponse response = new GetRentRequestAnswerResponse();

            response.setId(rentRequestService.addNewRentRequestSoap(request));

            return response;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


}
