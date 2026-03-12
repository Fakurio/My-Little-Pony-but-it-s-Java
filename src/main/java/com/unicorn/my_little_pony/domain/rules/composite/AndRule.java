package com.unicorn.my_little_pony.domain.rules.composite;

import java.util.ArrayList;
import java.util.List;
// Tydzień 3, Wzorzec Composite, Zastosowanie 3
// Kompozyt łączący wiele reguł walidacyjnych.

public class AndRule implements Rule {

    private final List<Rule> rules = new ArrayList<>();

    public void add(Rule rule) {
        rules.add(rule);
    }

    @Override
    public boolean check() {

        for (Rule rule : rules) {
            if (!rule.check()) {
                return false;
            }
        }

        return true;
    }
}
//Koniec, Tydzień 3, Wzorzec Composite, Zastosowanie 3