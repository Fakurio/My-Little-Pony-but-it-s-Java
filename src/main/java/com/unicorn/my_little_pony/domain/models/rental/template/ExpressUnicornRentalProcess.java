package com.unicorn.my_little_pony.domain.models.rental.template;

// Tydzień 6, Wzorzec Template, Zastosowanie 1
// Implementacja procesu ekspresowego wypożyczenia jednorożca, definiująca specyficzne kroki wyboru, kalkulacji ceny i
// wydania jednorożca dla klientów potrzebujących szybkiej obsługi
public class ExpressUnicornRentalProcess extends UnicornRentalProcess {

    @Override
    public void chooseUnicorn() {
        System.out.println("Quickly select the first available unicorn that meets your requirements.");
    }

    @Override
    public void calculatePrice() {
        System.out.println("Express price calculated with a priority service surcharge.");
    }

    @Override
    public void releaseUnicorn() {
        System.out.println("The unicorn was released immediately in express mode.");
    }

}
// Koniec, Tydzień 6, Wzorzec Template, Zastosowanie 1
