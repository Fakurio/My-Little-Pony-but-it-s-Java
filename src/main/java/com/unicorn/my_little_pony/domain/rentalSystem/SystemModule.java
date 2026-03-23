package com.unicorn.my_little_pony.domain.rentalSystem;

// Tydzień 5, Wzorzec Mediator, Zastosowanie 1
// interfejs reprezentujący moduł systemu, który będzie komunikował się za pośrednictwem Mediatora
public interface SystemModule {
    String getName();
    void send(String message);
    void receive(String message);
}
// Koniec, Tydzień 5, Wzorzec Mediator, Zastosowanie 1