package com.github.solairerove.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CartTopicExchangeRabbitMQConfiguration {
    @Value("${rabbitmq.topic.cart.queue.email}")
    private String emailTopicQueueName;

    @Value("${rabbitmq.topic.cart.queue.delivery}")
    private String deliveryTopicQueueName;

    @Value("${rabbitmq.topic.cart.routing_key.email}")
    private String emailTopicRoutingKey;

    @Value("${rabbitmq.topic.cart.routing_key.delivery}")
    private String deliveryTopicRoutingKey;

    @Value("${rabbitmq.topic.cart.exchange}")
    private String cartTopicExchangeName;

    @Bean
    public Queue emailTopicQueue() {
        return new Queue(emailTopicQueueName);
    }

    @Bean
    public Queue deliveryTopicQueue() {
        return new Queue(deliveryTopicQueueName);
    }

    @Bean
    public TopicExchange cartTopicExchange() {
        return new TopicExchange(cartTopicExchangeName);
    }

    @Bean
    public Binding emailTopicBinding() {
        return BindingBuilder.bind(emailTopicQueue()).to(cartTopicExchange()).with(emailTopicRoutingKey);
    }

    @Bean
    public Binding deliveryTopicBinding() {
        return BindingBuilder.bind(deliveryTopicQueue()).to(cartTopicExchange()).with(deliveryTopicRoutingKey);
    }
}
