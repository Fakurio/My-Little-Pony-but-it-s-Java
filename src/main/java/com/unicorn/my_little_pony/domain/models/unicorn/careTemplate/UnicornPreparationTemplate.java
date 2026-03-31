package com.unicorn.my_little_pony.domain.models.unicorn.careTemplate;

// Tydzień 6, Wzorzec Template, Zastosowanie 3
// Definicja szablonu przygotowania jednorożca, który określa ogólny proces pielęgnacji, pozostawiając szczegóły implementacji poszczególnych kroków do konkretnych klas dziedziczących
public abstract class UnicornPreparationTemplate {

    public final void prepareUnicorn() {
        performInitialCheck();
        cleanCoat();
        polishHorn();
        decorateUnicorn();
        performFinalCheck();
    }

    private void performInitialCheck() {
        System.out.println("A preliminary assessment of the unicorn's condition was made.");
    }

    private void performFinalCheck() {
        System.out.println("Final check of unicorn readiness performed.");
    }

    public abstract void cleanCoat();

    public abstract void polishHorn();

    public abstract void decorateUnicorn();

}

// Koniec, Tydzień 6, Wzorzec Template, Zastosowanie 3