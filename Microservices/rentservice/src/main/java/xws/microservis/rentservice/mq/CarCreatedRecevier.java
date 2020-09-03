package xws.microservis.rentservice.mq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import xws.microservis.rentservice.dto.CarDTO;
import xws.microservis.rentservice.services.CarService;

import java.util.concurrent.CountDownLatch;

@Component
public class CarCreatedRecevier {

    CountDownLatch latch = new CountDownLatch(1);

    @Autowired
    private CarService carService;


    @RabbitListener(queues = "${xml.rabbitmq.queue}.car.rent")
    public void receiveCar(CarDTO carDTO) {
        System.out.println("Received car:  " + carDTO.getId());
        try {
            carService.addCar(carDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        latch.countDown();
    }


    }
