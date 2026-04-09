package com.unicorn.my_little_pony.domain.models.unicorn.observer;

import java.util.*;

//Tydzien 6, wzorzez Observer, Zastosowanie 1
// Klasa zarządzająca statusem jednorożców i powiadamiająca obserwatorów o zmianach

public class UnicornStatusManager implements UnicornStatusSubject {
    private List<UnicornStatusObserver> observers = new ArrayList<>();
    private String unicornName;
    private String status;

    @Override
    public void addObserver(UnicornStatusObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(UnicornStatusObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (UnicornStatusObserver o : observers) {
            o.onStatusChange(unicornName, status);
        }
    }

    public void updateStatus(String unicornName, String status) {
        this.unicornName = unicornName;
        this.status = status;
        notifyObservers();
    }
}
//Koniec tydzien 6, wzorzec Observer