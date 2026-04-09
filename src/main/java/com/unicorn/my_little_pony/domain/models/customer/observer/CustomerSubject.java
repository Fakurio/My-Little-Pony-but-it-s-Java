package com.unicorn.my_little_pony.domain.models.customer.observer;
// Tydzień 6, Wzorzec Observer, Zastosowanie 3
// Interfejs źródła zdarzeń związanych z klientami
public interface CustomerSubject {
    void addListener(CustomerObserver observer);
    void removeListener(CustomerObserver observer);
    void notifyObservers();
}
//Koniec tydzien 6, wzorzec Observer
