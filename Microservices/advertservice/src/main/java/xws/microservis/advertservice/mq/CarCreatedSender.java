package xws.microservis.advertservice.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import xws.microservis.advertservice.dto.CarDTO;


@Service
public class CarCreatedSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${xml.rabbitmq.exchange}")
    private String exchange;

    @Value("${xml.rabbitmq.routingkey}")
    private String rountingkey;


    public void sendCar(CarDTO car){
        amqpTemplate.convertAndSend(exchange+".car",rountingkey+".car",car);
        System.out.println("Send car created = " + car.getId());
    }

}
