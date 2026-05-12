package com.unicorn.my_little_pony.domain.models.unicorn.equipment.flyweight;

// Tydzień 4, Wzorzec Flyweight, Zastosowanie 2
// Konkretna klasa Flyweight - reprezentuje konkretny pakiet wyposażenia
public class BasicEquipmentPackage extends AbstractEquipmentPackage {

    public BasicEquipmentPackage(EquipmentPackageConfig equipmentPackageConfig) {
        super(equipmentPackageConfig);
    }

    @Override
    public String describe() {
        return describePackage("BasicEquipmentPackage");
    }
}
// Koniec, Tydzień 4, Wzorzec Flyweight, Zastosowanie 2
