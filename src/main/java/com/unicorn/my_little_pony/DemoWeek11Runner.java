package com.unicorn.my_little_pony;

import com.unicorn.my_little_pony.aspect.audit.AuditLog;
import com.unicorn.my_little_pony.aspect.vipaccess.VipContext;
import com.unicorn.my_little_pony.aspect.showcase.AopShowcaseService;
import com.unicorn.my_little_pony.aspect.showcase.CampaignRequest;
import com.unicorn.my_little_pony.domain.exceptions.PaymentProcessingException;
import com.unicorn.my_little_pony.domain.exceptions.TransportUnavailableException;
import com.unicorn.my_little_pony.domain.exceptions.VipAccessRequiredException;
import com.unicorn.my_little_pony.domain.models.customer.Customer;
import com.unicorn.my_little_pony.domain.models.customer.CustomerContact;
import com.unicorn.my_little_pony.domain.models.customer.CustomerIdentity;
import com.unicorn.my_little_pony.domain.models.rental.builders.RentalBuilder;
import com.unicorn.my_little_pony.domain.models.rental.iterator.RentalBook;
import com.unicorn.my_little_pony.domain.models.unicorn.iterator.status.StableUnicornCollection;
import com.unicorn.my_little_pony.domain.models.unicorn.states.UnicornContext;
import com.unicorn.my_little_pony.domain.models.unicorn.types.FireUnicorn;
import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;
import com.unicorn.my_little_pony.domain.models.unicorn.types.UnicornIdentity;
import com.unicorn.my_little_pony.enums.RentalStatus;
import com.unicorn.my_little_pony.integration.payment.providers.PaypalProvider;
import com.unicorn.my_little_pony.integration.transport.TransportAdapter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DemoWeek11Runner implements CommandLineRunner {

    private static final double TEST_PAYMENT_VALUE = -10;
    private static final int TEST_POWER_LEVEL = 95;

    private static final String SECTION_OPERATION_TIMING = "Zastosowanie 4: @Around – CampaignTimingAspect";
    private static final String SECTION_REQUEST_VALIDATION = "Zastosowanie 5: @Before – CampaignValidationAspect";
    private static final String SECTION_RESULT_REPORTING = "Zastosowanie 6: @AfterReturning – CampaignResultReportingAspect";

    private static final String CAMPAIGN_NAME = "Summer Sparkle Tour";
    private static final String INVALID_CAMPAIGN_NAME = "   ";
    private static final int CAMPAIGN_AUDIENCE_SIZE = 3;

    private static final String SHOWCASE_SECOND_UNICORN_ID = "U-402";
    private static final String SHOWCASE_SECOND_UNICORN_NAME = "Starlight";
    private static final String SHOWCASE_SECOND_UNICORN_COLOR = "fioletowy";
    private static final int SHOWCASE_SECOND_UNICORN_POWER_LEVEL = 110;

    private static final String SHOWCASE_THIRD_UNICORN_ID = "U-403";
    private static final String SHOWCASE_THIRD_UNICORN_NAME = "Misty";
    private static final String SHOWCASE_THIRD_UNICORN_COLOR = "niebieski";
    private static final int SHOWCASE_THIRD_UNICORN_POWER_LEVEL = 70;

    private static final int DEMO_POWER_LEVEL = 95;

    private static final String VIP_UNICORN_ID = "U-201";
    private static final String VIP_UNICORN_NAME = "Aurora";
    private static final String VIP_UNICORN_COLOR = "złoty";

    private final AuditLog auditLog;
    private final AopShowcaseService aopShowcaseService;

    public DemoWeek11Runner(AuditLog auditLog, AopShowcaseService aopShowcaseService) {
        this.auditLog = auditLog;
        this.aopShowcaseService = aopShowcaseService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n");
        System.out.println("===========================================================");
        System.out.println("  DEMO TYDZIEŃ 11: Programowanie Aspektowe (AOP)         ");
        System.out.println("===========================================================");
        System.out.println();

        demoExceptionTranslation();
        System.out.println();
        demoVipAccess();
        System.out.println();
        demoStateTransitionAudit();
        System.out.println();

        demoOperationTiming();
        System.out.println();
        demoRequestValidation();
        System.out.println();
        demoResultReporting();

        System.out.println();
        demoEmptyCollectionAspect();
        System.out.println();
        demoCounter();
        System.out.println();
        demoAvailableUnicornsAndPowerAspect();
    }


    private void demoExceptionTranslation() {
        System.out.println("=========================");
        System.out.println("Zastosowanie 1: @AfterThrowing – ExceptionTranslationAspect");
        System.out.println();

        // Przykład 1: Nieprawidłowa kwota płatności → PaymentProcessingException z aspektu
        System.out.println("Przykład 1: Próba płatności kwotą ujemną przez PaypalProvider");
        PaypalProvider paypalProvider = new PaypalProvider();
        try {
            paypalProvider.process(TEST_PAYMENT_VALUE);
        } catch (PaymentProcessingException e) {
            System.out.println("Złapano wyjątek domenowy: " + e.getClass().getSimpleName()
                    + " → " + e.getMessage());
        }

        System.out.println();

        // Przykład 2: Transport niedostępnego jednorożca → TransportUnavailableException z aspektu
        System.out.println("Przykład 2: Próba transportu dla niedostępnego jednorożca (NIEZNANE-ID)");
        TransportAdapter transportAdapter = new TransportAdapter();
        try {
            transportAdapter.scheduleTransport("NIEZNANE-ID", "Duch", "Kraków");
        } catch (TransportUnavailableException e) {
            System.out.println("Złapano wyjątek domenowy: " + e.getClass().getSimpleName()
                    + " → " + e.getMessage());
        }

        System.out.println("----------------------------");
    }

    private void demoVipAccess() {
        System.out.println("=========================");
        System.out.println("Zastosowanie 2: @Before – VipAccessAspect");
        System.out.println();

        Unicorn aurora = new FireUnicorn(new UnicornIdentity("U-201", "Aurora", "złoty"), TEST_POWER_LEVEL);
        Customer vipCustomer = new Customer(
                new CustomerIdentity("C-VIP", "Celestia"),
                new CustomerContact("celestia@canterlot.pl", "000-000-000"),
                true
        );
        Customer regularCustomer = new Customer(
                new CustomerIdentity("C-REG", "Applejack"),
                new CustomerContact("applejack@ponyville.pl", "111-111-111"),
                false
        );

        System.out.println("Przykład 1: Klient VIP próbuje użyć umiejętności specjalnej");
        try {
            VipContext.set(vipCustomer);
            aurora.useSpecialAbility();
        } catch (VipAccessRequiredException e) {
            System.out.println("[Demo] Dostęp zablokowany: " + e.getMessage());
        } finally {
            VipContext.clear();
        }

        System.out.println();
        System.out.println("Przykład 2: Klient bez statusu VIP próbuje użyć umiejętności specjalnej");
        try {
            VipContext.set(regularCustomer);
            aurora.useSpecialAbility();
        } catch (VipAccessRequiredException e) {
            System.out.println("[Demo] Dostęp zablokowany: " + e.getMessage());
        } finally {
            VipContext.clear();
        }

        System.out.println("----------------------------");
    }

    private void demoStateTransitionAudit() {
        System.out.println("=========================");
        System.out.println("Zastosowanie 3: @AfterReturning – StateTransitionAuditAspect");
        System.out.println();

        Unicorn storm = new FireUnicorn(new UnicornIdentity("U-301", "Storm", "srebrny"), TEST_POWER_LEVEL);
        UnicornContext context = new UnicornContext(storm);

        System.out.println("Przykład 1: Wypożyczenie jednorożca (rent)");
        context.rent();

        System.out.println();
        System.out.println("Przykład 2: Zwrot jednorożca (returnUnicorn)");
        context.returnUnicorn();

        System.out.println();
        System.out.println("Przykład 3: Czyszczenie jednorożca (clean)");
        context.clean();

        System.out.println();
        System.out.println("=== Dziennik audytu (AuditLog) ===");
        auditLog.printAll();
        System.out.println("----------------------------");
    }

    private void demoOperationTiming() {
        System.out.println(SECTION_OPERATION_TIMING);

        List<Unicorn> showcaseUnicorns = createShowcaseUnicorns();
        List<String> campaignMessages = aopShowcaseService.prepareCampaignMessages(showcaseUnicorns, CAMPAIGN_NAME);

        System.out.println("Przykład 1: Przygotowanie komunikatów kampanii marketingowej");
        campaignMessages.forEach(message -> System.out.println("- " + message));

        System.out.println("----------------------------");
    }

    private void demoRequestValidation() {
        System.out.println(SECTION_REQUEST_VALIDATION);

        CampaignRequest validRequest = new CampaignRequest(CAMPAIGN_NAME, CAMPAIGN_AUDIENCE_SIZE);
        System.out.println("Przykład 1: Poprawne uruchomienie kampanii");
        System.out.println(aopShowcaseService.launchCampaign(validRequest));

        System.out.println();
        System.out.println("Przykład 2: Nieprawidłowa nazwa kampanii");
        try {
            aopShowcaseService.launchCampaign(new CampaignRequest(INVALID_CAMPAIGN_NAME, CAMPAIGN_AUDIENCE_SIZE));
        } catch (IllegalArgumentException e) {
            System.out.println("Złapano wyjątek walidacji: " + e.getMessage());
        }

        System.out.println("----------------------------");
    }

    private void demoResultReporting() {
        System.out.println(SECTION_RESULT_REPORTING);

        List<String> featuredUnicornNames = aopShowcaseService.buildFeaturedUnicornNames(createShowcaseUnicorns());

        System.out.println("Przykład 1: Najlepiej rokujące jednorożce do kampanii");
        featuredUnicornNames.forEach(name -> System.out.println("- " + name));

        System.out.println("----------------------------");
    }

    private void demoEmptyCollectionAspect() {

        System.out.println("=========================");
        System.out.println("Zastosowanie 7: CheckEmptyCollection");
        System.out.println();

        StableUnicornCollection stable = new StableUnicornCollection();

        System.out.println("Przykład 1: brak jednorożców w stajni");
        List<String> emptyResult = stable.getActiveUnicornNames();
        System.out.println("Wynik: " + emptyResult);

        System.out.println();

        stable.addUnicorn(new FireUnicorn(
                new UnicornIdentity("U-1", "Blaze", "red"),
                120
        ));

        stable.addUnicorn(new FireUnicorn(
                new UnicornIdentity("U-2", "Frost", "blue"),
                90
        ));

        System.out.println("Przykład 2: jednorożce są w stajni");
        List<String> result = stable.getActiveUnicornNames();
        System.out.println("Wynik: " + result);

        System.out.println("----------------------------");
    }
    private void demoCounter() {
        System.out.println("Zastosowanie 8: MethodCounterAspect");
        System.out.println();
        RentalBook book = new RentalBook();

        book.addRental(new RentalBuilder()
                .unicornId("U1")
                .customerId("C1")
                .start(java.time.LocalDateTime.now())
                .end(java.time.LocalDateTime.now().plusHours(2))
                .status(RentalStatus.COMPLETED)
                .build());

        book.getCompletedRentals();
        book.getCompletedRentals();
    }
    private void demoAvailableUnicornsAndPowerAspect() {

        System.out.println("=========================");
        System.out.println("Zastosowanie 9: MonitorPowerLevel + dostępne jednorożce");
        System.out.println();

        StableUnicornCollection stable = new StableUnicornCollection();

        stable.addUnicorn(new FireUnicorn(
                new UnicornIdentity("U-1", "Blaze", "red"),
                120
        ));

        stable.addUnicorn(new FireUnicorn(
                new UnicornIdentity("U-2", "Frost", "blue"),
                90
        ));

        stable.addUnicorn(new FireUnicorn(
                new UnicornIdentity("U-3", "Spark", "gold"),
                150
        ));

        stable.addUnicorn(new FireUnicorn(
                new UnicornIdentity("U-4", "Mist", "white"),
                70
        ));

        System.out.println("Przykład 1: dostępne jednorożce (AVAILABLE)");

        List<Unicorn> available = stable.getAvailableUnicorns();

        if (available.isEmpty()) {
            System.out.println("Brak dostępnych jednorożców.");
        } else {
            available.forEach(u ->
                    System.out.println("- " + u.getName() + " | moc: " + u.getTotalPower())
            );
        }

        System.out.println("----------------------------");
    }

    private List<Unicorn> createShowcaseUnicorns() {
        return List.of(
                new FireUnicorn(new UnicornIdentity(VIP_UNICORN_ID, VIP_UNICORN_NAME, VIP_UNICORN_COLOR), DEMO_POWER_LEVEL),
                new FireUnicorn(new UnicornIdentity(SHOWCASE_SECOND_UNICORN_ID, SHOWCASE_SECOND_UNICORN_NAME, SHOWCASE_SECOND_UNICORN_COLOR), SHOWCASE_SECOND_UNICORN_POWER_LEVEL),
                new FireUnicorn(new UnicornIdentity(SHOWCASE_THIRD_UNICORN_ID, SHOWCASE_THIRD_UNICORN_NAME, SHOWCASE_THIRD_UNICORN_COLOR), SHOWCASE_THIRD_UNICORN_POWER_LEVEL)
        );
    }

}
// Koniec, Tydzień 11, Programowanie Aspektowe (AOP)
