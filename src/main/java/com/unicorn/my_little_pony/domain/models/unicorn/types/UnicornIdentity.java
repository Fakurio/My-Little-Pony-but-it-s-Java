package com.unicorn.my_little_pony.domain.models.unicorn.types;

import lombok.Getter;

@Getter
public class UnicornIdentity {
    private final String id;
    private final String name;
    private final String color;

    public UnicornIdentity(String id, String name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }
}
