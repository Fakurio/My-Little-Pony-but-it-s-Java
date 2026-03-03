package com.unicorn.my_little_pony.domain.models.customer;

import com.unicorn.my_little_pony.domain.models.customer.builders.CustomerBuilder;
import lombok.Getter;

// Tydzień 2, Wzorzec Prototype
// Klasa implementuje interfejs Cloneable, co pozwala na tworzenie kopii istniejących obiektów.

@Getter
public class Customer implements Cloneable{
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

    @Override
    public Customer clone() {
        return new CustomerBuilder()
                .name(this.name)
                .email(this.email)
                .phone(this.phone)
                .vip(this.isVip)
                .build();
    }
}