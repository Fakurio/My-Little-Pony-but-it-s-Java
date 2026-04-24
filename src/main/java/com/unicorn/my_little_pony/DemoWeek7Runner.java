package com.unicorn.my_little_pony;

import com.unicorn.my_little_pony.domain.facades.booking.services.RecommendationService;
import com.unicorn.my_little_pony.domain.facades.rental.services.PricingService;
import com.unicorn.my_little_pony.domain.facades.rental.services.RainbowPricingRule;
import com.unicorn.my_little_pony.domain.models.customer.Customer;
import com.unicorn.my_little_pony.domain.models.rental.Rental;
import com.unicorn.my_little_pony.domain.models.rental.builders.RentalBuilder;
import com.unicorn.my_little_pony.domain.models.rental.iterator.RentalBook;
import com.unicorn.my_little_pony.domain.models.rental.iterator.RentalIterator;
import com.unicorn.my_little_pony.domain.models.rental.template.ExpressUnicornRentalProcess;
import com.unicorn.my_little_pony.domain.models.rental.template.PremiumUnicornRentalProcess;
import com.unicorn.my_little_pony.domain.models.rental.template.StandardUnicornRentalProcess;
import com.unicorn.my_little_pony.domain.models.rental.template.UnicornRentalProcess;
import com.unicorn.my_little_pony.domain.models.rental.template.dataDriven.RentalStep;
import com.unicorn.my_little_pony.domain.models.service.composite.ServiceBundle;
import com.unicorn.my_little_pony.domain.models.service.composite.ServiceComponent;
import com.unicorn.my_little_pony.domain.models.unicorn.strategies.unicornDelivery.DeliveryManager;
import com.unicorn.my_little_pony.domain.models.unicorn.strategies.unicornDelivery.TeleportationDeliveryStrategy;
import com.unicorn.my_little_pony.domain.models.unicorn.types.FireUnicorn;
import com.unicorn.my_little_pony.domain.models.unicorn.types.LightningUnicorn;
import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;
import com.unicorn.my_little_pony.domain.pricing.MagicFeeAbstractCalculator;
import com.unicorn.my_little_pony.domain.pricing.MagicFeeDDCalculator;
import com.unicorn.my_little_pony.domain.pricing.strategies.magicFee.FireMagicFee;
import com.unicorn.my_little_pony.domain.pricing.strategies.magicFee.WaterMagicFee;
import com.unicorn.my_little_pony.enums.RentalStatus;
import com.unicorn.my_little_pony.util.IdGenerator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.unicorn.my_little_pony.domain.models.rental.template.dataDriven.DataDrivenUnicornRentalProcess;
import com.unicorn.my_little_pony.domain.models.rental.template.dataDriven.RentalProcessConfig;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

