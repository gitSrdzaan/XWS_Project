package xws.microservis.rentservice.soap;

import com.example.consumingwebservice.wsdl.GetRentAdvertRequest;
import com.example.consumingwebservice.wsdl.GetRentAdvertResponse;
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
}
