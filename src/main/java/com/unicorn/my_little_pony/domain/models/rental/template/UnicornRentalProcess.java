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

    // Można nadpisać w klasie pochodnej, aby dostosować (private na protected)
    protected void validateCustomer() {
        System.out.println("Verifying customer eligibility and rental history...");
    }

    // Można nadpisać w klasie pochodnej, aby dostosować (private na protected)
    protected void prepareAgreement() {
        System.out.println("Preparing rental agreement and processing payment...");
    }

    // Można nadpisać w klasie pochodnej, aby dostosować (private na protected)
    protected boolean shouldSendNotification() {
        return true;
    }

    // Można nadpisać w klasie pochodnej, aby dostosować (private na protected)
    protected void sendNotification() {
        System.out.println("Notifying customer about rental details and pickup instructions...");
    }
    // public na protected
    protected abstract void chooseUnicorn();
    protected abstract void calculatePrice();
    protected abstract void releaseUnicorn();

}
// Koniec, Tydzień 6, Wzorzec Template, Zastosowanie 1
// Koniec, Tydzień 7, Zasada otwarte-zamknięte, Zastosowanie 2 (przez abstrakcję)