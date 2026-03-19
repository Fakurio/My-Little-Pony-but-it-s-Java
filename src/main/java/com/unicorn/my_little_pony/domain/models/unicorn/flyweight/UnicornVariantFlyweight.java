package com.unicorn.my_little_pony.domain.models.unicorn.flyweight;

// Tydzień 4, Wzorzec Flyweight, Zastosowanie 1
// Interfejs Flyweight - definiuje metody do uzyskiwania właściwości wariantu jednorożca
// Ten interfejs reprezentuje stan wewnętrzny, który może być współdzielony.
public interface UnicornVariantFlyweight {
    String getBreed();

    String getHornStyle();

    String getWingType();

    String getManeColor();

    String getMagicAura();

    String describe();
}
// Koniec, Tydzień 4, Wzorzec Flyweight, Zastosowanie 1


