package com.unicorn.my_little_pony.domain.models.unicorn.equipment.flyweight;

// Tydzień 4, Wzorzec Flyweight, Zastosowanie 2
// Konkretna klasa Flyweight - reprezentuje konkretny pakiet wyposażenia
public class BasicEquipmentPackage implements EquipmentFlyweight {

    private final String packageName;
    private final String saddleType;
    private final String harnessType;

    public BasicEquipmentPackage(
            String packageName,
            String saddleType,
            String harnessType) {
        this.packageName = packageName;
        this.saddleType = saddleType;
        this.harnessType = harnessType;
    }

    @Override
    public String getPackageTier() {
        return "BASIC";
    }

    public String getSaddleType() {
        return saddleType;
    }

    public String getHarnessType() {
        return harnessType;
    }

    @Override
    public String getEquipment() {
        return "saddle=" + saddleType + ", harness=" + harnessType;
    }

    @Override
    public String describe() {
        return "BasicEquipmentPackage{" +
                "packageTier='" + getPackageTier() + '\'' +
                ", packageName='" + packageName + '\'' +
                ", saddleType='" + saddleType + '\'' +
                ", harnessType='" + harnessType + '\'' +
                '}';
    }
}
// Koniec, Tydzień 4, Wzorzec Flyweight, Zastosowanie 2
