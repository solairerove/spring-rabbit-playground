package com.github.solairerove.service;

import com.github.solairerove.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RabbitMQProducer {
    @Value("${rabbitmq.fanount.cart.exchange}")
    private String cartFanoutExchange;

    @Value("${rabbitmq.topic.cart.exchange}")
    private String cartTopicExchange;

    private final RabbitTemplate rabbitTemplate;

    public void broadcastUser(User user) {
        log.info(String.format("Message broadcast -> %s", user));
        rabbitTemplate.convertAndSend(cartFanoutExchange, "", user);
    }

    public void sendUser(User user, String routingKey) {
        log.info(String.format("Message sent -> %s", user));
        rabbitTemplate.convertAndSend(cartTopicExchange, routingKey, user);
    }
}
