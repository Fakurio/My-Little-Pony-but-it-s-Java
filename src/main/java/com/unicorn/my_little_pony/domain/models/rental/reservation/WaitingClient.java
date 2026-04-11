package com.unicorn.my_little_pony.domain.models.rental.reservation;

// Tydzień 6, Wzorzec Observer, Zastosowanie 3
// Interfejs źródła zdarzeń związanych z klientami
public class WaitingClient implements ReservationObserver {
    private String name;

    public WaitingClient(String name) {
        this.name = name;
    }

    @Override
    public void notifyClient(String unicornName) {
        System.out.println(name + " can now rent unicorn: " + unicornName);
    }
}
//Koniec tydzien 6, wzorzec Observer