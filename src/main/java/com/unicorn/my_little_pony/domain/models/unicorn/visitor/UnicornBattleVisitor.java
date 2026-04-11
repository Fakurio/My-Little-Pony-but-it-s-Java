package com.unicorn.my_little_pony.domain.models.unicorn.visitor;

// Tydzień 6, Wzorzec Visitor, Zastosowanie 1
// Wizytator generujący raport JSON z mocy magicznej jednorożców

import com.unicorn.my_little_pony.domain.models.unicorn.types.FireUnicorn;
import com.unicorn.my_little_pony.domain.models.unicorn.types.WaterUnicorn;

public class UnicornBattleVisitor implements UnicornVisitor {

    @Override
    public String visit(FireUnicorn u) {
        if (u.getTotalPower() > 100) {
            return u.getName() + " is ready for EPIC battle 🔥";
        }
        return u.getName() + " needs more training";
    }

    @Override
    public String visit(WaterUnicorn u) {
        if (u.getTotalPower() > 100) {
            return u.getName() + " dominates water arenas 🌊";
        }
        return u.getName() + " is still weak";
    }
}
//Koniec tydzień 6, wzorzec visitor