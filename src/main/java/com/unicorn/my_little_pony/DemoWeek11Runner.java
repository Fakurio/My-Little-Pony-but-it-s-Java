package com.unicorn.my_little_pony;

import com.unicorn.my_little_pony.aspect.audit.AuditLog;
import com.unicorn.my_little_pony.aspect.vipaccess.VipContext;
import com.unicorn.my_little_pony.domain.exceptions.PaymentProcessingException;
import com.unicorn.my_little_pony.domain.exceptions.TransportUnavailableException;
import com.unicorn.my_little_pony.domain.exceptions.VipAccessRequiredException;
import com.unicorn.my_little_pony.domain.models.customer.Customer;
import com.unicorn.my_little_pony.domain.models.customer.CustomerContact;
import com.unicorn.my_little_pony.domain.models.customer.CustomerIdentity;
import com.unicorn.my_little_pony.domain.models.unicorn.states.UnicornContext;
import com.unicorn.my_little_pony.domain.models.unicorn.types.FireUnicorn;
import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;
import com.unicorn.my_little_pony.domain.models.unicorn.types.UnicornIdentity;
import com.unicorn.my_little_pony.integration.payment.providers.PaypalProvider;
import com.unicorn.my_little_pony.integration.transport.TransportAdapter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoWeek11Runner implements CommandLineRunner {

    private final AuditLog auditLog;

    public DemoWeek11Runner(AuditLog auditLog) {
        this.auditLog = auditLog;
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

        System.out.println("===========================================================");
    }

    private static final double TEST_PAYMENT_VALUE = -10;
    private static final int TEST_POWER_LEVEL = 95;

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
}
// Koniec, Tydzień 11, Programowanie Aspektowe (AOP)
