package com.unicorn.my_little_pony.domain.rentalSystem;

// Tydzień 5, Wzorzec Mediator, Zastosowanie 1
// interfejs Mediatora, który będzie pośredniczył w komunikacji między modułami systemu
public interface SystemMediator {
    void addModule(SystemModule module);
    void sendMessage(String message, SystemModule sender);
}
// Koniec, Tydzień 5, Wzorzec Mediator, Zastosowanie 1