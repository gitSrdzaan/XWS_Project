package xws.microservice.searchservice.mq;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xws.microservice.searchservice.dto.RentAdvertDTO;
import xws.microservice.searchservice.services.RentAdvertService;

import java.util.concurrent.CountDownLatch;

@Component
public class AdvertUpdatedRecevier {


    private CountDownLatch latch = new CountDownLatch(1);

    @Autowired
    private RentAdvertService advertService;


    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "${xml.rabbitmq.queue}.advert.search",durable = "true"),
            exchange = @Exchange(name = "${xml.rabbitmq.exchange}.advert.search",type = ExchangeTypes.DIRECT),
            key = "${xml.rabbitmq.routingkey}.advert.update"
    )
    )
    public void reciveAdvert(RentAdvertDTO advertDTO){
        System.out.println("Recevied advert update: " + advertDTO.getId());

        advertService.addNewRentAdvert(advertDTO);


        latch.countDown();

    }
}
