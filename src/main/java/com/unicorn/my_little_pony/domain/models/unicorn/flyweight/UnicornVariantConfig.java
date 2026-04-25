package com.unicorn.my_little_pony.domain.models.unicorn.flyweight;

import lombok.AllArgsConstructor;
import lombok.Getter;

// Klasa konfiguracyjna grupująca parametry wariantu jednorożca
// w celu ograniczenia liczby argumentów metody fabryki do jednego
@Getter
@AllArgsConstructor
public class UnicornVariantConfig {
    private final String breed;
    private final String hornStyle;
    private final String wingType;
    private final String maneColor;
    private final String magicAura;

    public String toKey() {
        return breed + "_" + hornStyle + "_" + wingType + "_" + maneColor + "_" + magicAura;
    }
}
