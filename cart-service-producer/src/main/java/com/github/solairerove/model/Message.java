package com.github.solairerove.model;

import java.io.Serializable;

public record Message(User user, String routingKey) implements Serializable {
}
