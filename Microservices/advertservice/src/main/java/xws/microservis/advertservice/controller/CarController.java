package xws.microservis.advertservice.controller;


import com.baeldung.springsoap.gen.GetCarRequest;
import com.baeldung.springsoap.gen.GetCarResponse;

import com.netflix.ribbon.proxy.annotation.Http;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import xws.microservis.advertservice.dto.CarDTO;
import xws.microservis.advertservice.model.*;

import xws.microservis.advertservice.mq.CarCreatedSender;

import xws.microservis.advertservice.mq.CarUpdatedSender;
import xws.microservis.advertservice.repository.CarFuelRepository;
import xws.microservis.advertservice.repository.TransmissionRepository;

import xws.microservis.advertservice.service.CarService;

import java.util.ArrayList;

@RestController
@RequestMapping(value= "/car")
@CrossOrigin(origins = "*")
@Endpoint
public class CarController {

    private static final String NAMESPACE_URI = "http://www.baeldung.com/springsoap/gen";

    @Autowired
    private CarService carService;

    @Autowired
    private CarCreatedSender carSender;

    @Autowired
    private CarUpdatedSender updatedSender;

    private CarFuelRepository carFuelRepository;

    @Autowired
    private TransmissionRepository transmissionRepository;


    @GetMapping(value = "/all",produces = "application/json")
    public ResponseEntity<?> getAllCars(){
        ArrayList<Car> carArrayList = carService.getAllCars();
        return new ResponseEntity<>(carArrayList,HttpStatus.OK);
    }


    @PostMapping(value = "/new" , consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> addNewCar(@RequestBody CarDTO carDTO){
        if(carDTO == null){
            return new ResponseEntity<>("Greska pri kreiranju auta", HttpStatus.BAD_REQUEST);
        }
        try{
            carDTO.setId(carService.saveNewCar(carDTO).getId());
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Greska pri upisu auta", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        carSender.sendCar(carDTO);

        return  new ResponseEntity<>(HttpStatus.OK);

    }

    @PutMapping(value = "/modify/{carId}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> modifyCar(@RequestBody CarDTO carDTO, @PathVariable("carId") Long carId){


        try {
            carService.modifyCar(carDTO,carId);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("AdvertService: Greska pri modifikaciji automobila", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        updatedSender.send(carDTO);



        return new ResponseEntity<>(HttpStatus.OK);


    }
    /**
     * TODO : ispis sifrarnika
     * */
    @GetMapping(value = "/marks", produces = "application/json")
    public ResponseEntity<?> findAllCarMarks(){
        ArrayList<CarMark> listMark = carService.findAllCarMarks();
        if(listMark == null) {
            return new ResponseEntity<>("Lista marki automobila prazna", HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listMark,HttpStatus.OK);


    }

    @GetMapping(value = "/classes",produces = "application/json")
    public ResponseEntity<?> findAllCarClasses(){
        ArrayList<CarClass> listClass = carService.findAllCarClasses();
        if(listClass == null) {
            return new ResponseEntity<>("Lista klasi automobila prazna", HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listClass,HttpStatus.OK);


    }



    @GetMapping(value = "/models",produces = "application/json")
    public ResponseEntity<?> findAllCarModels(){
        ArrayList<CarModel> listModel = carService.findAllCarModels();
        if(listModel == null) {
            return new ResponseEntity<>("Lista modeli automobila prazna", HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listModel,HttpStatus.OK);


    }


    @GetMapping(value = "/transmissions",produces = "application/json")
    public ResponseEntity<?> getAllCarTransmission(){
        ArrayList<Transmission> transmissionArrayList = carService.getAllTransmission();

        return new ResponseEntity<>(transmissionArrayList,HttpStatus.OK);

    }

    @GetMapping(value = "/fuels",produces = "application/json")
    public ResponseEntity<?> getAllCarFuel(){

        ArrayList<CarFuel> carFuelSet = carService.getAllCarFuel();

        return new ResponseEntity<>(carFuelSet,HttpStatus.OK);

    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCarRequest")
    @ResponsePayload
    public GetCarResponse addCarFromAgentApp(@RequestPayload GetCarRequest request) {
        try{
            GetCarResponse response = new GetCarResponse();

            response.setId(carService.addNewCarSoap(request));

            return response;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }






}
