package com.unicorn.my_little_pony.domain.models.customer;

import lombok.Getter;

@Getter
public class CustomerContact {
    private final String email;
    private final String phone;

    public CustomerContact(String email, String phone) {
        this.email = email;
        this.phone = phone;
    }
}
