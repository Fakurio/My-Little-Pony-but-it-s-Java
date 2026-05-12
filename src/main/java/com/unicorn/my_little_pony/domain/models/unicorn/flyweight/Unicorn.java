package com.unicorn.my_little_pony.domain.models.unicorn.flyweight;

// Tydzień 4, Wzorzec Flyweight, Zastosowanie 1
// Flyweight przechowuje stan wewnętrzny, a kontekst trzyma stan zewnętrzny.
public class Unicorn {

    private final String id;
    private final String name;

    private final UnicornVariantFlyweight unicornVariant;

    private final String stableLocation;
    private final boolean available;

    private Unicorn(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.unicornVariant = builder.unicornVariant;
        this.stableLocation = builder.stableLocation;
        this.available = builder.available;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getDescription() {
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

    public static class Builder {
        private String id;
        private String name;
        private UnicornVariantFlyweight unicornVariant;
        private String stableLocation;
        private boolean available;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder unicornVariant(UnicornVariantFlyweight unicornVariant) {
            this.unicornVariant = unicornVariant;
            return this;
        }

        public Builder stableLocation(String stableLocation) {
            this.stableLocation = stableLocation;
            return this;
        }

        public Builder available(boolean available) {
            this.available = available;
            return this;
        }

        public Unicorn build() {
            return new Unicorn(this);
        }
    }
}
// Koniec, Tydzień 4, Wzorzec Flyweight, Zastosowanie 1
