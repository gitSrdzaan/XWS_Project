package xws.microservis.advertservice.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import xws.microservis.advertservice.dto.AdvertDto;
import xws.microservis.advertservice.model.RentAdvert;

@Service
public class AdvertCreatedSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${xml.rabbitmq.exchange}")
    private String exchange;

    @Value("${xml.rabbitmq.routingkey}")
    private String routingkey;

    public void send(AdvertDto advertDTO){
        amqpTemplate.convertAndSend(exchange+".advert.search",routingkey+".advert.create",advertDTO);
        System.out.println("Send advert created = " + advertDTO.getId());
        amqpTemplate.convertAndSend(exchange+".advert.rent",routingkey+".advert.create",advertDTO);
        System.out.println("Send advert created = " + advertDTO.getId());

    }
}
