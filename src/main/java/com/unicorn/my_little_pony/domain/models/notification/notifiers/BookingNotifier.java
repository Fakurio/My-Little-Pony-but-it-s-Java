package com.unicorn.my_little_pony.domain.models.notification.notifiers;

import com.unicorn.my_little_pony.domain.models.notification.channels.SocialChannel;

// Tydzień 3, Wzorzec Bridge, Zastosowanie 2
// Konkretna implementacja powiadamiacza dla zdarzeń wypożyczenia jednorożca,
// oddelegowuje wysyłanie powiadomienia do obiektu channel
public class BookingNotifier extends SocialNotifier {

    public BookingNotifier(SocialChannel channel) {
        super(channel);
    }

    @Override
    public void notifyUser(String accountId, String details) {
        String msg = "Your magical unicorn is reserved! Details: " + details;
        channel.sendMessage(accountId, msg);
    }
}
// Koniec, Tydzień 3, Wzorzec Bridge, Zastosowanie 2