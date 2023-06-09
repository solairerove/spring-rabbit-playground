package com.github.solairerove;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQConsumer.class);

    @RabbitListener(queues = {"${rabbitmq.fanout.cart.queue.email}"})
    public void consume(User message) {
        LOGGER.info(String.format("Received delivery message -> %s, %s", message.getId(), message.getName()));
    }
}
