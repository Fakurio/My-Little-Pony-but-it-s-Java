package com.unicorn.my_little_pony.domain.models.unicorn.commands;

// Tydzień 5, Wzorzec Command
// Wspólny interfejs dla wszystkich obiektów konkretnych zadań z obsługą cofnięcia ostatniej akcji
public interface Command {
    void execute();
    void undo();
}
// Koniec, Tydzień 5, Wzorzec Command