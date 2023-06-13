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
    private String emailFanoutQueueName;

    @Value("${rabbitmq.fanout.cart.queue.delivery}")
    private String deliveryFanoutQueueName;

    @Value("${rabbitmq.fanount.cart.exchange}")
    private String cartFanoutExchangeName;

    @Bean
    public Queue emailFanoutQueue() {
        return new Queue(emailFanoutQueueName);
    }

    @Bean
    public Queue deliveryFanoutQueue() {
        return new Queue(deliveryFanoutQueueName);
    }

    @Bean
    public FanoutExchange cartFanoutExchange() {
        return new FanoutExchange(cartFanoutExchangeName);
    }

    @Bean
    public Binding emailFanoutBinding() {
        return BindingBuilder.bind(emailFanoutQueue()).to(cartFanoutExchange());
    }

    @Bean
    public Binding deliveryFanoutBinding() {
        return BindingBuilder.bind(deliveryFanoutQueue()).to(cartFanoutExchange());
    }
}
