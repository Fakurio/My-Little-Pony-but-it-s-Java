package com.unicorn.my_little_pony.domain.models.rentedUnicorn.states;

//Tydzień 6, Wzorzec State, Zastosowanie 3
//Konkretny stan energii jednorożca
public class EnergeticState implements EnergyState{

    @Override
    public void gallop(RentedUnicornContext context) {
        System.out.println("Jednorożec pędzi jak wiatr! (Stamina -40)");
        context.getUnicorn().setStamina(context.getUnicorn().getStamina() - 40);

        if (context.getUnicorn().getStamina() < 50) {
            context.setState(new TiredState());
        }
    }

    @Override
    public void rest(RentedUnicornContext context) {
        System.out.println("Jednorożec jest już wypoczęty.");
    }
}
// Koniec, Tydzień 6, Wzorzec State