package com.unicorn.my_little_pony.domain.rules.composite;

// Tydzień 3, Wzorzec Composite, Zastosowanie 3
// Pojedyncza reguła walidacji wynajmu
public class AgeRule implements Rule {

    private final int age;

    public AgeRule(int age) {
        this.age = age;
    }

    @Override
    public boolean check() {
        return age >= 18;
    }
}
//Koniec, Tydzień 3, Wzorzec Composite, Zastosowanie 3