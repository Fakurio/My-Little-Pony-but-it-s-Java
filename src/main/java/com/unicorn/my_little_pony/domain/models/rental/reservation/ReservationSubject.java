package com.unicorn.my_little_pony.domain.models.rental.reservation;
// Tydzień 6, Wzorzec Observer, Zastosowanie 2
// Interfejs systemu rezerwacji zarządzającego kolejką oczekujących klientów
public interface ReservationSubject {
    void registerClient(ReservationObserver observer);
    void removeClient(ReservationObserver observer);
    void notifyNext();
}
//Koniec tydzien 6, wzorzec Observer