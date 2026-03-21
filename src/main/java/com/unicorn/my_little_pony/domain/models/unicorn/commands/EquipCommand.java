package com.unicorn.my_little_pony.domain.models.unicorn.commands;

import com.unicorn.my_little_pony.domain.models.unicorn.equipment.Equipment;
import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;

// Tydzień 5, Wzorzec Command, Zastosowanie 1
// Konkretne zadanie założenia ekwipunku na jednorożca
public class EquipCommand implements Command {
    private final Equipment equipment;
    private final Equipment previousEquipment;
    private final Unicorn unicorn;

    public EquipCommand(Unicorn unicorn, Equipment equipment) {
        this.equipment = equipment;
        this.previousEquipment = unicorn.getEquipment();
        this.unicorn = unicorn;
    }

    @Override
    public void execute() {
        unicorn.setEquipment(this.equipment);
        System.out.println("Equipped: " + equipment.getDescription());
    }

    @Override
    public void undo() {
        unicorn.setEquipment(this.previousEquipment);
        System.out.println("Undo: Restored previous equipment.");
    }
}
// Koniec, Tydzień 5, Wzorzec Command