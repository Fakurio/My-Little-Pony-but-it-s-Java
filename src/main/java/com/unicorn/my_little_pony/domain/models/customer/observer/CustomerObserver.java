package com.unicorn.my_little_pony.domain.models.customer.observer;

// Tydzień 6, Wzorzec Observer, Zastosowanie 3
// Interfejs obserwatora reagującego na dodanie nowego klienta
public interface CustomerObserver {
    void onCustomerUpdate(String clientName);

}
//Koniec tydzien 6, wzorzec Observer