package com.unicorn.my_little_pony.domain.models.route;

// Tydzień 4, Wzorzec Flyweight, Zastosowanie 3
// Konkretna klasa Flyweight - reprezentuje konkretny typ trasy przejażdżki, który może być współdzielony
public class AdventureRideRoute implements RideRouteFlyweight {

    private final String routeName;
    private final int defaultDurationMinutes;
    private final String terrainType;
    private final String riskLevel;
    private final boolean requiresGuide;

    public AdventureRideRoute(
            String routeName,
            int defaultDurationMinutes,
            String terrainType,
            String riskLevel,
            boolean requiresGuide) {
        this.routeName = routeName;
        this.defaultDurationMinutes = defaultDurationMinutes;
        this.terrainType = terrainType;
        this.riskLevel = riskLevel;
        this.requiresGuide = requiresGuide;
    }

    @Override
    public String getRouteTypeLabel() {
        return "ADVENTURE";
    }

    public int getDefaultDurationMinutes() {
        return defaultDurationMinutes;
    }

    public String getTerrainType() {
        return terrainType;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public boolean isGuideRequired() {
        return requiresGuide;
    }

    @Override
    public String getRouteProfile() {
        return "duration=" + defaultDurationMinutes
                + " min, terrain=" + terrainType
                + ", risk=" + riskLevel
                + ", guideRequired=" + requiresGuide;
    }

    @Override
    public String describe() {
        return "AdventureRideRoute{" +
                "routeType='" + getRouteTypeLabel() + '\'' +
                ", routeName='" + routeName + '\'' +
                ", defaultDurationMinutes=" + defaultDurationMinutes +
                ", terrainType='" + terrainType + '\'' +
                ", riskLevel='" + riskLevel + '\'' +
                ", requiresGuide=" + requiresGuide +
                '}';
    }
}
// Koniec, Tydzień 4, Wzorzec Flyweight, Zastosowanie 3
