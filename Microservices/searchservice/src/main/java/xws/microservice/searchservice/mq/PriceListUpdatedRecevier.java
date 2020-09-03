package xws.microservice.searchservice.mq;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xws.microservice.searchservice.dto.PriceListDTO;
import xws.microservice.searchservice.services.PriceListService;

import java.util.concurrent.CountDownLatch;

@Component
public class PriceListUpdatedRecevier {

    public CountDownLatch latch = new CountDownLatch(1);

    @Autowired
    private PriceListService service;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "${xml.rabbitmq.queue}.pricelist.search",durable = "true"),
            exchange = @Exchange(name = "${xml.rabbitmq.exchange}.pricelist.search",type = ExchangeTypes.DIRECT),
            key = "${xml.rabbitmq.routingkey}.pricelist.update"
    )
    )
    public void receivePriceList(PriceListDTO priceListDTO){
        System.out.println("Recevied updated pricelist : "+priceListDTO.getId());
        try {
            service.addNewPriceList(priceListDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        latch.countDown();

    }
}
