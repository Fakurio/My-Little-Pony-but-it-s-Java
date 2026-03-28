package com.unicorn.my_little_pony.domain.models.rentedUnicorn.states;

import com.unicorn.my_little_pony.domain.models.rentedUnicorn.RentedUnicorn;

//Tydzień 6, Wzorzec State, Zastosowanie 3
//Konkretny stan energii jednorożca
public class EnergeticState implements EnergyState{

    @Override
    public void gallop(RentedUnicorn context) {
        System.out.println("Jednorożec pędzi jak wiatr! (Stamina -40)");
        context.setStamina(context.getStamina() - 40);

        if (context.getStamina() < 50) {
            context.setState(new TiredState());
        }
    }

    @Override
    public void rest(RentedUnicorn context) {
        System.out.println("Jednorożec jest już wypoczęty.");
    }
}
// Koniec, Tydzień 6, Wzorzec State