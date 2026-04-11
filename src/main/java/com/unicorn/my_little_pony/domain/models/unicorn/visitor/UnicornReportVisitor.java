package com.unicorn.my_little_pony.domain.models.unicorn.visitor;

import com.unicorn.my_little_pony.domain.models.unicorn.types.FireUnicorn;
import com.unicorn.my_little_pony.domain.models.unicorn.types.WaterUnicorn;

// Tydzień 6, Wzorzec Visitor, Zastosowanie 1
// Raport przechowujący dane o mocy magicznej jednorożców
public class UnicornReportVisitor implements UnicornVisitor {

    @Override
    public String visit(FireUnicorn u) {
        return "Fire Unicorn: " + u.getName() +
                ", totalPower=" + u.getTotalPower() +
                ", category=" + u.getPowerLevelCategory();
    }

    @Override
    public String visit(WaterUnicorn u) {
        return "Water Unicorn: " + u.getName() +
                ", totalPower=" + u.getTotalPower() +
                ", category=" + u.getPowerLevelCategory();
    }
}
//Koniec tydzień 6, wzorzec visitor