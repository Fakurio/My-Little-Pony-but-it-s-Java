package com.unicorn.my_little_pony.domain.models.service.composite;

//Tydzień 10, Interfejs funkcyjny do obliczania ceny
@FunctionalInterface
public interface PriceCalculator {
    double calculate(double basePrice);
}
//Koniec, Tydzień 10
