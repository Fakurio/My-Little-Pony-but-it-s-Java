package com.unicorn.my_little_pony.domain.models.notification.notifiers;

import com.unicorn.my_little_pony.domain.models.notification.channels.SocialChannel;

// Tydzień 3, Wzorzec Bridge, Zastosowanie 2
// Konkretna implementacja powiadamiacza dla zdarzeń płatności,
// oddelegowuje wysyłanie powiadomienia do obiektu channel
public class PaymentNotifier extends SocialNotifier {

    public PaymentNotifier(SocialChannel channel) {
        super(channel);
    }

    @Override
    public void notifyUser(String accountId, String details) {
        String msg = "Payment successful. Receipt: " + details;
        channel.sendMessage(accountId, msg);
    }
}
// Koniec, Tydzień 3, Wzorzec Bridge, Zastosowanie 2