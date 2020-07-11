package xml.team.rentacar.controller;

import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xml.team.rentacar.dto.RentRequestDTO;
import xml.team.rentacar.model.RentRequest;
import xml.team.rentacar.model.RentRequestStatus;
import xml.team.rentacar.service.RentRequestService;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/zahtjevi")
public class RentRequestController {


    @Autowired
    private RentRequestService rentRequestService;


    @GetMapping(value = "/svi")
    public ResponseEntity<?> getAllRequests(){
        ArrayList<RentRequest> rentRequestArrayList =  rentRequestService.getAll();

        return new ResponseEntity<>(rentRequestArrayList,HttpStatus.OK);
    }

    @GetMapping(value="/neodobreni")
    public ResponseEntity<?> getAllRequestsPending(){
        ArrayList<RentRequest> rentRequestArrayList =  rentRequestService.getAllPending();

        return new ResponseEntity<>(rentRequestArrayList,HttpStatus.OK);
    }

    @PutMapping(value = "/odobrovanje/{rrID}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> modifyRentRequestPaid(@PathVariable Long rrID){
        RentRequest rentRequest = rentRequestService.findRentRequest(rrID);

        rentRequest.setStatus(RentRequestStatus.PAID);
        try{
            rentRequestService.saveRentRequest(rentRequest);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Greska pri modifikaciji zahtjeva", HttpStatus.INTERNAL_SERVER_ERROR);
        }


        return  new ResponseEntity<>(HttpStatus.OK);

    }

    @PutMapping(value = "/odbijanje/{rrID}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> modifyRentRequestDenied(@PathVariable Long rrID){
        RentRequest rentRequest = rentRequestService.findRentRequest(rrID);

        rentRequest.setStatus(RentRequestStatus.DENIED);
        try{
            rentRequestService.saveRentRequest(rentRequest);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Greska pri modifikaciji zahtjeva", HttpStatus.INTERNAL_SERVER_ERROR);
        }


        return  new ResponseEntity<>(HttpStatus.OK);

    }

    /**
     * TODO: odobravanje ili odbijanje budnle zahtjeva
     * */




}
