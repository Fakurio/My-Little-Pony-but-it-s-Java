package com.unicorn.my_little_pony.domain.store.isp.rental;

// Tydzien 8, ISP, Zastosowanie 1
// Implementacja malego kontraktu powiadomien
public class ConsoleCustomerNotifier implements CustomerNotifier {

    @Override
    public void sendNotification(String customerName, String message) {
        System.out.println("[NOTIFY] " + customerName + ": " + message);
    }
}
// Koniec, Tydzien 8, ISP, Zastosowanie 1

