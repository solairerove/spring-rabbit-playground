package com.github.solairerove.controller;

import com.github.solairerove.service.RabbitMQProducer;
import com.github.solairerove.model.User;
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

    @PostMapping("/message/send")
    public String broadcastUser(@RequestBody User user) {
        rabbitMQProducer.broadcastMessage(user);

        return "Message sent successfully";
    }
}
