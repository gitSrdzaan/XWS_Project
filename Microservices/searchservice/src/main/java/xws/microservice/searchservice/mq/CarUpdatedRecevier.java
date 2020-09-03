package xws.microservice.searchservice.mq;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xws.microservice.searchservice.dto.CarDTO;

import xws.microservice.searchservice.services.CarService;
import xws.microservice.searchservice.services.RentAdvertService;

import java.util.concurrent.CountDownLatch;

@Component
public class CarUpdatedRecevier {

    private CountDownLatch latch = new CountDownLatch(1);

    @Autowired
    private CarService carService;


    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "${xml.rabbitmq.queue}.car.search",durable = "true"),
            exchange = @Exchange(name = "${xml.rabbitmq.exchange}.car.search",type = ExchangeTypes.DIRECT),
            key = "${xml.rabbitmq.routingkey}.car.update"
    )
    )
    public void receiveCar(CarDTO carDTO){
        System.out.println("Received updated car "+carDTO.getId());
        try {
            carService.addCar(carDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }

        latch.countDown();

    }
}
