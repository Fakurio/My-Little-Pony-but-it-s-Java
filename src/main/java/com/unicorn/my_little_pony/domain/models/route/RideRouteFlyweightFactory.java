package com.unicorn.my_little_pony.domain.models.route;

import java.util.HashMap;
import java.util.Map;

// Tydzień 4, Wzorzec Flyweight, Zastosowanie 3
// Fabryka Flyweight - zarządza tworzeniem i współdzieleniem instancji RideRouteFlyweight
public class RideRouteFlyweightFactory {

    private static final Map<String, RideRouteFlyweight> routeMap = new HashMap<>();

    public static RideRouteFlyweight getRideRoute(RideRouteConfig config) {

        String key = config.toKey();

        if (!routeMap.containsKey(key)) {
            switch (config.getRouteType()) {
                case SHORT:
                    routeMap.put(
                            key,
                            new ShortRideRoute(
                                    config.getRouteName(),
                                    config.getDifficultyLevel(),
                                    config.getDefaultDurationMinutes(),
                                    config.getTerrainType()
                            )
                    );
                    break;
                case ADVENTURE:
                    routeMap.put(
                            key,
                            new AdventureRideRoute(
                                    config.getRouteName(),
                                    config.getDifficultyLevel(),
                                    config.getDefaultDurationMinutes(),
                                    config.getTerrainType()
                            )
                    );
                    break;
                default:
                    throw new IllegalArgumentException("Unknown route type: " + config.getRouteType());
            }
        }

        return routeMap.get(key);
    }

    public static int getFlyweightCount() {
        return routeMap.size();
    }
}
// Koniec, Tydzień 4, Wzorzec Flyweight, Zastosowanie 3
