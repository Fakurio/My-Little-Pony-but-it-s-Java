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

        String key = routeType + "_" + routeName + "_" + difficultyLevel + "_"
                + defaultDurationMinutes + "_" + terrainType;

        if (!routeMap.containsKey(key)) {
            if ("SHORT".equalsIgnoreCase(routeType)) {
                routeMap.put(
                        key,
                        new ShortRideRoute(
                                routeName,
                                difficultyLevel,
                                defaultDurationMinutes,
                                terrainType
                        )
                );
            } else if ("ADVENTURE".equalsIgnoreCase(routeType)) {
                routeMap.put(
                        key,
                        new AdventureRideRoute(
                                routeName,
                                difficultyLevel,
                                defaultDurationMinutes,
                                terrainType
                        )
                );
            } else {
                throw new IllegalArgumentException("Unknown route type: " + routeType);
            }
        }

        return routeMap.get(key);
    }

    public static int getFlyweightCount() {
        return routeMap.size();
    }
}
// Koniec, Tydzień 4, Wzorzec Flyweight, Zastosowanie 3
