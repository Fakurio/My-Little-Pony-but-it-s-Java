package com.unicorn.my_little_pony;

import com.unicorn.my_little_pony.domain.models.rental.Rental;
import com.unicorn.my_little_pony.domain.models.rental.builders.RentalBuilder;
import com.unicorn.my_little_pony.domain.models.rental.iterator.RentalBook;
import com.unicorn.my_little_pony.domain.models.service.composite.BasicService;
import com.unicorn.my_little_pony.domain.models.service.composite.ServiceBundle;
import com.unicorn.my_little_pony.domain.models.unicorn.composite.Herd;
import com.unicorn.my_little_pony.domain.models.unicorn.composite.SingleUnicornUnit;
import com.unicorn.my_little_pony.domain.models.unicorn.iterator.status.StableUnicornCollection;
import com.unicorn.my_little_pony.domain.rentalservices.DiscountService;
import com.unicorn.my_little_pony.domain.rentalservices.InsuranceService;
import com.unicorn.my_little_pony.domain.rentalservices.RentalService;
import com.unicorn.my_little_pony.domain.rentalservices.UnicornRentalServiceMediator;
import com.unicorn.my_little_pony.domain.store.UnicornManager;
import com.unicorn.my_little_pony.enums.RentalStatus;
import com.unicorn.my_little_pony.repositories.UnicornDatabaseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.unicorn.my_little_pony.domain.functional.UnicornFunctionalService;
import com.unicorn.my_little_pony.domain.models.unicorn.types.FireUnicorn;
import com.unicorn.my_little_pony.domain.models.unicorn.types.IceUnicorn;
import com.unicorn.my_little_pony.domain.models.unicorn.types.LightningUnicorn;
import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;
import com.unicorn.my_little_pony.domain.models.unicorn.types.UnicornIdentity;
import com.unicorn.my_little_pony.domain.models.unicorn.types.WaterUnicorn;
import com.unicorn.my_little_pony.enums.UnicornStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;


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
        demoPredicate();
        System.out.println();
        demoFunction();
        System.out.println();
        demoStream();

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

    private void demoPredicate() {

        System.out.println("=========================");
        System.out.println("Predicate Interface");
        System.out.println("=========================");

        UnicornFunctionalService service = new UnicornFunctionalService();
        List<Unicorn> stable = createDemoStable();

        System.out.println("Przykład 1: dostępne jednorożce");

        Predicate<Unicorn> availableUnicorn = unicorn ->
                unicorn.getStatus() == UnicornStatus.AVAILABLE;

        service.findMatchingUnicorns(stable, availableUnicorn)
                .forEach(unicorn -> System.out.println(unicorn.getName()
                        + " jest dostępny do wynajmu."));

        System.out.println();
        System.out.println("Przykład 2: reguła biznesowa wyboru jednorożców VIP");

        Predicate<Unicorn> vipRentalCandidate = unicorn ->
                unicorn.getStatus() == UnicornStatus.AVAILABLE
                        && unicorn.getTotalPower() >= 90
                        && unicorn.getRating() >= 4.6;

        service.findMatchingUnicorns(stable, vipRentalCandidate)
                .forEach(unicorn -> System.out.println(unicorn.getName()
                        + " spełnia warunki wynajmu VIP."));

        System.out.println();
        System.out.println("Przykład 3: jednorożce wymagające promocji cenowej");

        Predicate<Unicorn> needsPromotion = unicorn ->
                unicorn.getStatus() == UnicornStatus.AVAILABLE
                        && (unicorn.getRating() < 4.6 || unicorn.getPrice() > 350.0);

        service.findMatchingUnicorns(stable, needsPromotion)
                .forEach(unicorn -> System.out.println(unicorn.getName()
                        + " może dostać promocję, żeby łatwiej znaleźć klienta."));

        System.out.println("----------------------------");
    }

    private void demoFunction() {

        System.out.println("=========================");
        System.out.println("Function Interface");
        System.out.println("=========================");

        System.out.println("Przykład 1: przygotowanie kart rekomendacji dla klienta");

        UnicornFunctionalService service = new UnicornFunctionalService();
        List<Unicorn> stable = createDemoStable();

        Predicate<Unicorn> customerSafeCandidate = unicorn ->
                unicorn.getStatus() == UnicornStatus.AVAILABLE
                        && unicorn.getPrice() <= 350.0
                        && unicorn.getRating() >= 4.5;

        Function<Unicorn, String> recommendationCard = unicorn -> String.format(
                "%s | kolor: %s | moc: %d | ocena: %.1f | cena: %.2f PLN",
                unicorn.getName(),
                unicorn.getColor(),
                unicorn.getTotalPower(),
                unicorn.getRating(),
                unicorn.getPrice()
        );

        service.prepareRecommendationCards(stable, customerSafeCandidate, recommendationCard)
                .forEach(System.out::println);

        System.out.println();
        System.out.println("Przykład 2: wyliczenie ceny po rabacie");

        Function<Unicorn, String> discountedPriceCard = unicorn -> {
            double discountedPrice = unicorn.getPrice() * 0.9;
            return String.format("%s po rabacie 10%% kosztuje %.2f PLN", unicorn.getName(), discountedPrice);
        };

        service.prepareRecommendationCards(stable, customerSafeCandidate, discountedPriceCard)
                .forEach(System.out::println);

        System.out.println();
        System.out.println("Przykład 3: zamiana obiektu Unicorn na krótki raport dla pracownika");

        Function<Unicorn, String> employeeReportLine = unicorn -> String.format(
                "%s (%s): status=%s, moc=%d, ocena=%.1f",
                unicorn.getId(),
                unicorn.getName(),
                unicorn.getStatus(),
                unicorn.getTotalPower(),
                unicorn.getRating()
        );

        service.prepareRecommendationCards(stable, unicorn -> true, employeeReportLine)
                .forEach(System.out::println);

        System.out.println("----------------------------");
    }
    private void demoStream() {
        System.out.println("Przykład 1: dostępne jednorożce");

        StableUnicornCollection collection = new StableUnicornCollection();

        for (Unicorn u : createDemoStable()) {
            collection.addUnicorn(u);
        }

        System.out.println("Aktywne jednorożce:");

        List<String> names = collection.getActiveUnicornNames();

        for (String name : names) {
            System.out.println("- " + name);
        }
        System.out.println("----------------------------");

        System.out.println("Przykład 2: liczba wypożyczeń");
        RentalBook book = createDemoRentals();

        long completed = book.countCompletedRentals();

        System.out.println("Liczba zakończonych wypożyczeń: " + completed);


        System.out.println("----------------------------");

        System.out.println("Przykład 3: nazwy usług");
        UnicornRentalServiceMediator mediator = createDemoServices();

        System.out.println("Nazwy usług:");

        List<String> names2 = mediator.getServiceNames();

        for (String name : names2) {
            System.out.println("- " + name);
        }

    }
    private List<Unicorn> createDemoStable() {
        Unicorn aurora = new FireUnicorn(new UnicornIdentity("U-101", "Aurora", "gold"), 95);
        aurora.setPrice(320.0);
        aurora.setRating(4.8);

        Unicorn misty = new WaterUnicorn(new UnicornIdentity("U-102", "Misty", "blue"), 70);
        misty.setPrice(240.0);
        misty.setRating(4.7);

        Unicorn storm = new LightningUnicorn(new UnicornIdentity("U-103", "Storm", "silver"), 110);
        storm.setPrice(420.0);
        storm.setRating(4.9);

        Unicorn snowdrop = new IceUnicorn(new UnicornIdentity("U-104", "Snowdrop", "white"), 92);
        snowdrop.setPrice(300.0);
        snowdrop.setRating(4.4);

        Unicorn ember = new FireUnicorn(new UnicornIdentity("U-105", "Ember", "red"), 105);
        ember.setPrice(280.0);
        ember.setRating(4.7);
        ember.setStatus(UnicornStatus.RENTED);

        return List.of(aurora, misty, storm, snowdrop, ember);
    }
    private RentalBook createDemoRentals() {

        RentalBook book = new RentalBook();

        book.addRental(new RentalBuilder()
                .id("R-1")
                .unicornId("U-101")
                .customerId("C-1")
                .start(LocalDateTime.now().minusDays(5))
                .end(LocalDateTime.now().minusDays(3))
                .basePrice(200)
                .finalPrice(200)
                .termsAccepted(true)
                .status(RentalStatus.COMPLETED)
                .build()
        );

        book.addRental(new RentalBuilder()
                .id("R-2")
                .unicornId("U-102")
                .customerId("C-2")
                .start(LocalDateTime.now().minusDays(2))
                .end(LocalDateTime.now().minusDays(1))
                .basePrice(150)
                .finalPrice(150)
                .termsAccepted(true)
                .status(RentalStatus.ACTIVE)
                .build()
        );

        book.addRental(new RentalBuilder()
                .id("R-3")
                .unicornId("U-103")
                .customerId("C-3")
                .start(LocalDateTime.now().minusDays(10))
                .end(LocalDateTime.now().minusDays(8))
                .basePrice(300)
                .finalPrice(300)
                .termsAccepted(true)
                .status(RentalStatus.COMPLETED)
                .build()
        );

        return book;
    }
    private UnicornRentalServiceMediator createDemoServices() {

        UnicornRentalServiceMediator mediator = new UnicornRentalServiceMediator();

        DiscountService discountService = new DiscountService(mediator);
        InsuranceService insuranceService = new InsuranceService(mediator);

        mediator.addService(discountService);
        mediator.addService(insuranceService);

        return mediator;
    }
}
