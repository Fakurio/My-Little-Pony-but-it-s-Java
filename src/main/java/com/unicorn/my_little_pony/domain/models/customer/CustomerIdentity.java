package com.unicorn.my_little_pony.domain.models.customer;

import lombok.Getter;

@Getter
public class CustomerIdentity {
    private final String id;
    private final String name;

    public CustomerIdentity(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
