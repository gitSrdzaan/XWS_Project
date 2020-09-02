package xws.microservis.advertservice.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import xws.microservis.advertservice.model.RentAdvert;

@Service
public class AdvertCreatedSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${xml.rabbitmq.exchange}")
    private String exchange;

    @Value("${xml.rabbitmq.routingkey}")
    private String routingkey;

    public void send(RentAdvert advert){
        amqpTemplate.convertAndSend(exchange,routingkey,advert);
        System.out.println("Send advert created = " + advert.getId());
    }
}
