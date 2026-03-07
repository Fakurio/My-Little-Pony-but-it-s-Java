package com.unicorn.my_little_pony.domain.models.notification.channels;

// Tydzień 3, Wzorzec Bridge, Zastosowanie 2
// Konkretna implementacja wysyłania powiadomień przez Facebook
public class FacebookChannel implements SocialChannel {

    @Override
    public void sendMessage(String accountId, String message) {
        System.out.println("Facebook DM to [" + accountId + "]: " + message);
    }
}
// Koniec, Tydzień 3, Wzorzec Bridge, Zastosowanie 2