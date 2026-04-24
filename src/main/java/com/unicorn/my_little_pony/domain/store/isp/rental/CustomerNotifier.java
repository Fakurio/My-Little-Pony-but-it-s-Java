package com.unicorn.my_little_pony.domain.store.isp.rental;

// Tydzien 8, ISP, Zastosowanie 1
// Interfejs po segregacji: tylko powiadomienia
public interface CustomerNotifier {
    void sendNotification(String customerName, String message);
}
// Koniec, Tydzien 8, ISP, Zastosowanie 1

