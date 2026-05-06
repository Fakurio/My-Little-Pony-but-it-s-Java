package com.unicorn.my_little_pony.domain.models.route;

// Tydzień 4, Wzorzec Flyweight, Zastosowanie 3
// Konkretna klasa Flyweight - reprezentuje konkretny typ trasy przejażdżki, który może być współdzielony
public class ShortRideRoute implements RideRouteFlyweight {

    private final String routeName;
    private final String difficultyLevel;
    private final int defaultDurationMinutes;
    private final String terrainType;

    public ShortRideRoute(RideRouteConfig routeConfig) {
        this.routeName = routeConfig.getRouteName();
        this.difficultyLevel = routeConfig.getDifficultyLevel();
        this.defaultDurationMinutes = routeConfig.getDefaultDurationMinutes();
        this.terrainType = routeConfig.getTerrainType();
    }

    @Override
    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    @Override
    public int getDefaultDurationMinutes() {
        return defaultDurationMinutes;
    }

    @Override
    public String getTerrainType() {
        return terrainType;
    }

    @Override
    public String describe() {
        return "ShortRideRoute{" +
                "routeName='" + routeName + '\'' +
                ", difficultyLevel='" + difficultyLevel + '\'' +
                ", defaultDurationMinutes=" + defaultDurationMinutes +
                ", terrainType='" + terrainType + '\'' +
                '}';
    }
}
// Koniec, Tydzień 4, Wzorzec Flyweight, Zastosowanie 3
