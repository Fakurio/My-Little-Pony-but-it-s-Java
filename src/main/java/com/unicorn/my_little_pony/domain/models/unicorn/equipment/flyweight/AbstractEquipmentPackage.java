package com.unicorn.my_little_pony.domain.models.unicorn.equipment.flyweight;

public abstract class AbstractEquipmentPackage implements EquipmentFlyweight {

    private final String packageName;
    private final String saddleType;
    private final String harnessType;
    private final String decorationStyle;
    private final String safetyLevel;

    protected AbstractEquipmentPackage(EquipmentPackageConfig equipmentPackageConfig) {
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

    protected String describePackage(String packageType) {
        return packageType + "{" +
                "packageName='" + packageName + '\'' +
                ", saddleType='" + saddleType + '\'' +
                ", harnessType='" + harnessType + '\'' +
                ", decorationStyle='" + decorationStyle + '\'' +
                ", safetyLevel='" + safetyLevel + '\'' +
                '}';
    }
}
