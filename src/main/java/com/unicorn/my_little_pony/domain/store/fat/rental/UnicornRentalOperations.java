package com.unicorn.my_little_pony.domain.store.fat.rental;

import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;

import java.util.List;

// Tydzien 8, ISP, Zastosowanie 1
// Przyklad interfejsu zbyt rozbudowanego
// Interfejs laczy niespokrewnione odpowiedzialnosci: katalog, platnosci i powiadomienia.
public interface UnicornRentalOperations {
    List<Unicorn> getAvailableUnicorns();
    boolean processPayment(double amount);
    void sendNotification(String customerName, String message);
}
// Koniec, Tydzien 8, ISP, Zastosowanie 1
