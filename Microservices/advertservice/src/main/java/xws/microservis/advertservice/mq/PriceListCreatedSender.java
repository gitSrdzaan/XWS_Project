package xws.microservis.advertservice.mq;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import xws.microservis.advertservice.dto.PriceListDTO;
import xws.microservis.advertservice.model.RentAdvert;

@Service
public class PriceListCreatedSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${xml.rabbitmq.exchange}")
    private String exchange;

    @Value("${xml.rabbitmq.routingkey}")
    private String routingkey;

    public void send(PriceListDTO priceListDTO){
        amqpTemplate.convertAndSend(exchange+".pricelist",routingkey+".pricelist",priceListDTO);
        System.out.println("Send advert created = " + priceListDTO.getId());
    }
}
