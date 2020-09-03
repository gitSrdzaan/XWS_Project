package xws.microservis.advertservice.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import xws.microservis.advertservice.dto.CarDTO;


@Service
public class CarUpdatedSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${xml.rabbitmq.exchange}")
    private String exchange;

    @Value("${xml.rabbitmq.routingkey}")
    private String routingkey;

    public void send(CarDTO carDTO) {

        amqpTemplate.convertAndSend(exchange + ".car.search", routingkey + ".car.update", carDTO);
        System.out.println("Send car updated = " + carDTO.getId());
        amqpTemplate.convertAndSend(exchange + ".car.rent", routingkey + ".car.update", carDTO);
        System.out.println("Send car updated = " + carDTO.getId());


    }
}
