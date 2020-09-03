package xws.microservice.searchservice.mq;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xws.microservice.searchservice.dto.CarDTO;
import xws.microservice.searchservice.services.CarService;

import java.util.concurrent.CountDownLatch;

@Component
public class CarCreatedReceiver {
    CountDownLatch latch = new CountDownLatch(1);

    @Autowired
    private CarService carService;


    @RabbitListener(queues = "${xml.rabbitmq.queue}.car.search")
    public void receiveCar(CarDTO carDTO){
        System.out.println("Received car "+carDTO.getId());
        try {
            carService.addCar(carDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }

        latch.countDown();
    }



}
