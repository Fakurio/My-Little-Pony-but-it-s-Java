package com.unicorn.my_little_pony;

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
import com.unicorn.my_little_pony.domain.models.rental.template.dataDriven.RentalStepType;
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
import java.util.List;

@Component
public class DemoWeek7Runner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n");
        System.out.println("===========================================================");
        System.out.println("  DEMO TYDZIEŃ 7: SRP + OCP ");
        System.out.println("===========================================================");
        System.out.println();
        demoSRP();
        demoOCP();
        System.out.println();
        System.out.println("===========================================================");
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

        // // Standard rental process: validate -> select -> calculate -> agree -> release -> notify
        // java.util.List<Runnable> standardSteps = java.util.Arrays.asList(
        //     () -> System.out.println("Verifying customer eligibility and rental history..."),
        //     () -> System.out.println("A standard unicorn was selected from the available stable."),
        //     () -> System.out.println("Standard rental price calculated."),
        //     () -> System.out.println("Preparing rental agreement and processing payment..."),
        //     () -> System.out.println("The unicorn was handed over to the customer at the pickup point."),
        //     () -> System.out.println("Notifying customer about rental details and pickup instructions...")
        // );
        // RentalProcessConfig standardConfig = new RentalProcessConfig(standardSteps);
        // DataDrivenUnicornRentalProcess standardProcess = new DataDrivenUnicornRentalProcess(standardConfig);
        // standardProcess.processRental();
        // System.out.println();

        // // Festival rental process: validate -> agree -> calculate -> select -> release (skips notify for custom handling)
        // java.util.List<Runnable> festivalSteps = java.util.Arrays.asList(
        //     () -> System.out.println("Verifying customer eligibility and rental history..."),
        //     () -> System.out.println("Preparing rental agreement and processing payment..."),
        //     () -> System.out.println("Festival rental price calculated with event package and decoration fee."),
        //     () -> System.out.println("A colorful festival unicorn was selected for the seasonal event."),
        //     () -> System.out.println("The festival unicorn was released with decorative accessories.")
        // );
        // RentalProcessConfig festivalConfig = new RentalProcessConfig(festivalSteps);
        // DataDrivenUnicornRentalProcess festivalProcess = new DataDrivenUnicornRentalProcess(festivalConfig);
        // festivalProcess.processRental();

        RentalProcessConfig config = new RentalProcessConfig(List.of(
                new RentalStep(
                        RentalStepType.VALIDATE_CUSTOMER,
                        "Verifying customer eligibility and rental history...",
                        true
                ),
                new RentalStep(
                        RentalStepType.CHOOSE_UNICORN,
                        "Selecting a crystal unicorn for the customer...",
                        true
                ),
                new RentalStep(
                        RentalStepType.CALCULATE_PRICE,
                        "Calculating magical rental price with premium insurance...",
                        true
                ),
                new RentalStep(
                        RentalStepType.PREPARE_AGREEMENT,
                        "Preparing rental agreement and processing payment...",
                        true
                ),
                new RentalStep(
                        RentalStepType.RELEASE_UNICORN,
                        "Releasing the unicorn from the enchanted stable...",
                        true
                ),
                new RentalStep(
                        RentalStepType.SEND_NOTIFICATION,
                        "Sending pickup instructions to the customer...",
                        true
                )
        ));

        DataDrivenUnicornRentalProcess process =
                new DataDrivenUnicornRentalProcess(config);

        process.processRental();
        System.out.println("==========================");

    }
}
