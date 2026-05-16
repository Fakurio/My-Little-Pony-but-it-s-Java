package com.unicorn.my_little_pony.domain.models.route;

public abstract class AbstractRideRoute implements RideRouteFlyweight {

    private final String routeName;
    private final String difficultyLevel;
    private final int defaultDurationMinutes;
    private final String terrainType;

    protected AbstractRideRoute(RideRouteConfig routeConfig) {
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

    protected String describeRoute(String routeType) {
        return routeType + "{" +
                "routeName='" + routeName + '\'' +
                ", difficultyLevel='" + difficultyLevel + '\'' +
                ", defaultDurationMinutes=" + defaultDurationMinutes +
                ", terrainType='" + terrainType + '\'' +
                '}';
    }
}
