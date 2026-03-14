package com.unicorn.my_little_pony.domain.models.unicorn.equipment.flyweight;

// Tydzień 4, Wzorzec Flyweight, Zastosowanie 2
// Klasa kontekstowa - reprezentuje przypisanie pakietu wyposażenia do konkretnego wypożyczenia
public class RentalEquipmentAssignment {

    private final String assignmentId;
    private final String rentalId;
    private final EquipmentFlyweight equipmentFlyweight;

    private String conditionStatus;
    private boolean currentlyAssigned;

    public RentalEquipmentAssignment(
            String assignmentId,
            String rentalId,
            EquipmentFlyweight equipmentFlyweight,
            String conditionStatus,
            boolean currentlyAssigned) {
        this.assignmentId = assignmentId;
        this.rentalId = rentalId;
        this.equipmentFlyweight = equipmentFlyweight;
        this.conditionStatus = conditionStatus;
        this.currentlyAssigned = currentlyAssigned;
    }

    public EquipmentFlyweight getEquipmentFlyweight() {
        return equipmentFlyweight;
    }

    public String getInfo() {
        return "RentalEquipmentAssignment{" +
                "assignmentId='" + assignmentId + '\'' +
                ", rentalId='" + rentalId + '\'' +
                ", equipment=" + equipmentFlyweight.describe() +
                ", conditionStatus='" + conditionStatus + '\'' +
                ", currentlyAssigned=" + currentlyAssigned +
                '}';
    }
}

// Koniec, Tydzień 4, Wzorzec Flyweight, Zastosowanie 2
