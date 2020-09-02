package xws.microservis.rentservice.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import xws.microservis.rentservice.model.RentRequest;

@Service
public class RequestCreatedSender {

    @Autowired
    public AmqpTemplate amqpTemplate;

    @Value("${xml.rabbitmq.exchange}")
    private String exchange;

    @Value("${xml.rabbitmq.routingkey}")
    private String routingkey;

    public void send(RentRequest request){
        amqpTemplate.convertAndSend(exchange+".request",routingkey+".request",request);
        System.out.println("Send advert created = " + request.getId());
    }


}
