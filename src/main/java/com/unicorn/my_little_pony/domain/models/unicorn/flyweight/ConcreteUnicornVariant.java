package com.unicorn.my_little_pony.domain.models.unicorn.flyweight;

// Tydzień 4, Wzorzec Flyweight, Zastosowanie 1
// Właściwa implementacja flyweighta, tylko dane współdzielone.
public class ConcreteUnicornVariant implements UnicornVariantFlyweight {

    private final String breed;
    private final String hornStyle;
    private final String wingType;
    private final String maneColor;
    private final String magicAura;

    public ConcreteUnicornVariant(
            String breed,
            String hornStyle,
            String wingType,
            String maneColor,
            String magicAura) {

        this.breed = breed;
        this.hornStyle = hornStyle;
        this.wingType = wingType;
        this.maneColor = maneColor;
        this.magicAura = magicAura;
    }

    @Override
    public String getBreed() {
        return breed;
    }

    @Override
    public String getHornStyle() {
        return hornStyle;
    }

    @Override
    public String getWingType() {
        return wingType;
    }

    @Override
    public String getManeColor() {
        return maneColor;
    }

    @Override
    public String getMagicAura() {
        return magicAura;
    }

    @Override
    public String describe() {
        return breed + " [horn=" + hornStyle +
                ", wings=" + wingType +
                ", mane=" + maneColor +
                ", aura=" + magicAura + "]";
    }
}
// Koniec, Tydzień 4, Wzorzec Flyweight, Zastosowanie 1
