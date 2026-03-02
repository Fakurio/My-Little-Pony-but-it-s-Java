package com.unicorn.my_little_pony.domain.models.customer;

import java.util.ArrayList;
import java.util.List;

// Tydzień 2, Wzorzec Prototype
// Klasa implementuje interfejs Cloneable, co pozwala na tworzenie kopii istniejących obiektów.

public class CustomerPrototype implements Cloneable {

    private List<Customer> customerList;

    public CustomerPrototype() {
        this.customerList = new ArrayList<>();
    }

    public CustomerPrototype(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public void loadCustomerTemplates() {
        customerList.add(new Customer("C-TEMPLATE-1", "Alice", "alice@mail.com", "123456789", false));
        customerList.add(new Customer("C-TEMPLATE-2", "Bob", "bob@mail.com", "987654321", true));
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        List<Customer> clonedList = new ArrayList<>();

        this.getCustomerList().forEach(customer -> {
           clonedList.add(new Customer(
                    customer.getId(),
                    customer.getName(),
                    customer.getEmail(),
                    customer.getPhone(),
                    customer.isVip()
            ));
        });

        return new CustomerPrototype(clonedList);
    }
}
// Koniec, Tydzień 2, Wzorzec Prototype