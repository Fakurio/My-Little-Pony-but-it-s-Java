package com.unicorn.my_little_pony.domain.models.route;

import java.util.HashMap;
import java.util.Map;

// Tydzień 4, Wzorzec Flyweight, Zastosowanie 3
// Fabryka Flyweight - zarządza tworzeniem i współdzieleniem instancji RideRouteFlyweight
public class RideRouteFlyweightFactory {

    private static final Map<String, RideRouteFlyweight> routeMap = new HashMap<>();

    public static RideRouteFlyweight getRideRoute(
            String routeType,
            String routeName,
            String difficultyLevel,
            int defaultDurationMinutes,
            String terrainType) {

        String normalizedType = routeType.toUpperCase();
        String key;

        if ("SHORT".equalsIgnoreCase(normalizedType)) {
            key = normalizedType + "_" + routeName + "_" + defaultDurationMinutes + "_" + terrainType;
            if (!routeMap.containsKey(key)) {
                routeMap.put(
                        key,
                        new ShortRideRoute(
                                routeName,
                                defaultDurationMinutes,
                                terrainType
                        )
                );
            }
        } else if ("ADVENTURE".equalsIgnoreCase(normalizedType)) {
            boolean requiresGuide = "HARD".equalsIgnoreCase(difficultyLevel)
                    || "EXTREME".equalsIgnoreCase(difficultyLevel)
                    || defaultDurationMinutes >= 45;
            key = normalizedType + "_" + routeName + "_" + difficultyLevel + "_"
                    + defaultDurationMinutes + "_" + terrainType + "_" + requiresGuide;
            if (!routeMap.containsKey(key)) {
                routeMap.put(
                        key,
                        new AdventureRideRoute(
                                routeName,
                                defaultDurationMinutes,
                                terrainType,
                                difficultyLevel,
                                requiresGuide
                        )
                );
            }
        } else {
            throw new IllegalArgumentException("Unknown route type: " + routeType);
        }

        return routeMap.get(key);
    }

    public static int getFlyweightCount() {
        return routeMap.size();
    }
}
// Koniec, Tydzień 4, Wzorzec Flyweight, Zastosowanie 3
