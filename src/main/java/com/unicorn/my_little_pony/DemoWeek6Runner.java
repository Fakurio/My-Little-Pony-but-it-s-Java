package com.unicorn.my_little_pony;

import com.unicorn.my_little_pony.domain.models.customer.Customer;
import com.unicorn.my_little_pony.domain.models.unicorn.strategies.unicornDelivery.DeliveryManager;
import com.unicorn.my_little_pony.domain.models.unicorn.strategies.unicornDelivery.TeleportationDeliveryStrategy;
import com.unicorn.my_little_pony.domain.models.unicorn.strategies.unicornDelivery.WalkingDeliveryStrategy;
import com.unicorn.my_little_pony.domain.models.unicorn.strategies.unicornSelection.BestRatedUnicornStrategy;
import com.unicorn.my_little_pony.domain.models.unicorn.strategies.unicornSelection.CheapestUnicornStrategy;
import com.unicorn.my_little_pony.domain.models.unicorn.strategies.unicornSelection.UnicornMatcher;
import com.unicorn.my_little_pony.domain.models.unicorn.types.FireUnicorn;
import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;
import com.unicorn.my_little_pony.domain.pricing.strategies.StandardPricingStrategy;
import com.unicorn.my_little_pony.domain.pricing.strategies.WeekendPricingStrategy;
import com.unicorn.my_little_pony.domain.store.UnicornCart;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

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
        System.out.println("=========================");
        System.out.println("Strategy");
        System.out.println("=========================");
        System.out.println("Zastosowanie 1: Obliczanie ceny");

        UnicornCart cart = new UnicornCart();
        int rentHours = 5;

        System.out.println("--- Standard pricing na tygodniu ---");
        double standardPrice = cart.pay(new StandardPricingStrategy(), rentHours, false);
        System.out.println("Wynik: " + standardPrice + " PLN\n");

        System.out.println("--- Weekend pricing w weekend ---");
        double weekendPrice = cart.pay(new WeekendPricingStrategy(), rentHours, true);
        System.out.println("Wynik: " + weekendPrice + " PLN\n");

        System.out.println("--- Weekend pricing na tygodniu ---");
        standardPrice = cart.pay(new WeekendPricingStrategy(), rentHours, false);
        System.out.println("Wynik: " + standardPrice + " PLN\n");


        System.out.println("-------------------------");
        System.out.println("Zastosowanie 2: Wybór jednorożca");

        UnicornMatcher matcher = new UnicornMatcher();
        Unicorn blaze =  new FireUnicorn("1", "Blaze", "Red", 100);
        blaze.setPrice(30.4);
        blaze.setRating(5);
        Unicorn inferno =  new FireUnicorn("2", "Inferno", "Red", 100);
        inferno.setPrice(10.4);
        inferno.setRating(2);
        List<Unicorn> store = List.of(blaze, inferno);
        Customer customer = new Customer("C-2", "Tony", "tony@gmail.com", "222222222", false);
        Customer vipCustomer = new Customer("C-1", "Princess Celestia",
                "princess@gmail.com", "111111111", true);
        System.out.println("Dostępne jednorożce:");
        store.forEach(System.out::println);

        Unicorn cheapestOne = matcher.findBestUnicorn(new CheapestUnicornStrategy(), store, customer);
        System.out.println("Wynik: Przydzielono jednorożca: " + cheapestOne.getName() + "\n");

        Unicorn bestRatingOne = matcher.findBestUnicorn(new BestRatedUnicornStrategy(), store, vipCustomer);
        System.out.println("Wynik: Przydzielono jednorożca: " + bestRatingOne.getName() + "\n");


        System.out.println("-------------------------");
        System.out.println("Zastosowanie 3: Wybór sposobu dostawy");

        DeliveryManager deliveryManager = new DeliveryManager();
        deliveryManager.arrangeDelivery(new WalkingDeliveryStrategy(), inferno, customer);
        deliveryManager.arrangeDelivery(new TeleportationDeliveryStrategy(), blaze, vipCustomer);
    }


}
