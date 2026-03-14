package com.unicorn.my_little_pony.domain.models.route;

// Tydzień 4, Wzorzec Flyweight, Zastosowanie 3
// Interfejs Flyweight - reprezentuje wspólne dane trasy przejażdżki, które mogą być współdzielone
public interface RideRouteFlyweight {
    String getDifficultyLevel();
    int getDefaultDurationMinutes();
    String getTerrainType();
    String describe();
}
// Koniec, Tydzień 4, Wzorzec Flyweight, Zastosowanie 3
