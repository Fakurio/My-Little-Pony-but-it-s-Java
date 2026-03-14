package com.unicorn.my_little_pony.domain.models.unicorn.equipment.flyweight;

// Tydzień 4, Wzorzec Flyweight, Zastosowanie 2
// Interfejs Flyweight - reprezentuje wspólne dane dla pakietów wyposażenia
public interface EquipmentFlyweight {
    String getPackageName();
    String getSaddleType();
    String getHarnessType();
    String getDecorationStyle();
    String getSafetyLevel();
    String describe();
}
// Koniec, Tydzień 4, Wzorzec Flyweight, Zastosowanie 2
