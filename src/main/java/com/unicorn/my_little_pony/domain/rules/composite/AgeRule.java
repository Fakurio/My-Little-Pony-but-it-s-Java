package com.unicorn.my_little_pony.domain.rules.composite;

// Tydzień 3, Wzorzec Composite, Zastosowanie 3
// Pojedyncza reguła walidacji wynajmu
public class AgeRule implements Rule {
    private static final int MINIMUM_RENTAL_AGE = 18;

    private final int age;

    public AgeRule(int age) {
        this.age = age;
    }

    @Override
    public boolean check() {
        return age >= MINIMUM_RENTAL_AGE;
    }
}
//Koniec, Tydzień 3, Wzorzec Composite, Zastosowanie 3
