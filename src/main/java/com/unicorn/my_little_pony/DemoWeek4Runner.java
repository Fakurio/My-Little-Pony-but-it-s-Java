package com.unicorn.my_little_pony;

import com.unicorn.my_little_pony.database.DatabaseRentingHistoryLoader;
import com.unicorn.my_little_pony.database.RentingHistoryLoader;
import com.unicorn.my_little_pony.domain.models.customer.Customer;
import com.unicorn.my_little_pony.domain.models.rental.Rental;
import com.unicorn.my_little_pony.domain.models.unicorn.proxies.CachingRentingHistoryProxy;
import com.unicorn.my_little_pony.domain.models.unicorn.proxies.ProtectedUnicornProxy;
import com.unicorn.my_little_pony.domain.models.unicorn.types.FireUnicorn;
import com.unicorn.my_little_pony.domain.models.unicorn.types.IUnicorn;
import com.unicorn.my_little_pony.integration.payment.PaymentAdapter;
import com.unicorn.my_little_pony.integration.payment.PaymentLoggingProxy;
import com.unicorn.my_little_pony.integration.payment.PaymentService;
import com.unicorn.my_little_pony.util.IdGenerator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DemoWeek4Runner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n");
        System.out.println("===========================================================");
        System.out.println("  DEMO TYDZIEŃ 4: Proxy + Flyweight + Facade");
        System.out.println("===========================================================");
        System.out.println();
        demoProxy();
        demoFlyweight();
        demoFacade();
        System.out.println();
        System.out.println("===========================================================");
    }

    private void demoProxy() {
        System.out.println("=========================");
        System.out.println("Proxy");
        System.out.println("=========================");
        System.out.println("Zastosowanie 1: Protection proxy");

        Customer standard = new Customer(IdGenerator.getInstance().nextCustomerId(),
                "Timmy", "timmy@gmail.com", "111111111", false);
        Customer vip = new Customer(IdGenerator.getInstance().nextCustomerId(),
                "Princess Celestia", "celly@gmail.com", "111111111", true);
        IUnicorn blaze = new FireUnicorn("1", "Blaze", "Red", 100);

        System.out.println("Non VIP user try to use unicorn special ability...");
        IUnicorn standardProxy = new ProtectedUnicornProxy(standard, blaze);
        try {
            standardProxy.useSpecialAbility();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("VIP user try to use unicorn special ability...");
        IUnicorn vipProxy = new ProtectedUnicornProxy(vip, blaze);
        try {
            vipProxy.useSpecialAbility();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("-------------------------");
        System.out.println("Zastosowanie 2: Logging proxy");

        PaymentService paymentService = new PaymentAdapter();
        PaymentService securePaymentService = new PaymentLoggingProxy(paymentService);
        System.out.println("Client clicked 'Pay 750$'");
        securePaymentService.pay(750);

        System.out.println("-------------------------");
        System.out.println("Zastosowanie 3: Caching proxy");

        RentingHistoryLoader loader = new DatabaseRentingHistoryLoader();
        CachingRentingHistoryProxy service = new CachingRentingHistoryProxy(loader);
        String unicornId = IdGenerator.getInstance().nextUnicornId();

        System.out.println("First service call (without cache)");
        long start1 = System.currentTimeMillis();
        List<Rental> history1 = service.fetchRentingHistory(unicornId);
        long end1 = System.currentTimeMillis();
        System.out.println("Fetched " + history1.size() + " records in " + (end1 - start1) + " ms.");

        System.out.println("Second service call (with cache)");
        long start2 = System.currentTimeMillis();
        List<Rental> history2 = service.fetchRentingHistory(unicornId);
        long end2 = System.currentTimeMillis();
        System.out.println("Fetched " + history2.size() + " records in " + (end2 - start2) + " ms.");
    }

    private void demoFlyweight() {}

    private void demoFacade() {}
}
