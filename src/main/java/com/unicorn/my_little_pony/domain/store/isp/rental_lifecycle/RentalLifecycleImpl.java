package com.unicorn.my_little_pony.domain.store.isp.rental_lifecycle;

import com.unicorn.my_little_pony.domain.models.customer.Customer;
import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;
import java.util.HashMap;
import java.util.Map;

// Tydzien 8, ISP, Zastosowanie 3
// Implementacja segregated interface - zarzadzanie wynajmem
public class RentalLifecycleImpl implements RentalLifecycle {

    private final Map<String, RentalData> rentals = new HashMap<>();

    static class RentalData {
        Unicorn unicorn;
        Customer customer;
        boolean confirmed;
    }

    @Override
    public void createRental(String rentalId, Unicorn unicorn, Customer customer) {
        RentalData data = new RentalData();
        data.unicorn = unicorn;
        data.customer = customer;
        data.confirmed = false;
        rentals.put(rentalId, data);
        System.out.println("[ISP] Rental created: " + rentalId);
    }

    @Override
    public void confirmRental(String rentalId) {
        if (rentals.containsKey(rentalId)) {
            rentals.get(rentalId).confirmed = true;
            System.out.println("[ISP] Rental confirmed: " + rentalId);
        }
    }

    @Override
    public void cancelRental(String rentalId) {
        rentals.remove(rentalId);
        System.out.println("[ISP] Rental cancelled: " + rentalId);
    }

    public Map<String, RentalData> getRentals() {
        return rentals;
    }
}
// Koniec, Tydzien 8, ISP, Zastosowanie 3
