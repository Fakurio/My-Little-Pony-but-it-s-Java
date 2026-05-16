package com.unicorn.my_little_pony.domain.models.rentedunicorn.states;

//Tydzień 6, Wzorzec State, Zastosowanie 3
//Konkretny stan energii jednorożca
public class TiredState implements EnergyState{

    private static final int GALLOP_STAMINA_COST = 30;
    private static final int EXHAUSTED_STAMINA_THRESHOLD = 0;
    private static final int FULL_STAMINA = 100;

    @Override
    public void gallop(RentedUnicornContext context) {
        System.out.println("Jednorożec truchta wolniej... (Stamina -" + GALLOP_STAMINA_COST + ")");
        context.getUnicorn().setStamina(context.getUnicorn().getStamina() - GALLOP_STAMINA_COST);

        if (context.getUnicorn().getStamina() <= EXHAUSTED_STAMINA_THRESHOLD) {
            System.out.println("Jednorożec opadł z sił!");
            context.setState(new ExhaustedState());
        }
    }

    @Override
    public void rest(RentedUnicornContext context) {
        System.out.println("Jednorożec odpoczywa i odzyskuje siły.");
        context.getUnicorn().setStamina(FULL_STAMINA);
        context.setState(new EnergeticState());
    }
}
// Koniec, Tydzień 6, Wzorzec State