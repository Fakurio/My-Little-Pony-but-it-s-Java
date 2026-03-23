package com.unicorn.my_little_pony.domain.employees;

// Tydzień 5, Wzorzec Mediator, Zastosowanie 2
// interfejs Mediatora, który będzie pośredniczył w komunikacji między pracownikami stajni
public interface StableMediator {
    void addWorker(StableWorker worker);
    void sendMessage(String message, StableWorker sender);
}
// Koniec, Tydzień 5, Wzorzec Mediator, Zastosowanie 2