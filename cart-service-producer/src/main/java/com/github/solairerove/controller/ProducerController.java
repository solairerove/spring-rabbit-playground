package com.github.solairerove.controller;

import com.github.solairerove.model.Message;
import com.github.solairerove.model.User;
import com.github.solairerove.service.RabbitMQProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProducerController {

    private final RabbitMQProducer rabbitMQProducer;

    @PostMapping("/message/broadcast")
    public String broadcastUser(@RequestBody User user) {
        rabbitMQProducer.broadcastUser(user);

        return "Message broadcast successfully";
    }

    @PostMapping("/message/send")
    public String sendMessage(@RequestBody Message message) {
        rabbitMQProducer.sendUser(message.user(), message.routingKey());

        return "Message sent successfully";
    }
}
