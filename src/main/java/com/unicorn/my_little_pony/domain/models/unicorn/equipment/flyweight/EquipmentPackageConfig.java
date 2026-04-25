package com.unicorn.my_little_pony.domain.models.unicorn.equipment.flyweight;

import lombok.AllArgsConstructor;
import lombok.Getter;

// Klasa konfiguracyjna grupująca parametry pakietu ekwipunku
// w celu ograniczenia liczby argumentów metody fabryki do jednego
@Getter
@AllArgsConstructor
public class EquipmentPackageConfig {
    private final EquipmentPackageType packageType;
    private final String packageName;
    private final String saddleType;
    private final String harnessType;
    private final String decorationStyle;
    private final String safetyLevel;

    public String toKey() {
        return packageType.name() + "_" + packageName + "_" + saddleType + "_"
                + harnessType + "_" + decorationStyle + "_" + safetyLevel;
    }
}
