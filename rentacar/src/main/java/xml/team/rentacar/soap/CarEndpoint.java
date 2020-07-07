package xml.team.rentacar.soap;


import com.rentacar.rentadvert.xws.GetCarRequest;
import com.rentacar.rentadvert.xws.GetCarResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import xml.team.rentacar.model.Car;
import xml.team.rentacar.repository.CarRepository;

import java.math.BigInteger;

@Endpoint
public class CarEndpoint {
    private static final String NAMESPACE_URI = "http://rentacar.com/rentadvert/xws";

    private CarRepository carRepository;

    @Autowired
    public CarEndpoint(CarRepository carRepository){
        this.carRepository = carRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI , localPart = "getCarRequest")
    @ResponsePayload
    public GetCarResponse getCar(@RequestPayload GetCarRequest request){
        GetCarResponse response = new GetCarResponse();

        Car car = carRepository.findById(request.getId()).orElse(null);

        com.rentacar.rentadvert.xws.Car carSoap = new com.rentacar.rentadvert.xws.Car();
        carSoap.setId(car.getId());
        carSoap.setCarClass(car.getCarClass());
        carSoap.setCarFuel(car.getCarFuel());
        carSoap.setCarGrade(car.getCarGrade());
        carSoap.setCarMark(car.getCarMark());
        carSoap.setCarModel(car.getCarModel());
        carSoap.setCarMileage(car.getCarMileage());
        carSoap.setCarRegistration(car.getCarRegistration());
        carSoap.setKidsSeats(car.getKidsSeats());
        carSoap.setTransmission(car.getTransmission());
        carSoap.setOwner("localhost:8080");
        /*
        carSoap.setLongitude(car.getLongitude());
        carSoap.setLatitude(car.getLatitude());
             **/
        response.setCar(carSoap);

        return response;
    }

}
