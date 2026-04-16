package com.unicorn.my_little_pony.domain.models.rental.template;

// Tydzień 6, Wzorzec Template, Zastosowanie 1
// Implementacja standardowego procesu wypożyczenia jednorożca, definiująca konkretne kroki wyboru, kalkulacji ceny i wydania jednorożca
// Tydzień 7, Zasada otwarte-zamknięte, Zastosowanie 2 (przez abstrakcję)
// Klasa StandardUnicornRentalProcess jest rozszerzeniem szablonu UnicornRentalProcess
public class StandardUnicornRentalProcess extends UnicornRentalProcess {

    @Override
    protected void chooseUnicorn() {
        System.out.println("A standard unicorn was selected from the available stable.");
    }

    @Override
    protected void calculatePrice() {
        System.out.println("Standard rental price calculated.");
    }

    @Override
    protected void releaseUnicorn() {
        System.out.println("The unicorn was handed over to the customer at the pickup point.");
    }
}
// Koniec, Tydzień 6, Wzorzec Template, Zastosowanie 1
// Koniec, Tydzień 7, Zasada otwarte-zamknięte, Zastosowanie 2 (przez abstrakcję)