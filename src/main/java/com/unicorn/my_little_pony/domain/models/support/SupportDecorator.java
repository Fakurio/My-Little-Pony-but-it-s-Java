package com.unicorn.my_little_pony.domain.models.support;

// Tydzień 3, Wzorzec Decorator, Zastosowanie 3
// Abstrakcyjna klasa dekoratora - przechowuje referencję do komponentu wsparcia

public abstract class SupportDecorator implements CustomerSupport {
    protected CustomerSupport support;

    public SupportDecorator(CustomerSupport support) {
        this.support = support;
    }

    @Override
    public double getCost() {
        return support.getCost();
    }

    @Override
    public String getDescription() {
        return support.getDescription();
    }
}
// Koniec, Tydzień 3, Wzorzec Decorator, Zastosowanie 3
