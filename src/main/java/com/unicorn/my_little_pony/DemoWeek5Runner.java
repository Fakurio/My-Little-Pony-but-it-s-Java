package com.unicorn.my_little_pony;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoWeek5Runner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n");
        System.out.println("===========================================================");
        System.out.println("  DEMO TYDZIEŃ 5: Command + Interpreter + Iterator + Mediator + Memento ");
        System.out.println("===========================================================");
        System.out.println();
        demoCommand();
        demoInterpreter();
        demoIterator();
        demoMediator();
        demoMemento();
        System.out.println();
        System.out.println("===========================================================");
    }

    private void demoCommand() {}

    private void demoInterpreter() {}

    private void demoIterator() {}

    private void demoMediator() {}

    private void demoMemento() {}
}
