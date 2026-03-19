package com.unicorn.my_little_pony.domain.facades.returnprocess.services;

// Tydzień 4, Wzorzec Facade
// Serwis sprawdzający stan jednorożca.

public class DamageInspectionService {

    public boolean inspect() {

        boolean damaged = false;

        System.out.println("Unicorn damaged: " + damaged);

        return damaged;
    }
}
//Koniec Tydzień 4, Wzorzec Facade