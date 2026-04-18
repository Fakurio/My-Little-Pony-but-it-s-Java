package com.unicorn.my_little_pony;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoWeek8Runner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n");
        System.out.println("===========================================================");
        System.out.println("  DEMO TYDZIEŃ 8: Liskov + DI + Interfejsy ");
        System.out.println("===========================================================");
        System.out.println();
        demoLiskov();
        demoDI();
        demoInterfaces();
        System.out.println();
        System.out.println("===========================================================");
    }

    private void demoLiskov() {
    }

    private void demoDI() {
    }

    private void demoInterfaces() {
    }
}
