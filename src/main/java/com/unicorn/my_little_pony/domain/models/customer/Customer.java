package com.unicorn.my_little_pony.domain.models.customer;

import com.unicorn.my_little_pony.domain.models.customer.builders.CustomerBuilder;
import lombok.Getter;

// Tydzień 2, Wzorzec Prototype, Zastosowanie 1
// Klasa implementuje interfejs Cloneable, co pozwala na tworzenie kopii istniejących obiektów.

@Getter
public class Customer implements Cloneable{
    private final String id;
    private final String name;
    private final String email;
    private final String phone;
    private final boolean isVip;

    public Customer(CustomerIdentity customerIdentity, CustomerContact customerContact, boolean isVip) {
        this.id = customerIdentity.getId();
        this.name = customerIdentity.getName();
        this.email = customerContact.getEmail();
        this.phone = customerContact.getPhone();
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
// Koniec, Tydzień 2, Wzorzec Prototype, Zastosowanie 1
