package com.unicorn.my_little_pony.domain.models.rental.returnTemplate;

// Tydzień 6, Wzorzec Template, Zastosowanie 2
// Implementacja procesu zwrotu jednorożca w przypadku spóźnionego zwrotu, definiująca konkretne kroki inspekcji i kalkulacji dodatkowych opłat
public class LateReturnProcess extends UnicornReturnTemplate {

    @Override
    public void inspectUnicornCondition() {
        System.out.println("A thorough inspection of the unicorn's condition was carried out, with special attention to signs of wear and tear due to late return.");
    }

    @Override
    public void calculateAdditionalFees() {
        System.out.println("Additional fees for late return will be calculated based on the number of days overdue and any potential damage caused by extended use.");
    }
}
// Koniec, Tydzień 6, Wzorzec Template, Zastosowanie 2