package com.unicorn.my_little_pony.domain.models.rentedUnicorn.states;

//Tydzień 6, Wzorzec State, Zastosowanie 3
//Konkretny stan energii jednorożca
public class TiredState implements EnergyState{

    @Override
    public void gallop(RentedUnicornContext context) {
        System.out.println("Jednorożec truchta wolniej... (Stamina -30)");
        context.getUnicorn().setStamina(context.getUnicorn().getStamina() - 30);

        if (context.getUnicorn().getStamina() <= 0) {
            System.out.println("Jednorożec opadł z sił!");
            context.setState(new ExhaustedState());
        }
    }

    @Override
    public void rest(RentedUnicornContext context) {
        System.out.println("Jednorożec odpoczywa i odzyskuje siły.");
        context.getUnicorn().setStamina(100);
        context.setState(new EnergeticState());
    }
}
// Koniec, Tydzień 6, Wzorzec State