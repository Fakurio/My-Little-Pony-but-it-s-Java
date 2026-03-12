package com.unicorn.my_little_pony.domain.models.notification.notifiers;

import com.unicorn.my_little_pony.domain.models.notification.channels.SocialChannel;

// Tydzień 3, Wzorzec Bridge, Zastosowanie 2
// Klasa bazowa dla wszystkich klas implementujących powiadamianie użytkowników o danym zdarzeniu w systemie,
// jest to część abstrakcyjna wzorca bridge która oddelegowuje użycie konkretnego social media do obiektu channel
public abstract class SocialNotifier {
    protected final SocialChannel channel;

    public SocialNotifier(SocialChannel channel) {
        this.channel = channel;
    }

    public abstract void notifyUser(String accountId, String details);
}
// Koniec, Tydzień 3, Wzorzec Bridge, Zastosowanie 2