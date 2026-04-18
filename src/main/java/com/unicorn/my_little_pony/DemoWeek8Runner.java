package com.unicorn.my_little_pony;

import com.unicorn.my_little_pony.domain.magicCombat.UnicornBattleSystem;
import com.unicorn.my_little_pony.domain.magicCombat.attacks.FireAttack;
import com.unicorn.my_little_pony.domain.magicCombat.attacks.WaterAttack;
import com.unicorn.my_little_pony.domain.store.UnicornManager;
import com.unicorn.my_little_pony.integration.payment.PaymentProcessor;
import com.unicorn.my_little_pony.integration.payment.providers.PaypalProvider;
import com.unicorn.my_little_pony.integration.payment.providers.StripeProvider;
import com.unicorn.my_little_pony.repositories.UnicornDatabaseRepository;
import com.unicorn.my_little_pony.repositories.UnicornFileRepository;
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
        System.out.println("=========================");
        System.out.println("Dependency Inversion");
        System.out.println("=========================");

        System.out.println("Zastosowanie 1");
        PaymentProcessor paymentProcessor = new PaymentProcessor(new PaypalProvider());
        paymentProcessor.pay(20);
        paymentProcessor.setProvider(new StripeProvider());
        paymentProcessor.pay(10);
        System.out.println("----------------------------");

        System.out.println("Zastosowanie 2");
        UnicornManager unicornManager = new UnicornManager(new UnicornDatabaseRepository());
        System.out.println("Unicorns from database");
        unicornManager.getUnicorns().forEach(System.out::println);
        unicornManager.setUnicornRepository(new UnicornFileRepository());
        System.out.println("Unicorns from text file");
        unicornManager.getUnicorns().forEach(System.out::println);
        System.out.println("----------------------------");

        System.out.println("Zastosowanie 3");
        UnicornBattleSystem unicornBattleSystem = new UnicornBattleSystem();
        unicornBattleSystem.castSpell(new FireAttack());
        unicornBattleSystem.castSpell(new WaterAttack());
    }

    private void demoInterfaces() {
    }
}
