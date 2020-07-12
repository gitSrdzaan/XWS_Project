package xws.microservice.soapservice.soapclient;

import com.example.consumingwebservice.wsdl.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import xws.microservice.soapservice.model.Car;

public class SoapClient extends WebServiceGatewaySupport {



    public GetRentAdvertResponse getRentAdvert(Long id){

        GetRentAdvertRequest request = new GetRentAdvertRequest();
        request.setId(id);

        GetRentAdvertResponse response = (GetRentAdvertResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/rentadvert" , request ,
                        new SoapActionCallback("http://rentacar.com/rentadvert/xws/GetRentAdvertRequest"));

        System.out.println("RESPONSE: " + response.getRentAdvert().getOwner());

        return response;
    }

    public GetPriceListResponse getPriceListResponse(Long id) {

        GetPriceListRequest request = new GetPriceListRequest();
        request.setId(id);

        GetPriceListResponse response = (GetPriceListResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/pricelist", request,
                        new SoapActionCallback("http://rentacar.com/rentadvert/xws/GetRentAdvertRequest"));

        return response;
        }

    public GetCarResponse getCarResponse(Long id){

        GetCarRequest request = new GetCarRequest();
        request.setId(id);

        GetCarResponse response = (GetCarResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/car" , request,
                        new SoapActionCallback("http://rentacar.com/rentadvert/xws/GetRentAdvertRequest"));

        System.out.println("RESPONSE: " + response.getCar().getOwner());

        xws.microservice.soapservice.model.Car car = new xws.microservice.soapservice.model.Car();
        car.setId(response.getCar().getId());
        car.setCarClass(response.getCar().getCarClass());
        car.setCarFuel(response.getCar().getCarFuel());
        car.setTransmission(response.getCar().getTransmission());
        car.setOwner(response.getCar().getOwner());
        car.setKidsSeats(response.getCar().getKidsSeats());
        car.setCarRegistration(response.getCar().getCarRegistration());
        car.setCarMark(response.getCar().getCarMark());
        car.setCarModel(response.getCar().getCarModel());
        car.setCarMileage(response.getCar().getCarMileage());
        car.setCarGrade(response.getCar().getCarGrade());

        return response;
    }

}
