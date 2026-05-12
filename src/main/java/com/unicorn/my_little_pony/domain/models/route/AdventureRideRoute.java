package com.unicorn.my_little_pony.domain.models.route;

// Tydzień 4, Wzorzec Flyweight, Zastosowanie 3
// Konkretna klasa Flyweight - reprezentuje konkretny typ trasy przejażdżki, który może być współdzielony
public class AdventureRideRoute extends AbstractRideRoute {

    public AdventureRideRoute(RideRouteConfig routeConfig) {
        super(routeConfig);
    }

    @Override
    public String describe() {
        return describeRoute("AdventureRideRoute");
    }
}
// Koniec, Tydzień 4, Wzorzec Flyweight, Zastosowanie 3
