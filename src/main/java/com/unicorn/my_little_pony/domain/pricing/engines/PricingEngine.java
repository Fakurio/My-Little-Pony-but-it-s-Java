package com.unicorn.my_little_pony.domain.pricing.engines;

// Tydzień 3, Wzorzec Bridge, Zastosowanie 1
// Interfejs dla wszystkich klas implementujących dany sposób naliczania ceny
public interface PricingEngine {
    double calculateBasePrice(int timeUnits);
}
// Koniec, Tydzień 3, Wzorzec Bridge, Zastosowanie 1