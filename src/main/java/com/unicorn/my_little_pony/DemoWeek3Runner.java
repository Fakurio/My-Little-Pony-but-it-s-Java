package com.unicorn.my_little_pony;

import com.unicorn.my_little_pony.domain.models.unicorn.builders.IceUnicornBuilder;
import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;
import com.unicorn.my_little_pony.domain.store.UnicornStore;
import com.unicorn.my_little_pony.integration.inventory.StoreAvailabilityAdapter;
import com.unicorn.my_little_pony.integration.inventory.UnicornAvailabilityService;
import com.unicorn.my_little_pony.integration.payment.PaymentAdapter;
import com.unicorn.my_little_pony.integration.payment.PaymentService;
import com.unicorn.my_little_pony.integration.transport.TransportAdapter;
import com.unicorn.my_little_pony.integration.transport.UnicornTransportService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoWeek3Runner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n");
        System.out.println("===========================================================");
        System.out.println("  DEMO TYDZIEŃ 3: Adapter + Composite + Dekorator + Bridge");
        System.out.println("===========================================================");
        System.out.println();
        demoAdapter();
        demoBridge();
        demoComposite();
        demoDecorator();
        System.out.println();
        System.out.println("===========================================================");
    }

    private void demoAdapter() {
        System.out.println("=========================");
        System.out.println("ADAPTER");
        System.out.println("=========================");
        System.out.println("Zastosowanie 1: Payment Adapter");

        double amount = 149.99;
        System.out.println("Client wants to pay rental price: " + amount);

        PaymentService paymentService = new PaymentAdapter();
        paymentService.pay(amount);
        System.out.println();
        System.out.println("-------------------------");

        System.out.println("Zastosowanie 2: Transport Adapter");
        Unicorn transportUnicorn = new IceUnicornBuilder()
                .name("Moonlight")
                .color("Silver")
                .powerLevel(15)
                .build();
        UnicornStore.getInstance().add(transportUnicorn);
        String unicornId = transportUnicorn.getId();
        String unicornName = "Moonlight";
        String destination = "Lublin, Plac Litewski";

        UnicornTransportService transportService = new TransportAdapter();
        transportService.scheduleTransport(unicornId, unicornName, destination);
        System.out.println();
        
        // Próba zamówienia transportu dla niedostępnego jednorożca
        System.out.println("Trying to schedule transport for a non-existent unicorn...");
        transportService.scheduleTransport("INVALID_ID", "Ghost", "Nowhere");
        
        System.out.println("-------------------------");
        System.out.println("Zastosowanie 3: Availability Adapter");
        Unicorn iceUnicorn = new IceUnicornBuilder()
                .name("Frosty")
                .color("Ice Blue")
                .powerLevel(20)
                .build();
        UnicornStore.getInstance().add(iceUnicorn);

        String unicornId1 = "U1";
        String unicornId2 = "U9";

        UnicornAvailabilityService availabilityService = new StoreAvailabilityAdapter();
        System.out.println("Available? " + availabilityService.isAvailable(unicornId1));

        System.out.println();
        System.out.println("Available? " + availabilityService.isAvailable(unicornId2));
    }

    private void demoComposite() {
        System.out.println("=========================");
        System.out.println("COMPOSITE");
        System.out.println("=========================");
        System.out.println("Zastosowanie 1: ");

        System.out.println("-------------------------");
        System.out.println("Zastosowanie 2: ");

        System.out.println("-------------------------");
        System.out.println("Zastosowanie 3: ");

    }

    private void demoBridge() {
        System.out.println("=========================");
        System.out.println("BRIDGE");
        System.out.println("=========================");
        System.out.println("Zastosowanie 1: ");

        System.out.println("-------------------------");
        System.out.println("Zastosowanie 2: ");

        System.out.println("-------------------------");
        System.out.println("Zastosowanie 3: ");

    }

    private void demoDecorator() {
        System.out.println("=========================");
        System.out.println("DECORATOR");
        System.out.println("=========================");
        System.out.println("Zastosowanie 1: ");

        System.out.println("-------------------------");
        System.out.println("Zastosowanie 2: ");

        System.out.println("-------------------------");
        System.out.println("Zastosowanie 3: ");

    }
}
