package com.unicorn.my_little_pony.domain.store.isp.rental_lifecycle;

import com.unicorn.my_little_pony.domain.exceptions.RentalRecordNotFoundException;

// Tydzien 8, ISP, Zastosowanie 3
// Implementacja segregated interface - finansowanie
public class RentalFinanceImpl implements RentalFinance {

    private static final double REFUND_RATE = 0.5;

    private final java.util.Map<String, Double> payments = new java.util.HashMap<>();

    @Override
    public void processPayment(String rentalId, double amount) {
        payments.put(rentalId, amount);
        System.out.println("[ISP] Payment processed: " + amount + " PLN");
    }

    @Override
    public double getRefundAmount(String rentalId) {
        Double paid = payments.get(rentalId);
        if (paid == null) {
            throw new RentalRecordNotFoundException(rentalId);
        }
        return paid * REFUND_RATE;
    }
}
// Koniec, Tydzien 8, ISP, Zastosowanie 3
