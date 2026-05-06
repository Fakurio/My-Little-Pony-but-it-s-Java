package com.unicorn.my_little_pony.domain.models.unicorn.flyweight;

import lombok.Getter;

// Klasa konfiguracyjna grupująca parametry wariantu jednorożca
// w celu ograniczenia liczby argumentów metody fabryki do jednego
@Getter
public class UnicornVariantConfig {
    private final String breed;
    private final String hornStyle;
    private final String wingType;
    private final String maneColor;
    private final String magicAura;

    private UnicornVariantConfig(Builder builder) {
        this.breed = builder.breed;
        this.hornStyle = builder.hornStyle;
        this.wingType = builder.wingType;
        this.maneColor = builder.maneColor;
        this.magicAura = builder.magicAura;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String toKey() {
        return breed + "_" + hornStyle + "_" + wingType + "_" + maneColor + "_" + magicAura;
    }

    public static class Builder {
        private String breed;
        private String hornStyle;
        private String wingType;
        private String maneColor;
        private String magicAura;

        public Builder breed(String breed) {
            this.breed = breed;
            return this;
        }

        public Builder hornStyle(String hornStyle) {
            this.hornStyle = hornStyle;
            return this;
        }

        public Builder wingType(String wingType) {
            this.wingType = wingType;
            return this;
        }

        public Builder maneColor(String maneColor) {
            this.maneColor = maneColor;
            return this;
        }

        public Builder magicAura(String magicAura) {
            this.magicAura = magicAura;
            return this;
        }

        public UnicornVariantConfig build() {
            return new UnicornVariantConfig(this);
        }
    }
}
