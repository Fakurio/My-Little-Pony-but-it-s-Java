package com.unicorn.my_little_pony.domain.store.isp.rental_lifecycle;

// Tydzien 8, ISP, Zastosowanie 3
// Klient po segregacji - zalezy tylko od raportow
public class ReportGeneratorWorker {
    private final RentalReporting rentalReporting;

    public ReportGeneratorWorker(RentalReporting rentalReporting) {
        this.rentalReporting = rentalReporting;
    }

    public void generateReports(String rentalId) {
        System.out.println("[ISP] Report Generator: Creating reports");
        rentalReporting.generateRentalReport(rentalId);
        rentalReporting.generateFinancialReport(rentalId);
    }
}
// Koniec, Tydzien 8, ISP, Zastosowanie 3
