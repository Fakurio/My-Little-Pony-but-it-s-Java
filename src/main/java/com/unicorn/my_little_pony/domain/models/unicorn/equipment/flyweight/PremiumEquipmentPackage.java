package com.unicorn.my_little_pony.domain.models.unicorn.equipment.flyweight;

// Tydzień 4, Wzorzec Flyweight, Zastosowanie 2
// Konkretna klasa Flyweight - reprezentuje konkretny pakiet wyposażenia
public class PremiumEquipmentPackage implements EquipmentFlyweight {

    private final String packageName;
    private final String saddleType;
    private final String harnessType;
    private final String decorationStyle;
    private final String safetyLevel;

    public PremiumEquipmentPackage(
            String packageName,
            String saddleType,
            String harnessType,
            String decorationStyle,
            String safetyLevel) {
        this.packageName = packageName;
        this.saddleType = saddleType;
        this.harnessType = harnessType;
        this.decorationStyle = decorationStyle;
        this.safetyLevel = safetyLevel;
    }

    @Override
    public String getPackageTier() {
        return "PREMIUM";
    }

    public String getSaddleType() {
        return saddleType;
    }

    public String getHarnessType() {
        return harnessType;
    }

    public String getDecorationStyle() {
        return decorationStyle;
    }

    public String getSafetyLevel() {
        return safetyLevel;
    }

    @Override
    public String getEquipment() {
        return "saddle=" + saddleType
                + ", harness=" + harnessType
                + ", decoration=" + decorationStyle
                + ", safety=" + safetyLevel;
    }

    @Override
    public String describe() {
        return "PremiumEquipmentPackage{" +
                "packageTier='" + getPackageTier() + '\'' +
                ", packageName='" + packageName + '\'' +
                ", saddleType='" + saddleType + '\'' +
                ", harnessType='" + harnessType + '\'' +
                ", decorationStyle='" + decorationStyle + '\'' +
                ", safetyLevel='" + safetyLevel + '\'' +
                '}';
    }
}
// Koniec, Tydzień 4, Wzorzec Flyweight, Zastosowanie 2
