package com.unicorn.my_little_pony.domain.models.rentedunicorn.states;

//Tydzień 6, Wzorzec State, Zastosowanie 3
//Konkretny stan energii jednorożca
public class EnergeticState implements EnergyState{

    private static final int GALLOP_STAMINA_COST = 40;
    private static final int TIRED_STAMINA_THRESHOLD = 50;

    @Override
    public void gallop(RentedUnicornContext context) {
        System.out.println("Jednorożec pędzi jak wiatr! (Stamina -" + GALLOP_STAMINA_COST + ")");
        context.getUnicorn().setStamina(context.getUnicorn().getStamina() - GALLOP_STAMINA_COST);

        if (context.getUnicorn().getStamina() < TIRED_STAMINA_THRESHOLD) {
            context.setState(new TiredState());
        }
    }

    @Override
    public void rest(RentedUnicornContext context) {
        System.out.println("Jednorożec jest już wypoczęty.");
    }
}
// Koniec, Tydzień 6, Wzorzec State