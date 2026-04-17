package com.unicorn.my_little_pony.domain.models.rental.template;

// Tydzień 6, Wzorzec Template, Zastosowanie 1
// Implementacja procesu ekspresowego wypożyczenia jednorożca, definiująca specyficzne kroki wyboru, kalkulacji ceny i
// wydania jednorożca dla klientów potrzebujących szybkiej obsługi
// Tydzień 7, Zasada otwarte-zamknięte, Zastosowanie 2 (przez abstrakcję)
// Klasa ExpressUnicornRentalProcess jest rozszerzeniem szablonu UnicornRentalProcess
public class ExpressUnicornRentalProcess extends UnicornRentalProcess {

    @Override
    protected void chooseUnicorn() {
        System.out.println("Quickly select the first available unicorn that meets your requirements.");
    }

    @Override
    protected void calculatePrice() {
        System.out.println("Express price calculated with a priority service surcharge.");
    }

    @Override
    protected void releaseUnicorn() {
        System.out.println("The unicorn was released immediately in express mode.");
    }

    @Override
    protected void prepareAgreement() {
        System.out.println("Preparing a simplified express agreement with priority payment processing...");
    }

}
// Koniec, Tydzień 6, Wzorzec Template, Zastosowanie 1
// Koniec, Tydzień 7, Zasada otwarte-zamknięte, Zastosowanie 2 (przez abstrakcję)