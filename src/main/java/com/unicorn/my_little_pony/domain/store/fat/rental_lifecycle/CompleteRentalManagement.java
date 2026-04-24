package com.unicorn.my_little_pony.domain.store.fat.rental_lifecycle;

import com.unicorn.my_little_pony.domain.models.customer.Customer;
import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;

// Tydzien 8, ISP, Zastosowanie 3
// Fat interface - miesza wynajmy, finansowanie, klientow i raporty
public interface CompleteRentalManagement {
    void createRental(String rentalId, Unicorn unicorn, Customer customer);
    void confirmRental(String rentalId);
    void cancelRental(String rentalId);
    boolean processRentalPayment(String rentalId, double amount);
    double getRefundAmount(String rentalId);
    void notifyCustomer(String rentalId, String message);
    String getCustomerName(String rentalId);
    String generateRentalReport(String rentalId);
    String generateFinancialReport(String rentalId);
}
// Koniec, Tydzien 8, ISP, Zastosowanie 3

