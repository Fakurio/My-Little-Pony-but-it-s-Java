package com.unicorn.my_little_pony.domain.models.unicorn.flyweight;

// Tydzień 4, Wzorzec Flyweight, Zastosowanie 1
// Flyweight przechowuje stan wewnętrzny, a kontekst trzyma stan zewnętrzny.
public class Unicorn {

    private final String id;
    private final String name;

    private final UnicornVariantFlyweight unicornVariant;

    private String stableLocation;
    private boolean available;

    public Unicorn(
            String id,
            String name,
            UnicornVariantFlyweight unicornVariant,
            String stableLocation,
            boolean available) {

        this.id = id;
        this.name = name;
        this.unicornVariant = unicornVariant;
        this.stableLocation = stableLocation;
        this.available = available;
    }

    public String getInfo() {
        return "Unicorn{id='" + id +
                "', name='" + name +
                "', type=" + unicornVariant.describe() +
                ", stable='" + stableLocation +
                "', available=" + available +
                "}";
    }

    public UnicornVariantFlyweight getType() {
        return unicornVariant;
    }
}
// Koniec, Tydzień 4, Wzorzec Flyweight, Zastosowanie 1
