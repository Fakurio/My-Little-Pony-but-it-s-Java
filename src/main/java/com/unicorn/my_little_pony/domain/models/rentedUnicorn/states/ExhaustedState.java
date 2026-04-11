package com.unicorn.my_little_pony.domain.models.rentedUnicorn.states;

//Tydzień 6, Wzorzec State, Zastosowanie 3
//Konkretny stan energii jednorożca
public class ExhaustedState implements EnergyState{

    @Override
    public void gallop(RentedUnicornContext context) {
        System.out.println("Zbyt zmęczony by iść!");
    }

    @Override
    public void rest(RentedUnicornContext context) {
        System.out.println("Jednorożec odpoczywa i odzyskuje siły.");
        context.getUnicorn().setStamina(100);
        context.setState(new EnergeticState());
    }
}
// Koniec, Tydzień 6, Wzorzec State