package com.unicorn.my_little_pony.domain.employees;

import java.util.ArrayList;
import java.util.List;

// Tydzień 5, Wzorzec Mediator, Zastosowanie 2
// Konkretna implementacja mediatora, który zarządza komunikacją między pracownikami stajni. Umożliwia dodawanie pracowników i przesyłanie wiadomości między nimi.
public class UnicornStableMediator implements StableMediator {

    private final List<StableWorker> workers = new ArrayList<>();

    @Override
    public void addWorker(StableWorker worker) {
        if (worker == null) {
            throw new IllegalArgumentException("Worker cannot be null");
        }
        workers.add(worker);
    }

    @Override
    public void sendMessage(String message, StableWorker sender) {
        for (StableWorker worker : workers) {
            if (worker != sender) {
                worker.receive("[" + sender.getName() + "]: " + message);
            }
        }
    }
}
// Koniec, Tydzień 5, Wzorzec Mediator, Zastosowanie 2