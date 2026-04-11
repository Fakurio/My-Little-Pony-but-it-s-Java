package com.unicorn.my_little_pony.domain.models.rental.returnTemplate;

// Tydzień 6, Wzorzec Template, Zastosowanie 2
// Szablon procesu zwrotu jednorożca, definiujący ogólny przebieg procesu zwrotu, pozostawiający szczegóły do
// implementacji w konkretnych klasach zwrotu, takich jak standardowy zwrot, ekspresowy zwrot czy zwrot premium,
// które mogą mieć różne wymagania dotyczące inspekcji, opłat dodatkowych i aktualizacji dostępności jednorożców
public abstract class UnicornReturnTemplate {

    public final void processReturn() {
        registerReturn();
        inspectUnicornCondition();
        calculateAdditionalFees();
        updateAvailability();
        closeReturn();
    }

    private void closeReturn() {
        System.out.println("Return closed.");
    }

    private void registerReturn() {
        System.out.println("Return registered in the system, starting the return process.");
    }

    private void updateAvailability() {
        System.out.println("Unicorn availability updated in the system, ready for the next rental.");
    }

    public abstract void inspectUnicornCondition();

    public abstract void calculateAdditionalFees();

}
// Koniec, Tydzień 6, Wzorzec Template, Zastosowanie 2