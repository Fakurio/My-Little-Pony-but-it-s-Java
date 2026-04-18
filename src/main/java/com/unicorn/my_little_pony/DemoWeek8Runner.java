package com.unicorn.my_little_pony;

import com.unicorn.my_little_pony.domain.magicCombat.UnicornBattleSystem;
import com.unicorn.my_little_pony.domain.magicCombat.attacks.FireAttack;
import com.unicorn.my_little_pony.domain.magicCombat.attacks.WaterAttack;
import com.unicorn.my_little_pony.domain.store.isp.rental.BrowsingClient;
import com.unicorn.my_little_pony.domain.store.isp.rental.CheckoutClient;
import com.unicorn.my_little_pony.domain.store.isp.rental.ConsoleCustomerNotifier;
import com.unicorn.my_little_pony.domain.store.isp.rental.CustomerNotifier;
import com.unicorn.my_little_pony.domain.store.fat.rental.FatBrowsingClient;
import com.unicorn.my_little_pony.domain.store.fat.rental.FatCheckoutClient;
import com.unicorn.my_little_pony.domain.store.fat.rental.FatRentalFacade;
import com.unicorn.my_little_pony.domain.store.isp.rental.NotificationClient;
import com.unicorn.my_little_pony.domain.store.isp.rental.ProviderRentalPayment;
import com.unicorn.my_little_pony.domain.store.isp.rental.RentalPayment;
import com.unicorn.my_little_pony.domain.store.isp.rental.RepositoryUnicornCatalog;
import com.unicorn.my_little_pony.domain.store.isp.rental.UnicornCatalog;
import com.unicorn.my_little_pony.domain.store.fat.unicorncare.ComprehensiveUnicornCare;
import com.unicorn.my_little_pony.domain.store.fat.unicorncare.FatComprehensiveCareProvider;
import com.unicorn.my_little_pony.domain.store.fat.unicorncare.FatGroomerWorker;
import com.unicorn.my_little_pony.domain.store.isp.unicorncare.UnicornGroomingService;
import com.unicorn.my_little_pony.domain.store.isp.unicorncare.UnicornHealthService;
import com.unicorn.my_little_pony.domain.store.isp.unicorncare.UnicornTrainingService;
import com.unicorn.my_little_pony.domain.store.isp.unicorncare.GroomingServiceImpl;
import com.unicorn.my_little_pony.domain.store.isp.unicorncare.HealthServiceImpl;
import com.unicorn.my_little_pony.domain.store.isp.unicorncare.TrainingServiceImpl;
import com.unicorn.my_little_pony.domain.store.isp.unicorncare.GroomerWorker;
import com.unicorn.my_little_pony.domain.store.isp.unicorncare.VeterinarianWorker;
import com.unicorn.my_little_pony.domain.store.isp.unicorncare.TrainerWorker;
import com.unicorn.my_little_pony.domain.store.fat.rental_lifecycle.CompleteRentalManagement;
import com.unicorn.my_little_pony.domain.store.fat.rental_lifecycle.FatCompleteRentalManager;
import com.unicorn.my_little_pony.domain.store.fat.rental_lifecycle.FatRentalAgent;
import com.unicorn.my_little_pony.domain.store.isp.rental_lifecycle.RentalLifecycle;
import com.unicorn.my_little_pony.domain.store.isp.rental_lifecycle.RentalFinance;
import com.unicorn.my_little_pony.domain.store.isp.rental_lifecycle.RentalReporting;
import com.unicorn.my_little_pony.domain.store.isp.rental_lifecycle.RentalLifecycleImpl;
import com.unicorn.my_little_pony.domain.store.isp.rental_lifecycle.RentalFinanceImpl;
import com.unicorn.my_little_pony.domain.store.isp.rental_lifecycle.RentalReportingImpl;
import com.unicorn.my_little_pony.domain.store.isp.rental_lifecycle.RentalAgent;
import com.unicorn.my_little_pony.domain.store.isp.rental_lifecycle.AccountantWorker;
import com.unicorn.my_little_pony.domain.store.isp.rental_lifecycle.ReportGeneratorWorker;
import com.unicorn.my_little_pony.domain.models.customer.Customer;
import com.unicorn.my_little_pony.domain.models.unicorn.types.FireUnicorn;
import com.unicorn.my_little_pony.util.IdGenerator;
import com.unicorn.my_little_pony.domain.store.UnicornManager;
import com.unicorn.my_little_pony.integration.payment.PaymentProcessor;
import com.unicorn.my_little_pony.integration.payment.providers.PaymentProvider;
import com.unicorn.my_little_pony.integration.payment.providers.PaypalProvider;
import com.unicorn.my_little_pony.integration.payment.providers.StripeProvider;
import com.unicorn.my_little_pony.repositories.UnicornRepository;
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
        System.out.println("=========================");
        System.out.println("Interface Segregation");
        System.out.println("=========================");

        UnicornRepository unicornRepository = new UnicornDatabaseRepository();
        PaymentProvider paymentProvider = new PaypalProvider();

        System.out.println("Przed refaktoryzacja: fat interfejs");
        FatRentalFacade fatRentalFacade = new FatRentalFacade(unicornRepository, paymentProvider);
        FatBrowsingClient fatBrowsingClient = new FatBrowsingClient(fatRentalFacade);
        FatCheckoutClient fatCheckoutClient = new FatCheckoutClient(fatRentalFacade);
        fatBrowsingClient.showAvailableCount();
        fatCheckoutClient.checkout(59.99);
        System.out.println("----------------------------");

        System.out.println("Po refaktoryzacji: interfejsy po segregacji");
        UnicornCatalog unicornCatalog = new RepositoryUnicornCatalog(unicornRepository);
        RentalPayment rentalPayment = new ProviderRentalPayment(new StripeProvider());
        CustomerNotifier customerNotifier = new ConsoleCustomerNotifier();

        BrowsingClient browsingClient = new BrowsingClient(unicornCatalog);
        CheckoutClient checkoutClient = new CheckoutClient(rentalPayment);
        NotificationClient notificationClient = new NotificationClient(customerNotifier);

        browsingClient.showAvailableCount();
        checkoutClient.checkout(59.99);
        notificationClient.sendRentalReadyMessage("Twilight Sparkle");
        System.out.println("===========================\n");

        System.out.println("Zastosowanie 2: Unicorn Care Services");
        System.out.println("Przed refaktoryzacja: fat interfejs");
        ComprehensiveUnicornCare fatCare = new FatComprehensiveCareProvider();
        FatGroomerWorker fatGroomerWorker = new FatGroomerWorker(fatCare);
        fatGroomerWorker.prepareUnicorn("Blaze");
        System.out.println("Groomer zaleza od calego ComprehensiveUnicornCare.");
        System.out.println("----------------------------");

        System.out.println("Po refaktoryzacji: interfejsy po segregacji");
        UnicornGroomingService groomingService = new GroomingServiceImpl();
        UnicornHealthService healthService = new HealthServiceImpl();
        UnicornTrainingService trainingService = new TrainingServiceImpl();

        GroomerWorker groomerWorker = new GroomerWorker(groomingService);
        VeterinarianWorker veterinarianWorker = new VeterinarianWorker(healthService);
        TrainerWorker trainerWorker = new TrainerWorker(trainingService);

        groomerWorker.prepareUnicorn("Sparkle");
        veterinarianWorker.examineUnicorn("Sparkle");
        trainerWorker.trainUnicorn("Sparkle", false);
        System.out.println("===========================\n");

        System.out.println("Zastosowanie 3: Rental Management");
        System.out.println("Przed refaktoryzacja: fat interfejs");
        CompleteRentalManagement fatRentalManager = new FatCompleteRentalManager();
        FatRentalAgent fatAgent = new FatRentalAgent(fatRentalManager);
        Customer customer = new Customer("123", "Rainbow Dash", "iloveunicorns@example.com", "123-456-789", false);
        FireUnicorn unicorn = new FireUnicorn(IdGenerator.getInstance().nextUnicornId(), "Phoenix", "golden", 95);
        fatRentalManager.createRental("R001", unicorn, customer);
        fatAgent.processNewRental("R001");
        System.out.println("Agent zaleza od calego CompleteRentalManagement.");
        System.out.println("----------------------------");

        System.out.println("Po refaktoryzacji: interfejsy po segregacji");
        RentalLifecycle rentalLifecycle = new RentalLifecycleImpl();
        RentalFinance rentalFinance = new RentalFinanceImpl();
        RentalReporting rentalReporting = new RentalReportingImpl();

        rentalLifecycle.createRental("R002", unicorn, customer);
        RentalAgent agent = new RentalAgent(rentalLifecycle);
        AccountantWorker accountant = new AccountantWorker(rentalFinance);
        ReportGeneratorWorker reportGenerator = new ReportGeneratorWorker(rentalReporting);

        agent.processNewRental("R002");
        rentalFinance.processPayment("R002", 100.0);
        accountant.processRefund("R002");
        reportGenerator.generateReports("R002");
    }
}
