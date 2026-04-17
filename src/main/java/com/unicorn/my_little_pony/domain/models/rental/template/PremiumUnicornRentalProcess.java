package com.unicorn.my_little_pony.domain.models.rental.template;

// Tydzień 6, Wzorzec Template, Zastosowanie 1
// Implementacja procesu wypożyczenia premium jednorożca, definiująca specyficzne kroki wyboru, kalkulacji ceny i wydania jednorożca dla klientów VIP
// Tydzień 7, Zasada otwarte-zamknięte, Zastosowanie 2 (przez abstrakcję)
// Klasa PremiumUnicornRentalProcess jest rozszerzeniem szablonu UnicornRentalProcess
public class PremiumUnicornRentalProcess extends UnicornRentalProcess {

    @Override
    protected void chooseUnicorn() {
        System.out.println("A rare premium unicorn with a high power level was selected.");
    }

    @Override
    protected void calculatePrice() {
        System.out.println("Premium price calculated with additional VIP fees.");
    }

    @Override
    protected void releaseUnicorn() {
        System.out.println("The premium unicorn was prepared and delivered with a caretaker.");
    }
}
// Koniec, Tydzień 6, Wzorzec Template, Zastosowanie 1
// Koniec, Tydzień 7, Zasada otwarte-zamknięte, Zastosowanie 2 (przez abstrakcję)