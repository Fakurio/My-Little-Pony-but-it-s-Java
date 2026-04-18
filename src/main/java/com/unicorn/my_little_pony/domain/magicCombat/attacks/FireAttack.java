package com.unicorn.my_little_pony.domain.magicCombat.attacks;

//Tydzień 8, DI, Zastosowanie 3
//Implementacja modułu niskopoziomowego zgodna z wymaganiami modułu wysokopoziomowego
public class FireAttack implements MagicAttack{

    @Override
    public void execute() {
        System.out.println("Attacking using fire magic");
    }
}
//Koniec, Tydzień 8, DI