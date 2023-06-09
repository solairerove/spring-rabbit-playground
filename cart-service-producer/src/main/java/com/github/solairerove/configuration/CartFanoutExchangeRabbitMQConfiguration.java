package com.github.solairerove.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CartFanoutExchangeRabbitMQConfiguration {
    @Value("${rabbitmq.fanout.cart.queue.email}")
    private String emailQueueName;

    @Value("${rabbitmq.fanout.cart.queue.delivery}")
    private String deliveryQueueName;

    @Value("${rabbitmq.fanount.cart.exchange}")
    private String cartExchangeName;

    @Bean
    public Queue emailQueue() {
        return new Queue(emailQueueName);
    }

    @Bean
    public Queue deliveryQueue() {
        return new Queue(deliveryQueueName);
    }

    @Bean
    public FanoutExchange cartExchange() {
        return new FanoutExchange(cartExchangeName);
    }

    @Bean
    public Binding emailBinding() {
        return BindingBuilder.bind(emailQueue()).to(cartExchange());
    }

    @Bean
    public Binding deliveryBinding() {
        return BindingBuilder.bind(deliveryQueue()).to(cartExchange());
    }
}
