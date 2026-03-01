package com.unicorn.my_little_pony.domain.pricing;

//Tydzień 2, Wzorzec Singleton 1 (Eager Initialization)
//Konfiguracja cen globalna dla całego systemu. Nie ma sensu tworzyć wielu instancji konfiguracji,
//bo wartości powinny być jednolite w całej aplikacji.
public final class PricingConfig {
    private static final PricingConfig pricingConfig = new PricingConfig();

    private final int basePricePerHour = 777;
    private final double rainbowPriceRaise = 1.7;

    private PricingConfig() {};

    public static PricingConfig getInstance() {
        return pricingConfig;
    }

    public int getBasePricePerHour() {
        return basePricePerHour;
    }
    public double getRainbowPriceRaise() {
        return rainbowPriceRaise;
    }
}
//Koniec, Tydzień 2, Wzorzec Singleton 1 (Eager Initialization)
