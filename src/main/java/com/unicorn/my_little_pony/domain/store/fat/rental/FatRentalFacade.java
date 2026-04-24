package com.unicorn.my_little_pony.domain.store.fat.rental;

import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;
import com.unicorn.my_little_pony.integration.payment.providers.PaymentProvider;
import com.unicorn.my_little_pony.repositories.UnicornRepository;

import java.util.List;

// Tydzien 8, ISP, Zastosowanie 1
// Przyklad przed refaktoryzacja
// Klasa implementuje wszystkie metody "fat" interfejsu naraz.
public class FatRentalFacade implements UnicornRentalOperations {

    private final UnicornRepository unicornRepository;
    private final PaymentProvider paymentProvider;

    public FatRentalFacade(UnicornRepository unicornRepository, PaymentProvider paymentProvider) {
        this.unicornRepository = unicornRepository;
        this.paymentProvider = paymentProvider;
    }

    @Override
    public List<Unicorn> getAvailableUnicorns() {
        return unicornRepository.getAllUnicorn();
    }

    @Override
    public boolean processPayment(double amount) {
        return paymentProvider.process(amount);
    }

    @Override
    public void sendNotification(String customerName, String message) {
        System.out.println("[NOTIFY] " + customerName + ": " + message);
    }
}
// Koniec, Tydzien 8, ISP, Zastosowanie 1

