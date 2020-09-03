package xws.microservis.advertservice.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import xws.microservis.advertservice.dto.AdvertDto;
import xws.microservis.advertservice.dto.PriceListDTO;
@Service
public class PriceListUpdatedSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${xml.rabbitmq.exchange}")
    private String exchange;

    @Value("${xml.rabbitmq.routingkey}")
    private String routingkey;

    public void send(PriceListDTO priceListDTO){
        amqpTemplate.convertAndSend(exchange+".pricelist.search",routingkey+".pricelist.update",priceListDTO);
        System.out.println("Send pricelist updated = " + priceListDTO.getId());
        amqpTemplate.convertAndSend(exchange+".pricelist.rent",routingkey+".pricelist.update",priceListDTO);
        System.out.println("Send pricelist updated = " + priceListDTO.getId());

    }
}
