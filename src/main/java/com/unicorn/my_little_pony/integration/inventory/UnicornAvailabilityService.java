package com.unicorn.my_little_pony.integration.inventory;

//Tydzień 3, Wzorzec Adapter 3 (przez dziedziczenie)
//Interfejs, który jest znany przez system, ale nie jest
// kompatybilny z klasą, którą chcemy użyć (UnicornStore).
public interface UnicornAvailabilityService {
    boolean isAvailable(String unicornName);
}
//Koniec, Tydzień 3, Wzorzec Adapter 3