package com.github.solairerove.model;

import java.io.Serializable;

public record User(Integer id, String name) implements Serializable {
}
