package com.unicorn.my_little_pony.domain.models.unicorn.equipment.flyweight;

import java.util.HashMap;
import java.util.Map;

// Tydzień 4, Wzorzec Flyweight, Zastosowanie 2
// Fabryka Flyweight - zarządza tworzeniem i udostępnianiem obiektów Flyweight
public class EquipmentFlyweightFactory {

    private static final Map<String, EquipmentFlyweight> equipmentMap = new HashMap<>();

    public static EquipmentFlyweight getEquipmentPackage(EquipmentPackageConfig config) {

        String key = config.toKey();

        if (!equipmentMap.containsKey(key)) {
            switch (config.getPackageType()) {
                case BASIC:
                    equipmentMap.put(
                            key,
                            new BasicEquipmentPackage(
                                    config.getPackageName(),
                                    config.getSaddleType(),
                                    config.getHarnessType(),
                                    config.getDecorationStyle(),
                                    config.getSafetyLevel()
                            )
                    );
                    break;
                case PREMIUM:
                    equipmentMap.put(
                            key,
                            new PremiumEquipmentPackage(
                                    config.getPackageName(),
                                    config.getSaddleType(),
                                    config.getHarnessType(),
                                    config.getDecorationStyle(),
                                    config.getSafetyLevel()
                            )
                    );
                    break;
                default:
                    throw new IllegalArgumentException("Unknown equipment package type: " + config.getPackageType());
            }
        }

        return equipmentMap.get(key);
    }

    public static int getFlyweightCount() {
        return equipmentMap.size();
    }
}
// Koniec, Tydzień 4, Wzorzec Flyweight, Zastosowanie 2
