package com.unicorn.my_little_pony.domain.models.customer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {
    private final String id;
    private final String name;
    private final String email;
    private final String phone;
    private final boolean isVip;

    public Customer(String id, String name, String email, String phone, boolean isVip) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.isVip = isVip;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", isVip=" + isVip +
                '}';
    }
}