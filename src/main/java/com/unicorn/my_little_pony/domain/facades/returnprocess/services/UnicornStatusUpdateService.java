package com.unicorn.my_little_pony.domain.facades.returnprocess.services;

// Tydzień 4, Wzorzec Facade
// Serwis aktualizujący status jednorożca.

import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;
import com.unicorn.my_little_pony.enums.UnicornStatus;

public class UnicornStatusUpdateService {

    public void updateStatus(Unicorn unicorn) {

        unicorn.setStatus(UnicornStatus.AVAILABLE);

        System.out.println("Unicorn " + unicorn.getId() + " is now AVAILABLE");
    }
}
//Koniec Tydzień 4, Wzorzec Facade