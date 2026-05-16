package com.unicorn.my_little_pony.domain.models.route;
// Tydzień 4, Wzorzec Flyweight, Zastosowanie 3
// Klasa RidePlan - reprezentuje plan przejażdżki, zawiera dane specyficzne dla
// ktory konkretnej przejażdżki oraz odniesienie do wspólnego obiektu trasy (Flyweight)
public class RidePlan {

    private final String rideId;
    private final String unicornId;
    private final RideRouteFlyweight routeFlyweight;

    private final String rideDate;
    private final String weather;
    private final int participantCount;

    private RidePlan(Builder builder) {
        this.rideId = builder.rideId;
        this.unicornId = builder.unicornId;
        this.routeFlyweight = builder.routeFlyweight;
        this.rideDate = builder.rideDate;
        this.weather = builder.weather;
        this.participantCount = builder.participantCount;
    }

    public static Builder builder() {
        return new Builder();
    }

    public RideRouteFlyweight getRouteFlyweight() {
        return routeFlyweight;
    }

    public String getDescription() {
        return "RidePlan{" +
                "rideId='" + rideId + '\'' +
                ", unicornId='" + unicornId + '\'' +
                ", route=" + routeFlyweight.describe() +
                ", rideDate='" + rideDate + '\'' +
                ", weather='" + weather + '\'' +
                ", participantCount=" + participantCount +
                '}';
    }

    public static class Builder {
        private String rideId;
        private String unicornId;
        private RideRouteFlyweight routeFlyweight;
        private String rideDate;
        private String weather;
        private int participantCount;

        public Builder rideId(String rideId) {
            this.rideId = rideId;
            return this;
        }

        public Builder unicornId(String unicornId) {
            this.unicornId = unicornId;
            return this;
        }

        public Builder routeFlyweight(RideRouteFlyweight routeFlyweight) {
            this.routeFlyweight = routeFlyweight;
            return this;
        }

        public Builder rideDate(String rideDate) {
            this.rideDate = rideDate;
            return this;
        }

        public Builder weather(String weather) {
            this.weather = weather;
            return this;
        }

        public Builder participantCount(int participantCount) {
            this.participantCount = participantCount;
            return this;
        }

        public RidePlan build() {
            return new RidePlan(this);
        }
    }
}
// Koniec, Tydzień 4, Wzorzec Flyweight, Zastosowanie 3
