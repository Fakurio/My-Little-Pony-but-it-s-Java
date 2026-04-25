package com.unicorn.my_little_pony.domain.models.route;

import lombok.AllArgsConstructor;
import lombok.Getter;

// Klasa konfiguracyjna grupująca parametry trasy przejażdżki
// w celu ograniczenia liczby argumentów metody fabryki do jednego
@Getter
@AllArgsConstructor
public class RideRouteConfig {
    private final RideRouteType routeType;
    private final String routeName;
    private final String difficultyLevel;
    private final int defaultDurationMinutes;
    private final String terrainType;

    public String toKey() {
        return routeType.name() + "_" + routeName + "_" + difficultyLevel + "_"
                + defaultDurationMinutes + "_" + terrainType;
    }
}
