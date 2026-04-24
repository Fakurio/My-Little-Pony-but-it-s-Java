package com.unicorn.my_little_pony.domain.store.isp.rental_lifecycle;

// Tydzien 8, ISP, Zastosowanie 3
// Klient po segregacji - zalezy tylko od finansow
public class AccountantWorker {
    private final RentalFinance rentalFinance;

    public AccountantWorker(RentalFinance rentalFinance) {
        this.rentalFinance = rentalFinance;
    }

    public void processRefund(String rentalId) {
        System.out.println("[ISP] Accountant: Processing refund");
        double refund = rentalFinance.getRefundAmount(rentalId);
        System.out.println("[ISP] Refund amount: " + refund + " PLN");
    }
}
// Koniec, Tydzien 8, ISP, Zastosowanie 3
