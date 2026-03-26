package com.unicorn.my_little_pony.domain.pricing;

import lombok.Getter;
import lombok.Setter;

//Tydzień 2, Wzorzec Singleton 1 (Eager Initialization)
//Konfiguracja cen globalna dla całego systemu. Nie ma sensu tworzyć wielu instancji konfiguracji,
//bo wartości powinny być jednolite w całej aplikacji.
@Getter
@Setter
public final class PricingConfig {
    private static final PricingConfig pricingConfig = new PricingConfig();

    private int basePricePerHour = 777;
    private double rainbowPriceRaise = 1.7;

    private PricingConfig() {};

    public static PricingConfig getInstance() {
        return pricingConfig;
    }

    public void printConfig() {
        System.out.println("basePricePerHour = " + basePricePerHour + ", rainbowPriceRaise = " + rainbowPriceRaise);
    }

    //Tydzień 5, Wzorzec Memento, Zastosowanie 3
    // Klasa wew. i metody to zapisania i przywrócenia stanu współczynników cen w systemie
    public static class PricingConfigMemento {
        private final int basePricePerHour;
        private final double rainbowPriceRaise;

        public PricingConfigMemento(int basePricePerHour, double rainbowPriceRaise) {
            this.basePricePerHour = basePricePerHour;
            this.rainbowPriceRaise = rainbowPriceRaise;
        }
    }

    public PricingConfigMemento saveState() {
        System.out.println("Saving price config");
        return new PricingConfigMemento(basePricePerHour, rainbowPriceRaise);
    }

    public void restoreState(PricingConfigMemento memento) {
        this.basePricePerHour = memento.basePricePerHour;
        this.rainbowPriceRaise = memento.rainbowPriceRaise;
        System.out.println("Price config restored");
    }
    // Koniec, Tydzień 5, Wzorzec Memento
}
//Koniec, Tydzień 2, Wzorzec Singleton 1 (Eager Initialization)
