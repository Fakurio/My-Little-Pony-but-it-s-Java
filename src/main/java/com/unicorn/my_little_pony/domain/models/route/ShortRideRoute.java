package com.unicorn.my_little_pony.domain.models.route;

// Tydzień 4, Wzorzec Flyweight, Zastosowanie 3
// Konkretna klasa Flyweight - reprezentuje konkretny typ trasy przejażdżki, który może być współdzielony
public class ShortRideRoute extends AbstractRideRoute {

    public ShortRideRoute(RideRouteConfig routeConfig) {
        super(routeConfig);
    }

    @Override
    public String describe() {
        return describeRoute("ShortRideRoute");
    }
}
// Koniec, Tydzień 4, Wzorzec Flyweight, Zastosowanie 3
