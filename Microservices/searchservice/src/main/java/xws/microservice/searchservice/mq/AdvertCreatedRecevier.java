package xws.microservice.searchservice.mq;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import xws.microservice.searchservice.model.RentAdvert;

import java.util.concurrent.CountDownLatch;

@Component
public class AdvertCreatedRecevier {

    private CountDownLatch latch = new CountDownLatch(1);

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "xml.queue",durable = "false"),
            exchange = @Exchange(value = "xml.exchange"),
            key = "xml.routingkey"

    )
    )
    public void reciveAdvert(RentAdvert advert){
        System.out.println("Recevied: " + advert.getId());
        latch.countDown();

    }
}
