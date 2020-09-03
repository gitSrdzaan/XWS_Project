package xws.microservice.searchservice.mq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xws.microservice.searchservice.dto.PriceListDTO;
import xws.microservice.searchservice.model.PriceList;
import xws.microservice.searchservice.services.PriceListService;

import java.util.concurrent.CountDownLatch;

@Component
public class PriceListCreatedRecevier {

    public CountDownLatch latch = new CountDownLatch(1);

    @Autowired
    private PriceListService service;

    @RabbitListener(queues = "${xml.rabbitmq.queue}.pricelist.search")
    public void receivePriceList(PriceListDTO priceListDTO){
        System.out.println("Recevied pricelist : "+priceListDTO.getId());
        try {
            service.addNewPriceList(priceListDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        latch.countDown();

    }
}
