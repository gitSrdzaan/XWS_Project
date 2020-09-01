package xml.team.rentacar;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.amqp.support.converter.MessageConverter;


@SpringBootApplication
public class RentacarApplication {

	@Value("${xml.rabbitmq.queue}")
	private String queueName;

	@Value("${xml.rabbitmq.exchange}")
	private String exchange;

	public static void main(String[] args) {
		SpringApplication.run(RentacarApplication.class, args);
	}


	@Bean
	Queue queue(){
		return new Queue(queueName,true);
	}

	@Bean
	DirectExchange exchange(){
		return new DirectExchange(exchange);
	}

	@Bean
	Binding binding(Queue queue,DirectExchange exchange){
		return BindingBuilder.bind(queue).to(exchange).with("xml.queue.#");
	}

	@Bean
	public MessageConverter jsonMessageConverter(){
		return new Jackson2JsonMessageConverter();
	}

	public AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory){
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(jsonMessageConverter());
		return rabbitTemplate;
	}

	@Bean
	SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
		MessageListenerAdapter listenerAdapter){
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames(queueName);
		container.setMessageListener(listenerAdapter);
		return container;
	}

	/*@Bean
	MessageListenerAdapter listenerAdapter(Object receiver){
		return new MessageListenerAdapter(reciver,"receiveMessage");
	}*/




}

