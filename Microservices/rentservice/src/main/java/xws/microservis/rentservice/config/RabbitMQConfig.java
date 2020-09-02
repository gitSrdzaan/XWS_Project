package xws.microservis.rentservice.config;

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
    Queue requestQueue() {
        return new Queue(queue+".request" ,false);
    }



    @Bean
    DirectExchange requestExchange() {
        return new DirectExchange(exchange+".request");
    }



    @Bean
    Binding binding(Queue requestQueue, DirectExchange requestExchange) {
        return BindingBuilder.bind(requestQueue).to(requestExchange).with(routingkey+".request");
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
