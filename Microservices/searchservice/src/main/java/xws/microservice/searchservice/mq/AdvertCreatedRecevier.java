package xws.microservice.searchservice.mq;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xws.microservice.searchservice.dto.RentAdvertDTO;
import xws.microservice.searchservice.model.RentAdvert;
import xws.microservice.searchservice.services.RentAdvertService;

import java.util.concurrent.CountDownLatch;

@Component
public class AdvertCreatedRecevier {

    private CountDownLatch latch = new CountDownLatch(1);

    @Autowired
    private RentAdvertService advertService;


    @RabbitListener(queues = "${xml.rabbitmq.queue}.advert.search")
    public void reciveAdvert(RentAdvertDTO advertDTO){
        System.out.println("Recevied advert: " + advertDTO.getId());

        advertService.addNewRentAdvert(advertDTO);


        latch.countDown();

    }
}
