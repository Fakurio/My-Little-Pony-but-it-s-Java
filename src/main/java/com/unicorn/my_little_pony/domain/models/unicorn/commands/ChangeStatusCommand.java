package com.unicorn.my_little_pony.domain.models.unicorn.commands;

import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;
import com.unicorn.my_little_pony.enums.UnicornStatus;

// Tydzień 5, Wzorzec Command, Zastosowanie 3
// Konkretne zadanie zmiany statusu jednorożca
public class ChangeStatusCommand implements Command {
    private final Unicorn unicorn;
    private final UnicornStatus oldStatus;
    private final UnicornStatus newStatus;

    public ChangeStatusCommand(Unicorn unicorn, UnicornStatus newStatus) {
        this.unicorn = unicorn;
        this.newStatus = newStatus;
        this.oldStatus = unicorn.getStatus();
    }

    @Override
    public void execute() {
        unicorn.setStatus(newStatus);
    }

    @Override
    public void undo() {
        unicorn.setStatus(oldStatus);
    }
}
// Koniec, Tydzień 5, Wzorzec Command
