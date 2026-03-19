package com.unicorn.my_little_pony.domain.models.route;

// Tydzień 4, Wzorzec Flyweight, Zastosowanie 3
// Interfejs Flyweight - reprezentuje wspólne dane trasy przejażdżki, które mogą być współdzielone
public interface RideRouteFlyweight {
    String getRouteTypeLabel();
    String getRouteProfile();
    String describe();
}
// Koniec, Tydzień 4, Wzorzec Flyweight, Zastosowanie 3
