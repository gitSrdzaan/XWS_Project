package xws.microservis.rentservice.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xws.microservis.rentservice.mq.AdvertCreatedReceiver;

import xws.microservis.rentservice.mq.CarCreatedRecevier;
import xws.microservis.rentservice.mq.PriceListRecevier;

@Configuration
public class RabbitMQConfig {


    @Value("${xml.rabbitmq.queue}")
    private String queue;

    @Value("${xml.rabbitmq.exchange}")
    private String exchange;

    @Value("${xml.rabbitmq.routingkey}")
    private String routingkey;

    @Bean
    Queue advertSearchQueue() {
        return new Queue(queue+".advert.search" ,true);
    }

    @Bean
    Queue advertRentQueue() {
        return new Queue(queue+".advert.rent" ,true);
    }

    @Bean
    Queue carSearchQueue(){
        return new Queue(queue+".car.search", true);
    }
    @Bean
    Queue carRentQueue(){
        return new Queue(queue+".car.rent", true);
    }

    @Bean
    Queue priceListSearchQueue(){
        return new Queue(queue+".pricelist.search",true);
    }

    @Bean
    Queue priceListRentQueue(){
        return new Queue(queue+".pricelist.rent",true);
    }

    @Bean
    DirectExchange advertSearchExchange() {
        return new DirectExchange(exchange+".advert.search");
    }

    @Bean
    DirectExchange carSearchExchange(){
        return new DirectExchange(exchange+".car.search");
    }

    @Bean
    DirectExchange priceListSearchExchange(){
        return new DirectExchange(exchange+".pricelist.search");
    }

    @Bean
    DirectExchange advertRentExchange() {
        return new DirectExchange(exchange+".advert.rent");
    }

    @Bean
    DirectExchange carRentExchange(){
        return new DirectExchange(exchange+".car.rent");
    }

    @Bean
    DirectExchange priceListRentExchange(){
        return new DirectExchange(exchange+".pricelist.rent");
    }

    @Bean
    Binding advertSearchBinding(Queue advertSearchQueue, DirectExchange advertSearchExchange) {
        return BindingBuilder.bind(advertSearchQueue).to(advertSearchExchange).with(routingkey+".advert");
    }

    @Bean
    Binding advertRentBinding(Queue advertRentQueue, DirectExchange advertRentExchange) {
        return BindingBuilder.bind(advertRentQueue).to(advertRentExchange).with(routingkey+".advert");
    }

    @Bean
    Binding carSearchBinding(Queue carSearchQueue, DirectExchange carSearchExchange){
        return BindingBuilder.bind(carSearchQueue).to(carSearchExchange).with(routingkey+".car");
    }

    @Bean
    Binding carRentBinding(Queue carRentQueue, DirectExchange carRentExchange){
        return BindingBuilder.bind(carRentQueue).to(carRentExchange).with(routingkey+".car");
    }

    @Bean
    Binding plSearchBinding(Queue priceListSearchQueue, DirectExchange priceListSearchExchange){
        return BindingBuilder.bind(priceListSearchQueue).to(priceListSearchExchange).with(routingkey+".pricelist");
    }

    @Bean
    Binding plRentBindingPL(Queue priceListRentQueue, DirectExchange priceListRentExchange){
        return BindingBuilder.bind(priceListRentQueue).to(priceListRentExchange).with(routingkey+".pricelist");
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

    @Bean
    public AdvertCreatedReceiver createdAdvertRecevier(){
        return new AdvertCreatedReceiver();
    }

    @Bean
    public CarCreatedRecevier carRecevier(){
        return new CarCreatedRecevier();
    }

    @Bean
    public PriceListRecevier priceListCreatedRecevier(){
        return new PriceListRecevier();
    }
}
