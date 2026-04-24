package com.unicorn.my_little_pony.domain.store.isp.rental_lifecycle;

import com.unicorn.my_little_pony.domain.models.customer.Customer;
import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;

// Tydzien 8, ISP, Zastosowanie 3
// Segregated interface - tylko tworzenie i zarzadzanie wynajmem
public interface RentalLifecycle {
    void createRental(String rentalId, Unicorn unicorn, Customer customer);
    void confirmRental(String rentalId);
    void cancelRental(String rentalId);
}
// Koniec, Tydzien 8, ISP, Zastosowanie 3
