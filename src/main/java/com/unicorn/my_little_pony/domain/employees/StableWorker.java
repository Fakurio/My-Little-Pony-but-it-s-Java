package com.unicorn.my_little_pony.domain.employees;

// Tydzień 5, Wzorzec Mediator, Zastosowanie 2
// Interfejs reprezentujący pracownika stajni, który może komunikować się z innymi pracownikami za pośrednictwem mediatora
public interface StableWorker {
    String getName();
    void send(String message);
    void receive(String message);
}
// Koniec, Tydzień 5, Wzorzec Mediator, Zastosowanie 2