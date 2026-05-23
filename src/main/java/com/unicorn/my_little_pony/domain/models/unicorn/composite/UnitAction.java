package com.unicorn.my_little_pony.domain.models.unicorn.composite;

//Tydzień 10, Interfejs funkcyjny do wykonywania akcji na jednostce
@FunctionalInterface
public interface UnitAction {
    void perform(UnicornUnit unit);
}
//Koniec, Tydzień 10
