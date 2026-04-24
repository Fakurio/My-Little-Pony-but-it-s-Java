package com.unicorn.my_little_pony.domain.store.fat.rental_lifecycle;

import com.unicorn.my_little_pony.domain.models.customer.Customer;
import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;

import java.util.HashMap;
import java.util.Map;

// Tydzien 8, ISP, Zastosowanie 3
// Fat implementation implementuje wszystko naraz
public class FatCompleteRentalManager implements CompleteRentalManagement {

    private final Map<String, RentalData> rentals = new HashMap<>();

    static class RentalData {
        Unicorn unicorn;
        Customer customer;
        boolean confirmed;
        double paid;
    }

    @Override
    public void createRental(String rentalId, Unicorn unicorn, Customer customer) {
        RentalData data = new RentalData();
        data.unicorn = unicorn;
        data.customer = customer;
        data.confirmed = false;
        data.paid = 0;
        rentals.put(rentalId, data);
        System.out.println("[FAT RENTAL] Rental created: " + rentalId);
    }

    @Override
    public void confirmRental(String rentalId) {
        if (rentals.containsKey(rentalId)) {
            rentals.get(rentalId).confirmed = true;
            System.out.println("[FAT RENTAL] Rental confirmed: " + rentalId);
        }
    }

    @Override
    public void cancelRental(String rentalId) {
        rentals.remove(rentalId);
        System.out.println("[FAT RENTAL] Rental cancelled: " + rentalId);
    }

    @Override
    public boolean processRentalPayment(String rentalId, double amount) {
        if (rentals.containsKey(rentalId)) {
            rentals.get(rentalId).paid = amount;
            System.out.println("[FAT RENTAL] Payment processed: " + amount + " PLN");
            return true;
        }
        return false;
    }

    @Override
    public double getRefundAmount(String rentalId) {
        if (rentals.containsKey(rentalId)) {
            return rentals.get(rentalId).paid * 0.5;
        }
        return 0;
    }

    @Override
    public void notifyCustomer(String rentalId, String message) {
        if (rentals.containsKey(rentalId)) {
            System.out.println("[FAT RENTAL] Notifying customer: " + message);
        }
    }

    @Override
    public String getCustomerName(String rentalId) {
        if (rentals.containsKey(rentalId)) {
            return rentals.get(rentalId).customer.getName();
        }
        return "Unknown";
    }

    @Override
    public String generateRentalReport(String rentalId) {
        return "Rental Report for " + rentalId;
    }

    @Override
    public String generateFinancialReport(String rentalId) {
        return "Financial Report for " + rentalId;
    }
}
// Koniec, Tydzien 8, ISP, Zastosowanie 3

