package com.github.solairerove.service;

import com.github.solairerove.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQConsumer.class);

    @RabbitListener(queues = {"${rabbitmq.fanout.cart.queue.email}"})
    public void consume(User message) {
        LOGGER.info(String.format("Received fanout email message -> %s, %s", message.id(), message.name()));
    }
}
