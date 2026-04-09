package com.unicorn.my_little_pony.domain.models.customer.observer;

// Tydzień 6, Wzorzec Observer, Zastosowanie 3
// Klasa odpowiedzialna za obsługę powiadomień o nowych klientach
public class CustomerNotifier implements CustomerObserver {
    @Override
    public void onCustomerUpdate(String clientName) {
        System.out.println("New client added: " + clientName);
    }
}
//Koniec tydzien 6, wzorzec Observer