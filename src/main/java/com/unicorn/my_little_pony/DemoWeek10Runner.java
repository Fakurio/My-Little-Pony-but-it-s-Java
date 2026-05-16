package com.unicorn.my_little_pony;

import com.unicorn.my_little_pony.domain.models.service.composite.BasicService;
import com.unicorn.my_little_pony.domain.models.service.composite.ServiceBundle;
import com.unicorn.my_little_pony.domain.models.unicorn.composite.Herd;
import com.unicorn.my_little_pony.domain.models.unicorn.composite.SingleUnicornUnit;
import com.unicorn.my_little_pony.domain.store.UnicornManager;
import com.unicorn.my_little_pony.repositories.UnicornDatabaseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoWeek10Runner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n");
        System.out.println("===========================================================");
        System.out.println("  DEMO TYDZIEŃ 10: Functional Interfaces and Lambdas ");
        System.out.println("===========================================================");
        System.out.println();
        demoFunctionalInterfaces();
        System.out.println();
        System.out.println("===========================================================");
    }

    private void demoFunctionalInterfaces() {
        System.out.println("=========================");
        System.out.println("Zastosowanie 1: Filtrowanie (UnicornManager)");
        UnicornManager unicornManager = new UnicornManager(new UnicornDatabaseRepository());
        System.out.println("Jednorożce o mocy powyżej 100:");
        unicornManager.filterUnicorns(unicorn -> unicorn.getPowerLevel() > 100)
                .forEach(u -> System.out.println(u.getName() + " (Power: " + u.getPowerLevel() + ")"));

        System.out.println("\n=========================");
        System.out.println("Zastosowanie 2: Zniżki (ServiceBundle)");
        ServiceBundle bundle = new ServiceBundle("VIP Bundle");
        bundle.add(new BasicService("Decoration", 30));
        bundle.add(new BasicService("Trainer", 50));
        System.out.println("Cena bazowa: " + bundle.getPrice());
        System.out.println("Cena po znizce 20%: " + bundle.getDiscountedPrice(price -> price * 0.8));

        System.out.println("\n=========================");
        System.out.println("Zastosowanie 3: Iteracja po elementach (Herd)");
        Herd herd = new Herd();
        herd.add(new SingleUnicornUnit(2));
        herd.add(new SingleUnicornUnit(5));
        System.out.println("Ilość dostępnych jednorożców w poszczególnych jednostkach:");
        herd.forEachUnit(unit -> System.out.println("- Jednostka: " + unit.getAvailableCount() + " jednorożców"));
    }
}
