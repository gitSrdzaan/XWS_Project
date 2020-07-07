package xws.microservice.soapservice.soapclient;

import com.example.consumingwebservice.wsdl.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class SoapClient extends WebServiceGatewaySupport {


    public GetRentAdvertResponse getRentAdvert(Long id){

        GetRentAdvertRequest request = new GetRentAdvertRequest();
        request.setId(id);

        GetRentAdvertResponse response = (GetRentAdvertResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/rentadvert" , request ,
                        new SoapActionCallback("http://rentacar.com/rentadvert/xws/GetRentAdvertRequest"));

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

        return response;
    }

}
