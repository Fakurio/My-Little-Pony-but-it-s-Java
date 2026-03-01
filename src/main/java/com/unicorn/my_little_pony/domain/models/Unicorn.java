package com.unicorn.my_little_pony.domain.models;

import com.unicorn.my_little_pony.enums.UnicornStatus;

public class Unicorn {
    private final String id;
    private String name;
    private String color;
    private int powerLevel;
    private UnicornStatus status;

    public Unicorn(String id, String name, String color, int powerLevel) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.powerLevel = powerLevel;
        this.status = UnicornStatus.AVAILABLE;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getColor() { return color; }
    public int getPowerLevel() { return powerLevel; }
    public UnicornStatus getStatus() { return status; }

    public void setStatus(UnicornStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Unicorn{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", powerLevel=" + powerLevel +
                ", status=" + status +
                '}';
    }
}
