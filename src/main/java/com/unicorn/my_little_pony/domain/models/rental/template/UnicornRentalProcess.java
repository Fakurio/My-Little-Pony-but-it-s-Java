package com.unicorn.my_little_pony.domain.models.rental.template;

//Tydzień 6, Wzorzec Template, Zastosowanie 1
// Szablon procesu wypożyczenia jednorożca, definiujący ogólny przebieg procesu, pozostawiający szczegóły do implementacji
// Tydzień 7, Zasada otwarte-zamknięte, Zastosowanie 2 (przez abstrakcję)
// Klasa jest otwarta na rozszerzenia (można tworzyć różne procesy wypożyczenia jednorożca), ale zamknięta na modyfikacje
//  (nie trzeba zmieniać istniejącego kodu, aby dodać nowe procesy).
public abstract class UnicornRentalProcess {

    public final void processRental() {
        validateCustomer();
        chooseUnicorn();
        calculatePrice();
        prepareAgreement();
        releaseUnicorn();

        if (shouldSendNotification()) {
            sendNotification();
        }
    }

    private void validateCustomer() {
        System.out.println("Verifying customer eligibility and rental history...");
    }

    private void prepareAgreement() {
        System.out.println("Preparing rental agreement and processing payment...");
    }

    private boolean shouldSendNotification() {
        return true;
    }

    private void sendNotification() {
        System.out.println("Notifying customer about rental details and pickup instructions...");
    }

    public abstract void chooseUnicorn();
    public abstract void calculatePrice();
    public abstract void releaseUnicorn();

}
// Koniec, Tydzień 6, Wzorzec Template, Zastosowanie 1
// Koniec, Tydzień 7, Zasada otwarte-zamknięte, Zastosowanie 2 (przez abstrakcję)