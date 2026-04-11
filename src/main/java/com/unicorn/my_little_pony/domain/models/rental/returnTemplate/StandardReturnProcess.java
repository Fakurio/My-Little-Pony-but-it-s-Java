package com.unicorn.my_little_pony.domain.models.rental.returnTemplate;

// Tydzień 6, Wzorzec Template, Zastosowanie 2
// Implementacja standardowego procesu zwrotu jednorożca, definiująca konkretne kroki inspekcji i kalkulacji dodatkowych opłat
public class StandardReturnProcess extends UnicornReturnTemplate {

    @Override
    public void inspectUnicornCondition() {
        System.out.println("A standard inspection of the unicorn's condition was carried out, checking basic components and functions.");
    }

    @Override
    public void calculateAdditionalFees() {
        System.out.println("Additional charges will be applied for any damage or exceeding the rental period.");
    }
}
// Koniec, Tydzień 6, Wzorzec Template, Zastosowanie 2