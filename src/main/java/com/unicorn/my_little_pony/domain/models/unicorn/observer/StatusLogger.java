package com.unicorn.my_little_pony.domain.models.unicorn.observer;
// Tydzień 6, Wzorzec Observer, Zastosowanie 1
// Klasa obserwatora logująca zmiany statusu jednorożców
public class StatusLogger implements UnicornStatusObserver {
    @Override
    public void onStatusChange(String unicornName, String status) {
        System.out.println(unicornName + " status: " + status);
    }
}
//Koniec tydzie 6, wzorzec Observer