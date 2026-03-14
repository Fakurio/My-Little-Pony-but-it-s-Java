package com.unicorn.my_little_pony.domain.models.route;
// Tydzień 4, Wzorzec Flyweight, Zastosowanie 3
// Klasa RidePlan - reprezentuje plan przejażdżki, zawiera dane specyficzne dla
// konkretnej przejażdżki oraz odniesienie do wspólnego obiektu trasy (Flyweight)
public class RidePlan {

    private final String rideId;
    private final String unicornId;
    private final RideRouteFlyweight routeFlyweight;

    private String rideDate;
    private String weather;
    private int participantCount;

    public RidePlan(
            String rideId,
            String unicornId,
            RideRouteFlyweight routeFlyweight,
            String rideDate,
            String weather,
            int participantCount) {
        this.rideId = rideId;
        this.unicornId = unicornId;
        this.routeFlyweight = routeFlyweight;
        this.rideDate = rideDate;
        this.weather = weather;
        this.participantCount = participantCount;
    }

    public RideRouteFlyweight getRouteFlyweight() {
        return routeFlyweight;
    }

    public String getInfo() {
        return "RidePlan{" +
                "rideId='" + rideId + '\'' +
                ", unicornId='" + unicornId + '\'' +
                ", route=" + routeFlyweight.describe() +
                ", rideDate='" + rideDate + '\'' +
                ", weather='" + weather + '\'' +
                ", participantCount=" + participantCount +
                '}';
    }
}
// Koniec, Tydzień 4, Wzorzec Flyweight, Zastosowanie 3
