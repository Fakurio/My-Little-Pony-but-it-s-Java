package com.unicorn.my_little_pony.domain.models.unicorn.equipment.flyweight;

import lombok.Getter;

// Klasa konfiguracyjna grupująca parametry pakietu ekwipunku
// w celu ograniczenia liczby argumentów metody fabryki do jednego
@Getter
public class EquipmentPackageConfig {
    private final EquipmentPackageType packageType;
    private final String packageName;
    private final String saddleType;
    private final String harnessType;
    private final String decorationStyle;
    private final String safetyLevel;

    private EquipmentPackageConfig(Builder builder) {
        this.packageType = builder.packageType;
        this.packageName = builder.packageName;
        this.saddleType = builder.saddleType;
        this.harnessType = builder.harnessType;
        this.decorationStyle = builder.decorationStyle;
        this.safetyLevel = builder.safetyLevel;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String toKey() {
        return packageType.name() + "_" + packageName + "_" + saddleType + "_"
                + harnessType + "_" + decorationStyle + "_" + safetyLevel;
    }

    public static class Builder {
        private EquipmentPackageType packageType;
        private String packageName;
        private String saddleType;
        private String harnessType;
        private String decorationStyle;
        private String safetyLevel;

        public Builder packageType(EquipmentPackageType packageType) {
            this.packageType = packageType;
            return this;
        }

        public Builder packageName(String packageName) {
            this.packageName = packageName;
            return this;
        }

        public Builder saddleType(String saddleType) {
            this.saddleType = saddleType;
            return this;
        }

        public Builder harnessType(String harnessType) {
            this.harnessType = harnessType;
            return this;
        }

        public Builder decorationStyle(String decorationStyle) {
            this.decorationStyle = decorationStyle;
            return this;
        }

        public Builder safetyLevel(String safetyLevel) {
            this.safetyLevel = safetyLevel;
            return this;
        }

        public EquipmentPackageConfig build() {
            return new EquipmentPackageConfig(this);
        }
    }
}
