package com.unicorn.my_little_pony.domain.decorators.support;

// Tydzień 4, Wzorzec Decorator, Zastosowanie 3
// Konkretny dekorator - priorytetowe wsparcie

public class PrioritySupport extends SupportDecorator {
    private static final double PRIORITY_SUPPORT_COST = 40.0;

    public PrioritySupport(CustomerSupport support) {
        super(support);
    }

    @Override
    public double getCost() {
        return super.getCost() + PRIORITY_SUPPORT_COST;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " -> Priority support (8am-8pm)";
    }
}
// Koniec, Tydzień 4, Wzorzec Decorator, Zastosowanie 3
