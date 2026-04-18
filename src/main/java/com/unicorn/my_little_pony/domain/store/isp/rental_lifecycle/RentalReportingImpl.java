package com.unicorn.my_little_pony.domain.store.isp.rental_lifecycle;

// Tydzien 8, ISP, Zastosowanie 3
// Implementacja segregated interface - raporty
public class RentalReportingImpl implements RentalReporting {

    @Override
    public String generateRentalReport(String rentalId) {
        String report = "Rental Report for " + rentalId;
        System.out.println("[ISP] " + report);
        return report;
    }

    @Override
    public String generateFinancialReport(String rentalId) {
        String report = "Financial Report for " + rentalId;
        System.out.println("[ISP] " + report);
        return report;
    }
}
// Koniec, Tydzien 8, ISP, Zastosowanie 3
