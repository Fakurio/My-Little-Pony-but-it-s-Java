package com.unicorn.my_little_pony.domain.magicCombat.attacks;

//Tydzień 8, DI, Zastosowanie 3
//Implementacja modułu niskopoziomowego zgodna z wymaganiami modułu wysokopoziomowego
public class WaterAttack implements MagicAttack {

    @Override
    public void execute() {
        System.out.println("Attacking using water magic");
    }
}
//Koniec, Tydzień 8, DI