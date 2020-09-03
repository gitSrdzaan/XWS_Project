package xws.microservis.advertservice.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {


    @Value("${xml.rabbitmq.queue}")
    private String queue;

    @Value("${xml.rabbitmq.exchange}")
    private String exchange;

    @Value("${xml.rabbitmq.routingkey}")
    private String routingkey;

    @Bean
    Queue advertQueue() {
        return new Queue(queue+".advert" ,true);
    }

    @Bean
    Queue carQueue(){
        return new Queue(queue+".car", true);
    }

    @Bean
    Queue priceListQueue(){
        return new Queue(queue+".pricelist",true);
    }

    @Bean
    DirectExchange advertExchange() {
        return new DirectExchange(exchange+".advert");
    }

    @Bean
    DirectExchange carExchange(){
        return new DirectExchange(exchange+".car");
    }

    @Bean
    DirectExchange priceListExchange(){
        return new DirectExchange(exchange+".pricelist");
    }

    @Bean
    Binding binding(Queue advertQueue, DirectExchange advertExchange) {
        return BindingBuilder.bind(advertQueue).to(advertExchange).with(routingkey+".advert");
    }

    @Bean
    Binding binding2(Queue carQueue, DirectExchange carExchange){
        return BindingBuilder.bind(carQueue).to(carExchange).with(routingkey+".car");
    }

    @Bean
    Binding bindingPL(Queue priceListQueue, DirectExchange priceListExchange){
        return BindingBuilder.bind(priceListQueue).to(priceListExchange).with(routingkey+".pricelist");
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    public AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }



}
