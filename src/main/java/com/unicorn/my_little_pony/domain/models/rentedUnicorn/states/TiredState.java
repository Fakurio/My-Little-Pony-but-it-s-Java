package com.unicorn.my_little_pony.domain.models.rentedUnicorn.states;

import com.unicorn.my_little_pony.domain.models.rentedUnicorn.RentedUnicorn;

//Tydzień 6, Wzorzec State, Zastosowanie 3
//Konkretny stan energii jednorożca
public class TiredState implements EnergyState{

    @Override
    public void gallop(RentedUnicorn context) {
        System.out.println("Jednorożec truchta wolniej... (Stamina -30)");
        context.setStamina(context.getStamina() - 30);

        if (context.getStamina() <= 0) {
            System.out.println("Jednorożec opadł z sił!");
            context.setState(new ExhaustedState());
        }
    }

    @Override
    public void rest(RentedUnicorn context) {
        System.out.println("Jednorożec odpoczywa i odzyskuje siły.");
        context.setStamina(100);
        context.setState(new EnergeticState());
    }
}
// Koniec, Tydzień 6, Wzorzec State