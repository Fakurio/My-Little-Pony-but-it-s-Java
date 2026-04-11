package com.unicorn.my_little_pony.domain.models.unicorn.careTemplate;

// Tydzień 6, Wzorzec Template, Zastosowanie 3
// Implementacja procesu przygotowania królewskiego jednorożca, definiująca luksusowe metody pielęgnacji i dekoracji, które odzwierciedlają jego majestatyczny status
public class RoyalUnicornPreparation extends UnicornPreparationTemplate {

    @Override
    public void cleanCoat() {
        System.out.println("A luxurious cleaning of the coat was performed with a royal brush.");
    }

    @Override
    public void polishHorn() {
        System.out.println("The horn has been coated with a premium protective gloss.");
    }

    @Override
    public void decorateUnicorn() {
        System.out.println("Added gold ceremonial harness.");
    }

}

// Koniec, Tydzień 6, Wzorzec Template, Zastosowanie 3