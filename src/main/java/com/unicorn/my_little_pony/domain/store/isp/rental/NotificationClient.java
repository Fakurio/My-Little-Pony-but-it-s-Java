package com.unicorn.my_little_pony.domain.store.isp.rental;

// Tydzien 8, ISP, Zastosowanie 1
// Klient po segregacji zalezy tylko od powiadomien
public class NotificationClient {
    private final CustomerNotifier customerNotifier;

    public NotificationClient(CustomerNotifier customerNotifier) {
        this.customerNotifier = customerNotifier;
    }

    public void sendRentalReadyMessage(String customerName) {
        customerNotifier.sendNotification(customerName, "Twoj jednorozec jest gotowy do odbioru.");
    }
}
// Koniec, Tydzien 8, ISP, Zastosowanie 1

