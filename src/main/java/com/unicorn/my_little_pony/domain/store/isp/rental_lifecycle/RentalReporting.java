package com.unicorn.my_little_pony.domain.store.isp.rental_lifecycle;

// Tydzien 8, ISP, Zastosowanie 3
// Segregated interface - tylko raporty
public interface RentalReporting {
    String generateRentalReport(String rentalId);
    String generateFinancialReport(String rentalId);
}
// Koniec, Tydzien 8, ISP, Zastosowanie 3
