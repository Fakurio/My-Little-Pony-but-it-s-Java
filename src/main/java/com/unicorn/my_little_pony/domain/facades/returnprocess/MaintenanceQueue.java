package com.unicorn.my_little_pony.domain.facades.returnprocess;

import com.unicorn.my_little_pony.domain.models.unicorn.commands.Command;

import java.util.LinkedList;
import java.util.Queue;

// Tydzień 5, Wzorzec Command, Zastosowanie 2
// Kolejka zadań która wywołuje je przy użyciu metody execute z intefejsu
public class MaintenanceQueue {
    private final Queue<Command> jobs = new LinkedList<>();

    public void addJob(Command command) {
        jobs.add(command);
    }

    public void processAll() {
        while (!jobs.isEmpty()) {
            jobs.poll().execute();
        }
    }
}
// Koniec, Tydzień 5, Wzorzec Command