package com.unicorn.my_little_pony.domain.models.unicorn.equipment.flyweight;

import java.util.HashMap;
import java.util.Map;

// Tydzień 4, Wzorzec Flyweight, Zastosowanie 2
// Fabryka Flyweight - zarządza tworzeniem i udostępnianiem obiektów Flyweight
public class EquipmentFlyweightFactory {

    private static final Map<String, EquipmentFlyweight> equipmentMap = new HashMap<>();

    public static EquipmentFlyweight getEquipmentPackage(
            String packageType,
            String packageName,
            String saddleType,
            String harnessType,
            String decorationStyle,
            String safetyLevel) {

        String normalizedType = packageType.toUpperCase();
        String key;

        if ("BASIC".equalsIgnoreCase(normalizedType)) {
            key = normalizedType + "_" + packageName + "_" + saddleType + "_" + harnessType;
            if (!equipmentMap.containsKey(key)) {
                equipmentMap.put(
                        key,
                        new BasicEquipmentPackage(
                                packageName,
                                saddleType,
                                harnessType
                        )
                );
            }
        } else if ("PREMIUM".equalsIgnoreCase(normalizedType)) {
            key = normalizedType + "_" + packageName + "_" + saddleType + "_"
                    + harnessType + "_" + decorationStyle + "_" + safetyLevel;
            if (!equipmentMap.containsKey(key)) {
                equipmentMap.put(
                        key,
                        new PremiumEquipmentPackage(
                                packageName,
                                saddleType,
                                harnessType,
                                decorationStyle,
                                safetyLevel
                        )
                );
            }
        } else {
            throw new IllegalArgumentException("Unknown equipment package type: " + packageType);
        }

        return equipmentMap.get(key);
    }

    public static int getFlyweightCount() {
        return equipmentMap.size();
    }
}
// Koniec, Tydzień 4, Wzorzec Flyweight, Zastosowanie 2
