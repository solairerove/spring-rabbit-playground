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
    private String exchange;

    private final RabbitTemplate rabbitTemplate;

    public void broadcastMessage(User user) {
        log.info(String.format("Message sent -> %s", user));
        rabbitTemplate.convertAndSend(exchange, "", user);
    }
}
