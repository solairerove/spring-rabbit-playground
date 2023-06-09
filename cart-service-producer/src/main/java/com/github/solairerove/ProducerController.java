package com.github.solairerove;

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
    public String publishUser(@RequestBody User user) {
        rabbitMQProducer.sendMessage(user);

        return "Message sent successfully";
    }
}
