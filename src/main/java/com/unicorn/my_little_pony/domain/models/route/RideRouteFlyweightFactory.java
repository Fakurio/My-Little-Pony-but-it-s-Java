package com.unicorn.my_little_pony.domain.models.route;

import java.util.HashMap;
import java.util.Map;

// Tydzień 4, Wzorzec Flyweight, Zastosowanie 3
// Fabryka Flyweight - zarządza tworzeniem i współdzieleniem instancji RideRouteFlyweight
public class RideRouteFlyweightFactory {

    private static final Map<String, RideRouteFlyweight> routeMap = new HashMap<>();

    public static RideRouteFlyweight getRideRoute(RideRouteConfig config) {
        return routeMap.computeIfAbsent(config.toKey(), key -> createRoute(config));
    }

    public static int getFlyweightCount() {
        return routeMap.size();
    }

    private static RideRouteFlyweight createRoute(RideRouteConfig config) {
        return switch (config.getRouteType()) {
            case SHORT -> new ShortRideRoute(config);
            case ADVENTURE -> new AdventureRideRoute(config);
        };
    }
}
// Koniec, Tydzień 4, Wzorzec Flyweight, Zastosowanie 3
