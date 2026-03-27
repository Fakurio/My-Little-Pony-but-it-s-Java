package com.unicorn.my_little_pony;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoWeek6Runner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n");
        System.out.println("===========================================================");
        System.out.println("  DEMO TYDZIEŃ 6: Strategy + State + Observer + Visitor + Template ");
        System.out.println("===========================================================");
        System.out.println();
        demoStrategy();
        demoObserver();
        demoState();
        demoVisitor();
        demoTemplate();
        System.out.println();
        System.out.println("===========================================================");
    }

    private void demoTemplate() {
    }

    private void demoVisitor() {
    }

    private void demoState() {
    }

    private void demoObserver() {
    }

    private void demoStrategy() {
    }


}