@Component
public class DemoWeek7Runner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
//        System.out.println("\n");
//        System.out.println("===========================================================");
//        System.out.println("  DEMO TYDZIEŃ 7: SRP + OCP ");
//        System.out.println("===========================================================");
//        System.out.println();
//        demoSRP();
//        demoOCP();
//        System.out.println();
//        System.out.println("===========================================================");
    }

    private void demoSRP() {
        System.out.println("=========================");
        System.out.println("SRP");
        System.out.println("=========================");
        System.out.println("Przykład 1");
        DeliveryManager deliveryManager = new DeliveryManager();
        Unicorn inferno =  new FireUnicorn("1", "Inferno", "Red", 100);
        Customer vipCustomer = new Customer("C-1", "Princess Celestia",
                "princess@gmail.com", "111111111", true);
        Customer customer = new Customer("C-2", "Tony", "tony@gmail.com", "222222222", false);
        deliveryManager.arrangeDelivery(new TeleportationDeliveryStrategy(), inferno, vipCustomer);
        deliveryManager.arrangeDelivery(new TeleportationDeliveryStrategy(), inferno, customer);

        System.out.println("-------------------------");
        System.out.println("Przykład 2");
        System.out.println("Zastosowanie 2: Rental status iterator");

        RentalBook rentalBook = new RentalBook();
        IdGenerator idGen = IdGenerator.getInstance();
        Rental rental1 = new RentalBuilder()
                .unicornId(idGen.nextUnicornId())
                .customerId(idGen.nextCustomerId())
                .start(LocalDateTime.of(2026, 3, 20, 10, 0))
                .end(LocalDateTime.of(2026, 3, 20, 12, 0))
                .basePrice(100.0)
                .finalPrice(120.0)
                .termsAccepted(true)
                .status(RentalStatus.NEW)
                .build();

        Rental rental2 = new RentalBuilder()
                .unicornId(idGen.nextUnicornId())
                .customerId(idGen.nextCustomerId())
                .start(LocalDateTime.of(2026, 3, 21, 9, 0))
                .end(LocalDateTime.of(2026, 3, 21, 11, 0))
                .basePrice(150.0)
                .finalPrice(180.0)
                .termsAccepted(true)
                .status(RentalStatus.ACTIVE)
                .build();

        Rental rental3 = new RentalBuilder()
                .unicornId(idGen.nextUnicornId())
                .customerId(idGen.nextCustomerId())
                .start(LocalDateTime.of(2026, 3, 18, 14, 0))
                .end(LocalDateTime.of(2026, 3, 18, 16, 0))
                .basePrice(120.0)
                .finalPrice(120.0)
                .termsAccepted(true)
                .status(RentalStatus.COMPLETED)
                .build();

        Rental rental4 = new RentalBuilder()
                .unicornId(idGen.nextUnicornId())
                .customerId(idGen.nextCustomerId())
                .start(LocalDateTime.of(2026, 3, 22, 15, 0))
                .end(LocalDateTime.of(2026, 3, 22, 17, 0))
                .basePrice(130.0)
                .finalPrice(130.0)
                .termsAccepted(false)
                .status(RentalStatus.CANCELLED)
                .build();

        rentalBook.addRental(rental1);
        rentalBook.addRental(rental2);
        rentalBook.addRental(rental3);
        rentalBook.addRental(rental4);

        System.out.println("ACTIVE rentals:");
        RentalIterator activeIterator = rentalBook.createIterator(RentalStatus.ACTIVE);
        while (activeIterator.hasNext()) {
            System.out.println(activeIterator.next());
        }

        System.out.println("\nCOMPLETED rentals:");
        RentalIterator completedIterator = rentalBook.createIterator(RentalStatus.COMPLETED);
        while (completedIterator.hasNext()) {
            System.out.println(completedIterator.next());
        }
        System.out.println("Przykład 3");
        System.out.println("Zastosowanie 3: ServiceBundle");
        ServiceComponent decoration = new ServiceComponent() {
            @Override
            public double getPrice() {
                return 30;
            }

            @Override
            public String getDescription() {
                return "Decoration";
            }
        };

        ServiceComponent trainer = new ServiceComponent() {
            @Override
            public double getPrice() {
                return 50;
            }

            @Override
            public String getDescription() {
                return "Trainer";
            }
        };

        ServiceBundle bundle = new ServiceBundle("VIP Package");
        bundle.add(decoration);
        bundle.add(trainer);

        System.out.println("Total price: " + bundle.getPrice());
        System.out.println("Description: " + bundle.getDescription());

    }

    private void demoOCP() {
        System.out.println("=========================");
        System.out.println("OCP");
        System.out.println("=========================");

        System.out.println("Obliczanie opłaty magicznej - przez abstrakcje");
        MagicFeeAbstractCalculator abstractCalculator = new MagicFeeAbstractCalculator();
        int basePrice = 100;
        System.out.println("Opłata bazowa: " + basePrice);
        System.out.println("Opłata za ognistą magie: " + abstractCalculator.calculate(new FireMagicFee(), basePrice));
        System.out.println("Opłata za wodną magie: " + abstractCalculator.calculate(new WaterMagicFee(), basePrice));
        System.out.println("-------------------------");

        System.out.println("Obliczanie opłaty magicznej - przez sterowanie danymi");
        MagicFeeDDCalculator ddCalculator = new MagicFeeDDCalculator();
        System.out.println("Opłata bazowa: " + basePrice);
        System.out.println("Opłata za ognistą magie: " + ddCalculator.calculate("Fire", basePrice));
        System.out.println("Opłata za wodną magie: " + ddCalculator.calculate("Water", basePrice));

        System.out.println("==========================");
        System.out.println("PRZYKŁAD 2");
        System.out.println("Procesowanie wypożyczenia jednorożca - przez abstrakcję");
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
        System.out.println("Procesowanie wypożyczenia jednorożca - przez sterowanie danymi");

        RentalProcessConfig config = new RentalProcessConfig(List.of(
                new RentalStep(
                        "VALIDATE_CUSTOMER",
                        "Verifying customer eligibility and rental history...",
                        true
                ),
                new RentalStep(
                        "CHOOSE_UNICORN",
                        "Selecting a crystal unicorn for the customer...",
                        true
                ),
                new RentalStep(
                        "CALCULATE_PRICE",
                        "Calculating magical rental price with premium insurance...",
                        true
                ),
                new RentalStep(
                        "PREPARE_AGREEMENT",
                        "Preparing rental agreement and processing payment...",
                        true
                ),
                new RentalStep(
                        "RELEASE_UNICORN",
                        "Releasing the unicorn from the enchanted stable...",
                        true
                ),
                new RentalStep(
                        "SEND_NOTIFICATION",
                        "Sending pickup instructions to the customer...",
                        true
                )
        ));

        Map<String, Consumer<String>> handlers = new HashMap<>();
        handlers.put("VALIDATE_CUSTOMER", System.out::println);
        handlers.put("CHOOSE_UNICORN", System.out::println);
        handlers.put("CALCULATE_PRICE", System.out::println);
        handlers.put("PREPARE_AGREEMENT", System.out::println);
        handlers.put("RELEASE_UNICORN", System.out::println);
        handlers.put("SEND_NOTIFICATION", System.out::println);

        DataDrivenUnicornRentalProcess process =
                new DataDrivenUnicornRentalProcess(config, handlers);

        process.processRental();
        System.out.println("==========================");

        System.out.println("==========================");
        System.out.println("PRZYKŁAD 3");
        System.out.println("Procesowanie wypożyczenia jednorożca - przez abstrakcję");
        System.out.println("-------------------------");

        PricingService pricingService = new PricingService(List.of(
                new RainbowPricingRule()
        ));

        String rainbowUnicorn = "RAINBOW_001";
        String normalUnicorn = "NORMAL_001";

        double rainbowPrice = pricingService.calculatePrice(rainbowUnicorn);
        double normalPrice = pricingService.calculatePrice(normalUnicorn);

        System.out.println("Unicorn: " + rainbowUnicorn + " price: " + rainbowPrice);
        System.out.println("Unicorn: " + normalUnicorn + " price: " + normalPrice);
        System.out.println("-------------------------");

        System.out.println("Obliczanie opłaty magicznej - przez sterowanie danymi");
        RecommendationService recommendationService = new RecommendationService();

        System.out.println("DEFAULT customer:");
        System.out.println(recommendationService.recommendExtras("DEFAULT"));

        System.out.println("VIP customer:");
        System.out.println(recommendationService.recommendExtras("VIP"));

        System.out.println("RAINBOW customer:");
        System.out.println(recommendationService.recommendExtras("RAINBOW"));

        System.out.println("UNKNOWN customer:");
        System.out.println(recommendationService.recommendExtras("UNKNOWN"));
    }
}
