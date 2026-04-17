package com.unicorn.my_little_pony.domain.store;

import com.unicorn.my_little_pony.domain.models.unicorn.commands.Command;
import com.unicorn.my_little_pony.domain.pricing.strategies.pricing.PricingStrategy;

import java.util.Stack;

// Tydzień 5, Wzorzec Command, Zastosowanie 1
// Koszyk do zamawiania ekwipunku jednorożca z możliwością cofnięcia ostatniego wyboru
public class UnicornCart {
    private final Stack<Command> commandHistory = new Stack<Command>();

    public void addEquipment(Command command) {
        command.execute();
        commandHistory.push(command);
    }

    public void undoLastAction() {
        if (!commandHistory.isEmpty()) {
            Command lastCommand = commandHistory.pop();
            lastCommand.undo();
        } else {
            System.out.println("Nothing to undo!");
        }
    }

    //Tydzień 6, Wzorzec Strategy, Zastosowanie 1
    //Metoda klasy kontekstu wywołująca daną strategie
    public double pay(PricingStrategy strategy, int hours, boolean isWeekend) {
        return strategy.calculatePrice(hours, isWeekend);
    }
    // Koniec, Tydzień 6, Wzorzec Strategy
}
// Koniec, Tydzień 5, Wzorzec Command