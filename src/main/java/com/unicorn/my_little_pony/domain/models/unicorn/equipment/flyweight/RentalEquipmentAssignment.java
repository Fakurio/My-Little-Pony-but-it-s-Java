package com.unicorn.my_little_pony.domain.models.unicorn.equipment.flyweight;

// Tydzień 4, Wzorzec Flyweight, Zastosowanie 2
// Klasa kontekstowa - reprezentuje przypisanie pakietu wyposażenia do konkretnego wypożyczenia
public class RentalEquipmentAssignment {

    private final String assignmentId;
    private final String rentalId;
    private final EquipmentFlyweight equipmentFlyweight;

    private final String conditionStatus;
    private final boolean currentlyAssigned;

    private RentalEquipmentAssignment(Builder builder) {
        this.assignmentId = builder.assignmentId;
        this.rentalId = builder.rentalId;
        this.equipmentFlyweight = builder.equipmentFlyweight;
        this.conditionStatus = builder.conditionStatus;
        this.currentlyAssigned = builder.currentlyAssigned;
    }

    public static Builder builder() {
        return new Builder();
    }

    public EquipmentFlyweight getEquipmentFlyweight() {
        return equipmentFlyweight;
    }

    public String getDescription() {
        return "RentalEquipmentAssignment{" +
                "assignmentId='" + assignmentId + '\'' +
                ", rentalId='" + rentalId + '\'' +
                ", equipment=" + equipmentFlyweight.describe() +
                ", conditionStatus='" + conditionStatus + '\'' +
                ", currentlyAssigned=" + currentlyAssigned +
                '}';
    }

    public static class Builder {
        private String assignmentId;
        private String rentalId;
        private EquipmentFlyweight equipmentFlyweight;
        private String conditionStatus;
        private boolean currentlyAssigned;

        public Builder assignmentId(String assignmentId) {
            this.assignmentId = assignmentId;
            return this;
        }

        public Builder rentalId(String rentalId) {
            this.rentalId = rentalId;
            return this;
        }

        public Builder equipmentFlyweight(EquipmentFlyweight equipmentFlyweight) {
            this.equipmentFlyweight = equipmentFlyweight;
            return this;
        }

        public Builder conditionStatus(String conditionStatus) {
            this.conditionStatus = conditionStatus;
            return this;
        }

        public Builder currentlyAssigned(boolean currentlyAssigned) {
            this.currentlyAssigned = currentlyAssigned;
            return this;
        }

        public RentalEquipmentAssignment build() {
            return new RentalEquipmentAssignment(this);
        }
    }
}

// Koniec, Tydzień 4, Wzorzec Flyweight, Zastosowanie 2
