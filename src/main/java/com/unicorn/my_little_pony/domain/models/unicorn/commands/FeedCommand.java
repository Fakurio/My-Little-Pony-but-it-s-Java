package com.unicorn.my_little_pony.domain.models.unicorn.commands;

import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;

// Tydzień 5, Wzorzec Command, Zastosowanie 2
// Konkretne zadanie karmienia jednorożca
public class FeedCommand implements Command {
    private final Unicorn unicorn;

    public FeedCommand(Unicorn unicorn) {
        this.unicorn = unicorn;
    }

    @Override
    public void execute() {
        System.out.println("Feeding " + unicorn.getName());
    }

    @Override
    public void undo() {

    }
}
// Koniec, Tydzień 5, Wzorzec Command