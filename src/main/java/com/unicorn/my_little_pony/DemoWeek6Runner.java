package com.unicorn.my_little_pony;

import com.unicorn.my_little_pony.domain.models.customer.Customer;
import com.unicorn.my_little_pony.domain.models.rental.RentalOrder;
import com.unicorn.my_little_pony.domain.models.rental.returnTemplate.DamagedReturnProcess;
import com.unicorn.my_little_pony.domain.models.rental.returnTemplate.LateReturnProcess;
import com.unicorn.my_little_pony.domain.models.rental.returnTemplate.StandardReturnProcess;
import com.unicorn.my_little_pony.domain.models.rental.returnTemplate.UnicornReturnTemplate;
import com.unicorn.my_little_pony.domain.models.rental.template.ExpressUnicornRentalProcess;
import com.unicorn.my_little_pony.domain.models.rental.template.PremiumUnicornRentalProcess;
import com.unicorn.my_little_pony.domain.models.rental.template.StandardUnicornRentalProcess;
import com.unicorn.my_little_pony.domain.models.rental.template.UnicornRentalProcess;
import com.unicorn.my_little_pony.domain.models.rentedUnicorn.RentedUnicorn;
import com.unicorn.my_little_pony.domain.models.unicorn.careTemplate.ForestUnicornPreparation;
import com.unicorn.my_little_pony.domain.models.unicorn.careTemplate.RainbowUnicornPreparation;
import com.unicorn.my_little_pony.domain.models.unicorn.careTemplate.RoyalUnicornPreparation;
import com.unicorn.my_little_pony.domain.models.unicorn.careTemplate.UnicornPreparationTemplate;
import com.unicorn.my_little_pony.domain.models.unicorn.strategies.unicornDelivery.DeliveryManager;
import com.unicorn.my_little_pony.domain.models.unicorn.strategies.unicornDelivery.TeleportationDeliveryStrategy;
import com.unicorn.my_little_pony.domain.models.unicorn.strategies.unicornDelivery.WalkingDeliveryStrategy;
import com.unicorn.my_little_pony.domain.models.unicorn.strategies.unicornSelection.BestRatedUnicornStrategy;
import com.unicorn.my_little_pony.domain.models.unicorn.strategies.unicornSelection.CheapestUnicornStrategy;
import com.unicorn.my_little_pony.domain.models.unicorn.strategies.unicornSelection.UnicornMatcher;
import com.unicorn.my_little_pony.domain.models.unicorn.types.FireUnicorn;
import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;
import com.unicorn.my_little_pony.domain.models.unicorn.types.WaterUnicorn;
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
        System.out.println("=========================");
        System.out.println("Template");
        System.out.println("=========================");
        System.out.println("Zastosowanie 1: Wypożyczenie jednorożca");
        UnicornRentalProcess standardRental = new StandardUnicornRentalProcess();
        UnicornRentalProcess premiumRental = new PremiumUnicornRentalProcess();
        UnicornRentalProcess expressRental = new ExpressUnicornRentalProcess();

        standardRental.processRental();
        System.out.println();

        premiumRental.processRental();
        System.out.println();

        expressRental.processRental();
        System.out.println();

        System.out.println("-------------------------");
        System.out.println("Zastosowanie 2: Opieka nad jednorożcem przed wypożyczeniem");
        UnicornPreparationTemplate rainbowPrep = new RainbowUnicornPreparation();
        UnicornPreparationTemplate royalPrep = new RoyalUnicornPreparation();
        UnicornPreparationTemplate forestPrep = new ForestUnicornPreparation();

        rainbowPrep.prepareUnicorn();
        System.out.println();

        royalPrep.prepareUnicorn();
        System.out.println();

        forestPrep.prepareUnicorn();
        System.out.println();
        System.out.println("-------------------------");
        System.out.println("Zastosowanie 3: Zwrot jednorożca");
        UnicornReturnTemplate standardReturn = new StandardReturnProcess();
        UnicornReturnTemplate lateReturn = new LateReturnProcess();
        UnicornReturnTemplate damagedReturn = new DamagedReturnProcess();

        standardReturn.processReturn();
        System.out.println();

        lateReturn.processReturn();
        System.out.println();

        damagedReturn.processReturn();
    }

    private void demoVisitor() {
    }

    private void demoState() {
        System.out.println("=========================");
        System.out.println("State");
        System.out.println("=========================");
        System.out.println("Zastosowanie 1: Stan dostępności jednorożca");

        Unicorn twilight =  new WaterUnicorn("1", "Twilight", "Blue", 100);
        System.out.println("Utworzono jednorożca: " + twilight.getName());
        System.out.println("\nKlient A wypożycza jednorożca:");
        twilight.rent();
        System.out.println("\nKlient B próbuje wypożyczyć tego samego jednorożca:");
        twilight.rent();
        System.out.println("\nKlient A zwraca jednorożca:");
        twilight.returnUnicorn();
        System.out.println("\nKlient C próbuje wypożyczyć brudnego jednorożca:");
        twilight.rent();
        System.out.println("\nStajenny myje jednorożca:");
        twilight.clean();
        System.out.println("\nKlient C ponawia próbę wypożyczenia:");
        twilight.rent();


        System.out.println("-------------------------");
        System.out.println("Zastosowanie 2: Stan zamówienia");

        RentalOrder order = new RentalOrder();
        System.out.println("Krok 1: Klient składa zamówienie (Szkic -> Oczekujące):");
        order.submit();
        System.out.println("\nKrok 2: Próba ponownego złożenia tego samego zamówienia:");
        order.submit();
        System.out.println("\nKrok 3: Klient opłaca zamówienie (Oczekujące -> Potwierdzone):");
        order.pay();
        System.out.println("\nKrok 4: Atakujący próbuje opłacić drugi raz:");
        order.pay();
        System.out.println("\nKrok 5: Klient rezygnuje (Potwierdzone -> Anulowane):");
        order.cancel();
        System.out.println("\nKrok 6: Próba zapłaty za anulowane zamówienie:");
        order.pay();


        System.out.println("-------------------------");
        System.out.println("Zastosowanie 3: Poziom energii wypożyczonego jednorożca");

        RentedUnicorn roach = new RentedUnicorn();
        System.out.println("Akcja 1: Galop! (Stan: Pełen energii)");
        roach.gallop();
        System.out.println("\nAkcja 2: Galop! (Stan: Pełen energii -> Zmęczony)");
        roach.gallop();
        System.out.println("\nAkcja 3: Galop resztką sił! (Stan: Zmęczony -> Wyczerpany)");
        roach.gallop();
        System.out.println("\nAkcja 4: Zmuszanie do galopu wyczerpanego zwierzęcia:");
        roach.gallop();
        System.out.println("\nAkcja 5: Odpoczynek:");
        roach.rest();
        System.out.println("\nAkcja 6: Galop po odpoczynku:");
        roach.gallop();
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
