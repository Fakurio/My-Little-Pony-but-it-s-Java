package com.unicorn.my_little_pony.domain.models.customer.builders;

import com.unicorn.my_little_pony.domain.models.customer.Customer;
import com.unicorn.my_little_pony.util.IdGenerator;

// Tydzień 2, Wzorzec Builder
// Builder dla obiektów Customer.
public class CustomerBuilder {

    private String name;
    private String email;
    private String phone;
    private boolean isVip = false;

    private String generateId() {
        return IdGenerator.getInstance().nextCustomerId();
    }

    public CustomerBuilder name(String name) {
        this.name = name;
        return this;
    }

    public CustomerBuilder email(String email) {
        this.email = email;
        return this;
    }

    public CustomerBuilder phone(String phone) {
        this.phone = phone;
        return this;
    }

    public CustomerBuilder vip(boolean isVip) {
        this.isVip = isVip;
        return this;
    }

    public Customer build() {
        Customer customer = new Customer(
                generateId(),
                name,
                email,
                phone,
                isVip
        );
        return customer;
    }
}
// Koniec, Tydzień 2, Wzorzec Builder