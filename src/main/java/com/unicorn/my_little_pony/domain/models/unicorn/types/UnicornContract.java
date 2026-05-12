package com.unicorn.my_little_pony.domain.models.unicorn.types;

// Tydzień 4, Wzorzec Proxy, Zastosowanie 1
// Interfejs dla jednorożca oraz proxy dostępu do specjalnej umiejętności jednorożca
public interface UnicornContract {
    void useSpecialAbility() throws Exception;
    String getName();
}
// Koniec, Tydzień 4, Wzorzec Proxy