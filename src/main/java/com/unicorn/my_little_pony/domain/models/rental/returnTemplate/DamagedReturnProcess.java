package com.unicorn.my_little_pony.domain.models.rental.returnTemplate;

// Tydzień 6, Wzorzec Template, Zastosowanie 2
// Implementacja procesu zwrotu jednorożca w przypadku wykrycia uszkodzeń, definiująca konkretne kroki inspekcji i kalkulacji dodatkowych opłat
public class DamagedReturnProcess extends UnicornReturnTemplate {

    @Override
    public void inspectUnicornCondition() {
        System.out.println("Horn damage and dirt on the magic harness were detected.");
    }

    @Override
    public void calculateAdditionalFees() {
        System.out.println("A service fee and reconditioning cost were charged.");
    }
}
// Koniec, Tydzień 6, Wzorzec Template, Zastosowanie 2