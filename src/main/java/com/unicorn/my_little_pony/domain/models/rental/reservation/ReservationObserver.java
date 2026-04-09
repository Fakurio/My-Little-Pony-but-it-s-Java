package com.unicorn.my_little_pony.domain.models.rental.reservation;

// Tydzień 6, Wzorzec Observer, Zastosowanie 2
// Interfejs klienta oczekującego na dostępność jednorożca
public interface ReservationObserver {
    void notifyClient(String unicornName);
}
//Koniec tydzien 6, wzorzec Observer