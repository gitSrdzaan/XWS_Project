package xml.team.rentacar.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import xml.team.rentacar.model.RentAdvert;
import xml.team.rentacar.model.RentRequest;

@Service
public class RequestAnswerCreated {


    @Autowired
    private AmqpTemplate amqpTemplate;


    @Value("${xml.rabbitmq.queue}")
    private String queue;

    @Value("${xml.rabbitmq.exchange}")
    private String exchange;

    @Value("${xml.rabbitmq.routingkey}")
    private String routingKey;


    public void send(RentRequest request){
        amqpTemplate.convertAndSend(exchange,routingKey,request);
        System.out.println("Send request answered msg = " + request);
    }
}
