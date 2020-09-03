package xws.microservis.rentservice.mq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import xws.microservis.rentservice.dto.PriceListDTO;
import xws.microservis.rentservice.dto.RentAdvertDTO;
import xws.microservis.rentservice.services.PriceListService;
import xws.microservis.rentservice.services.RentAdvertService;

import java.util.concurrent.CountDownLatch;

@Component
public class PriceListRecevier {

    private CountDownLatch latch = new CountDownLatch(1);

    @Autowired
    private PriceListService priceListService;


    @RabbitListener(queues = "${xml.rabbitmq.queue}.pricelist.rent")
    public void reciveAdvert(PriceListDTO priceListDTO){
        System.out.println("Recevied pricelist: " + priceListDTO.getId());

        try {
            priceListService.addNewRentAdvert(priceListDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }


        latch.countDown();

    }
}
