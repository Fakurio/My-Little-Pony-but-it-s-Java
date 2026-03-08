package com.unicorn.my_little_pony.domain.decorators.support;

// Tydzień 4, Wzorzec Decorator, Zastosowanie 3
// Konkretny dekorator - standardowe wsparcie

public class StandardSupport extends SupportDecorator {
    private static final double STANDARD_SUPPORT_COST = 20.0;

    public StandardSupport(CustomerSupport support) {
        super(support);
    }

    @Override
    public double getCost() {
        return super.getCost() + STANDARD_SUPPORT_COST;
    }

    @Override
    public String getDescription() {
        String baseDescription = super.getDescription();
        if (baseDescription.equals("No support")) {
            return "Standard support (9am-5pm)";
        }
        return baseDescription + " -> Standard support (9am-5pm)";
    }
}
// Koniec, Tydzień 4, Wzorzec Decorator, Zastosowanie 3
