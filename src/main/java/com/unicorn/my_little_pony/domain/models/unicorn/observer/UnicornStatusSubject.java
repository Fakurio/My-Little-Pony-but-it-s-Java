package com.unicorn.my_little_pony.domain.models.unicorn.observer;

//Tydzien 6, wzorzez Observer, Zastosowanie 1
//Interfejs reprezentujący źródło zmian statusu jednorożca
public interface UnicornStatusSubject {
    void addObserver(UnicornStatusObserver observer);
    void removeObserver(UnicornStatusObserver observer);
    void notifyObservers();
}
//Koniec tydzien 6, wzorzec Observer