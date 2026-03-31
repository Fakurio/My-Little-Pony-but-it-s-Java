package com.unicorn.my_little_pony.domain.models.rental.template;

// Tydzień 6, Wzorzec Template, Zastosowanie 1
// Implementacja standardowego procesu wypożyczenia jednorożca, definiująca konkretne kroki wyboru, kalkulacji ceny i wydania jednorożca
public class StandardUnicornRentalProcess extends UnicornRentalProcess {

    @Override
    public void chooseUnicorn() {
        System.out.println("A standard unicorn was selected from the available stable.");
    }

    @Override
    public void calculatePrice() {
        System.out.println("Standard rental price calculated.");
    }

    @Override
    public void releaseUnicorn() {
        System.out.println("The unicorn was handed over to the customer at the pickup point.");
    }
}
// Koniec, Tydzień 6, Wzorzec Template, Zastosowanie 1