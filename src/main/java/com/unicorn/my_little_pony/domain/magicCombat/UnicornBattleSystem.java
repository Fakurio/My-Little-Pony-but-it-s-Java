package com.unicorn.my_little_pony.domain.magicCombat;

import com.unicorn.my_little_pony.domain.magicCombat.attacks.MagicAttack;

//Tydzień 8, DI, Zastosowanie 3
//Moduł wysokopoziomowy wywołuje atak magiczny poprzez interfejs nie znając rodzaju użytej magii
public class UnicornBattleSystem {
    public void castSpell(MagicAttack attack) {
        attack.execute();
    }
}
//Koniec, Tydzień 8, DI