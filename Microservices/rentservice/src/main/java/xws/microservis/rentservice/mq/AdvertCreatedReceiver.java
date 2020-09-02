package xws.microservis.rentservice.mq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import xws.microservis.rentservice.dto.RentAdvertDTO;
import xws.microservis.rentservice.services.RentAdvertService;

import java.util.concurrent.CountDownLatch;

@Component
public class AdvertCreatedReceiver {

    private CountDownLatch latch = new CountDownLatch(1);

    @Autowired
    private RentAdvertService advertService;


    @RabbitListener(queues = "${xml.rabbitmq.queue}.advert")
    public void reciveAdvert(RentAdvertDTO advertDTO){
        System.out.println("Recevied: " + advertDTO.getId());

        advertService.addNewRentAdvert(advertDTO);


        latch.countDown();

    }
}
