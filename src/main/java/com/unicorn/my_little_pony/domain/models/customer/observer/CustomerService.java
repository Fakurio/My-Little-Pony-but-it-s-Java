package com.unicorn.my_little_pony.domain.models.customer.observer;

import java.util.*;
// Tydzień 6, Wzorzec Observer, Zastosowanie 3
// Klasa zarządzająca klientami i powiadamiająca o ich dodaniu
public class CustomerService implements CustomerSubject {
    private List<CustomerObserver> observers = new ArrayList<>();
    private String clientName;

    @Override
    public void addListener(CustomerObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeListener(CustomerObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (CustomerObserver o : observers) {
            o.onCustomerUpdate(clientName);
        }
    }

    public void addClient(String name) {
        this.clientName = name;
        notifyObservers();
    }
}
//Koniec tydzien 6, wzorzec Observer