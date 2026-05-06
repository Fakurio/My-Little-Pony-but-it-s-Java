package com.unicorn.my_little_pony.domain.models.route;

import lombok.Getter;

// Klasa konfiguracyjna grupująca parametry trasy przejażdżki
// w celu ograniczenia liczby argumentów metody fabryki do jednego
@Getter
public class RideRouteConfig {
    private final RideRouteType routeType;
    private final String routeName;
    private final String difficultyLevel;
    private final int defaultDurationMinutes;
    private final String terrainType;

    private RideRouteConfig(Builder builder) {
        this.routeType = builder.routeType;
        this.routeName = builder.routeName;
        this.difficultyLevel = builder.difficultyLevel;
        this.defaultDurationMinutes = builder.defaultDurationMinutes;
        this.terrainType = builder.terrainType;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String toKey() {
        return routeType.name() + "_" + routeName + "_" + difficultyLevel + "_"
                + defaultDurationMinutes + "_" + terrainType;
    }

    public static class Builder {
        private RideRouteType routeType;
        private String routeName;
        private String difficultyLevel;
        private int defaultDurationMinutes;
        private String terrainType;

        public Builder routeType(RideRouteType routeType) {
            this.routeType = routeType;
            return this;
        }

        public Builder routeName(String routeName) {
            this.routeName = routeName;
            return this;
        }

        public Builder difficultyLevel(String difficultyLevel) {
            this.difficultyLevel = difficultyLevel;
            return this;
        }

        public Builder defaultDurationMinutes(int defaultDurationMinutes) {
            this.defaultDurationMinutes = defaultDurationMinutes;
            return this;
        }

        public Builder terrainType(String terrainType) {
            this.terrainType = terrainType;
            return this;
        }

        public RideRouteConfig build() {
            return new RideRouteConfig(this);
        }
    }
}
