package com.unicorn.my_little_pony.domain.store.fat.rental_lifecycle;

import com.unicorn.my_little_pony.domain.exceptions.RentalRecordNotFoundException;
import com.unicorn.my_little_pony.domain.models.customer.Customer;
import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;

import java.util.HashMap;
import java.util.Map;

// Tydzien 8, ISP, Zastosowanie 3
// Fat implementation implementuje wszystko naraz
public class FatCompleteRentalManager implements CompleteRentalManagement {

    private static final double REFUND_RATE = 0.5;
    private static final double INITIAL_PAYMENT_AMOUNT = 0.0;

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
        data.paid = INITIAL_PAYMENT_AMOUNT;
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
    public void processRentalPayment(String rentalId, double amount) {
        RentalData rentalData = getRentalDataOrThrow(rentalId);
        rentalData.paid = amount;
        System.out.println("[FAT RENTAL] Payment processed: " + amount + " PLN");
    }

    @Override
    public double getRefundAmount(String rentalId) {
        return getRentalDataOrThrow(rentalId).paid * REFUND_RATE;
    }

    @Override
    public void notifyCustomer(String rentalId, String message) {
        if (rentals.containsKey(rentalId)) {
            System.out.println("[FAT RENTAL] Notifying customer: " + message);
        }
    }

    @Override
    public String getCustomerName(String rentalId) {
        return getRentalDataOrThrow(rentalId).customer.getName();
    }

    @Override
    public String generateRentalReport(String rentalId) {
        return "Rental Report for " + rentalId;
    }

    @Override
    public String generateFinancialReport(String rentalId) {
        return "Financial Report for " + rentalId;
    }

    private RentalData getRentalDataOrThrow(String rentalId) {
        RentalData rentalData = rentals.get(rentalId);
        if (rentalData == null) {
            throw new RentalRecordNotFoundException(rentalId);
        }
        return rentalData;
    }
}
// Koniec, Tydzien 8, ISP, Zastosowanie 3
