package com.unicorn.my_little_pony.domain.models.unicorn.equipment.flyweight;

import java.util.HashMap;
import java.util.Map;

// Tydzień 4, Wzorzec Flyweight, Zastosowanie 2
// Fabryka Flyweight - zarządza tworzeniem i udostępnianiem obiektów Flyweight
public class EquipmentFlyweightFactory {

    private static final Map<String, EquipmentFlyweight> equipmentMap = new HashMap<>();

    public static EquipmentFlyweight getEquipmentPackage(EquipmentPackageConfig config) {
        return equipmentMap.computeIfAbsent(config.toKey(), key -> createPackage(config));
    }

    public static int getFlyweightCount() {
        return equipmentMap.size();
    }

    private static EquipmentFlyweight createPackage(EquipmentPackageConfig config) {
        return switch (config.getPackageType()) {
            case BASIC -> new BasicEquipmentPackage(config);
            case PREMIUM -> new PremiumEquipmentPackage(config);
        };
    }
}
// Koniec, Tydzień 4, Wzorzec Flyweight, Zastosowanie 2
