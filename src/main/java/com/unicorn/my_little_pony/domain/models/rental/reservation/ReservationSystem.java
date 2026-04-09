package com.unicorn.my_little_pony.domain.models.rental.reservation;

import java.util.*;

// Tydzień 6, Wzorzec Observer, Zastosowanie 2
// Klasa obsługująca kolejkę rezerwacji i powiadamiająca kolejnego klienta

public class ReservationSystem implements ReservationSubject {
    private Queue<ReservationObserver> queue = new LinkedList<>();
    private String unicornName;

    @Override
    public void registerClient(ReservationObserver observer) {
        queue.add(observer);
    }

    @Override
    public void removeClient(ReservationObserver observer) {
        queue.remove(observer);
    }

    @Override
    public void notifyNext() {
        if (!queue.isEmpty()) {
            ReservationObserver next = queue.poll();
            next.notifyClient(unicornName);
        }
    }

    public void unicornAvailable(String unicornName) {
        this.unicornName = unicornName;
        notifyNext();
    }
}
//Koniec tydzien 6, wzorzec Observer