package com.unicorn.my_little_pony.domain.models.unicorn.observer;
//Tydzien 6, wzorzez Observer, Zastosowanie 1
// Interfejs obserwatora reagującego na zmianę statusu jednorożca
public interface UnicornStatusObserver {
    void onStatusChange(String unicornName, String status);
}
//Koniec tydzien 6, wzorzec Observer