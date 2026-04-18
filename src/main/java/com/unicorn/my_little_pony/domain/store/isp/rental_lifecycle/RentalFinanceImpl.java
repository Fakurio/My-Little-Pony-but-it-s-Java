package com.unicorn.my_little_pony.domain.store.isp.rental_lifecycle;

// Tydzien 8, ISP, Zastosowanie 3
// Implementacja segregated interface - finansowanie
public class RentalFinanceImpl implements RentalFinance {

    private final java.util.Map<String, Double> payments = new java.util.HashMap<>();

    @Override
    public boolean processPayment(String rentalId, double amount) {
        payments.put(rentalId, amount);
        System.out.println("[ISP] Payment processed: " + amount + " PLN");
        return true;
    }

    @Override
    public double getRefundAmount(String rentalId) {
        Double paid = payments.get(rentalId);
        return paid != null ? paid * 0.5 : 0;
    }
}
// Koniec, Tydzien 8, ISP, Zastosowanie 3
