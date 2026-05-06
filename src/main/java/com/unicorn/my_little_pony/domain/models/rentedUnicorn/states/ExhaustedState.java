package com.unicorn.my_little_pony.domain.models.rentedUnicorn.states;

//Tydzień 6, Wzorzec State, Zastosowanie 3
//Konkretny stan energii jednorożca
public class ExhaustedState implements EnergyState{

    private static final int FULL_STAMINA = 100;

    @Override
    public void gallop(RentedUnicornContext context) {
        System.out.println("Zbyt zmęczony by iść!");
    }

    @Override
    public void rest(RentedUnicornContext context) {
        System.out.println("Jednorożec odpoczywa i odzyskuje siły.");
        context.getUnicorn().setStamina(FULL_STAMINA);
        context.setState(new EnergeticState());
    }
}
// Koniec, Tydzień 6, Wzorzec State