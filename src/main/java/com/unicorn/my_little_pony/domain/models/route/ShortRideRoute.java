package com.unicorn.my_little_pony.domain.models.route;

// Tydzień 4, Wzorzec Flyweight, Zastosowanie 3
// Konkretna klasa Flyweight - reprezentuje konkretny typ trasy przejażdżki, który może być współdzielony
public class ShortRideRoute implements RideRouteFlyweight {

    private final String routeName;
    private final int defaultDurationMinutes;
    private final String terrainType;

    public ShortRideRoute(
            String routeName,
            int defaultDurationMinutes,
            String terrainType) {
        this.routeName = routeName;
        this.defaultDurationMinutes = defaultDurationMinutes;
        this.terrainType = terrainType;
    }

    @Override
    public String getRouteTypeLabel() {
        return "SHORT";
    }

    public int getDefaultDurationMinutes() {
        return defaultDurationMinutes;
    }

    public String getTerrainType() {
        return terrainType;
    }

    @Override
    public String getRouteProfile() {
        return "duration=" + defaultDurationMinutes + " min, terrain=" + terrainType;
    }

    @Override
    public String describe() {
        return "ShortRideRoute{" +
                "routeType='" + getRouteTypeLabel() + '\'' +
                ", routeName='" + routeName + '\'' +
                ", defaultDurationMinutes=" + defaultDurationMinutes +
                ", terrainType='" + terrainType + '\'' +
                '}';
    }
}
// Koniec, Tydzień 4, Wzorzec Flyweight, Zastosowanie 3
