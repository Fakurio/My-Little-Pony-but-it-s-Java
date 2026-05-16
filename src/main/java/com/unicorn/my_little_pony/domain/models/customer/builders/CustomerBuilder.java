package com.unicorn.my_little_pony.domain.models.customer.builders;

import com.unicorn.my_little_pony.domain.models.customer.Customer;
import com.unicorn.my_little_pony.domain.models.customer.CustomerContact;
import com.unicorn.my_little_pony.domain.models.customer.CustomerIdentity;
import com.unicorn.my_little_pony.util.IdGenerator;

// Tydzień 2, Wzorzec Builder, Zastosowanie 1
// Builder dla obiektów Customer.
public class CustomerBuilder {

    private String id;
    private String name;
    private String email;
    private String phone;
    private boolean isVip = false;

    private String resolveId() {
        if (id != null) {
            return id;
        }
        return IdGenerator.getInstance().nextCustomerId();
    }

    public CustomerBuilder id(String id) {
        this.id = id;
        return this;
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
        CustomerIdentity customerIdentity = new CustomerIdentity(resolveId(), name);
        CustomerContact customerContact = new CustomerContact(email, phone);
        return new Customer(customerIdentity, customerContact, isVip);
    }
}
// Koniec, Tydzień 2, Wzorzec Builder, Zastosowanie 1
