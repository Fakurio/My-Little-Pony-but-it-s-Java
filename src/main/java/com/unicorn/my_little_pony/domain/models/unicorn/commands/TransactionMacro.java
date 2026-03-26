package com.unicorn.my_little_pony.domain.models.unicorn.commands;

import java.util.Stack;

// Tydzień 5, Wzorzec Command, Zastosowanie 3
// Zadanie reprezentujące transakcje n zadań
public class TransactionMacro implements Command {
    private final Stack<Command> executedCommands = new Stack<>();

    public void executeCommand(Command command) {
        command.execute();
        executedCommands.push(command);
    }

    @Override
    public void execute() {

    }

    @Override
    public void undo() {
        System.out.println("Transaction failed! Rolling back...");
        while (!executedCommands.isEmpty()) {
            executedCommands.pop().undo();
        }
    }
}
// Koniec, Tydzień 5, Wzorzec Command
