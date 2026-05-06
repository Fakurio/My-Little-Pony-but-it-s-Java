package com.unicorn.my_little_pony.domain.models.unicorn.equipment.flyweight;

// Tydzień 4, Wzorzec Flyweight, Zastosowanie 2
// Konkretna klasa Flyweight - reprezentuje konkretny pakiet wyposażenia
public class BasicEquipmentPackage implements EquipmentFlyweight {

    private final String packageName;
    private final String saddleType;
    private final String harnessType;
    private final String decorationStyle;
    private final String safetyLevel;

    public BasicEquipmentPackage(EquipmentPackageConfig equipmentPackageConfig) {
        this.packageName = equipmentPackageConfig.getPackageName();
        this.saddleType = equipmentPackageConfig.getSaddleType();
        this.harnessType = equipmentPackageConfig.getHarnessType();
        this.decorationStyle = equipmentPackageConfig.getDecorationStyle();
        this.safetyLevel = equipmentPackageConfig.getSafetyLevel();
    }

    @Override
    public String getPackageName() {
        return packageName;
    }

    @Override
    public String getSaddleType() {
        return saddleType;
    }

    @Override
    public String getHarnessType() {
        return harnessType;
    }

    @Override
    public String getDecorationStyle() {
        return decorationStyle;
    }

    @Override
    public String getSafetyLevel() {
        return safetyLevel;
    }

    @Override
    public String describe() {
        return "BasicEquipmentPackage{" +
                "packageName='" + packageName + '\'' +
                ", saddleType='" + saddleType + '\'' +
                ", harnessType='" + harnessType + '\'' +
                ", decorationStyle='" + decorationStyle + '\'' +
                ", safetyLevel='" + safetyLevel + '\'' +
                '}';
    }
}
// Koniec, Tydzień 4, Wzorzec Flyweight, Zastosowanie 2
