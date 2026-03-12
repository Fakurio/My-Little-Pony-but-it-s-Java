package com.unicorn.my_little_pony;

import com.unicorn.my_little_pony.domain.models.customer.Customer;
import com.unicorn.my_little_pony.domain.models.customer.builders.CustomerBuilder;
import com.unicorn.my_little_pony.domain.models.notification.NotificationFactory;
import com.unicorn.my_little_pony.domain.models.notification.types.Notification;
import com.unicorn.my_little_pony.domain.models.rental.Rental;
import com.unicorn.my_little_pony.domain.models.rental.builders.RentalBuilder;
import com.unicorn.my_little_pony.domain.models.unicorn.builders.IceUnicornBuilder;
import com.unicorn.my_little_pony.domain.models.unicorn.builders.LightningUnicornBuilder;
import com.unicorn.my_little_pony.domain.models.unicorn.factories.FireUnicornFactory;
import com.unicorn.my_little_pony.domain.models.unicorn.factories.UnicornFactory;
import com.unicorn.my_little_pony.domain.models.unicorn.factories.WaterUnicornFactory;
import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;
import com.unicorn.my_little_pony.domain.pricing.PricingConfig;
import com.unicorn.my_little_pony.domain.pricing.policies.PricingFactory;
import com.unicorn.my_little_pony.domain.pricing.policies.StandardPricingFactory;
import com.unicorn.my_little_pony.domain.pricing.policies.VipPricingFactory;
import com.unicorn.my_little_pony.domain.pricing.policies.cancellation.CancellationPolicy;
import com.unicorn.my_little_pony.domain.pricing.policies.pricing.PricingPolicy;
import com.unicorn.my_little_pony.domain.store.UnicornStore;
import com.unicorn.my_little_pony.enums.NotificationType;
import com.unicorn.my_little_pony.util.IdGenerator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DemoWeek2Runner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
//        System.out.println("\n");
//        System.out.println("===========================================================");
//        System.out.println("  DEMO TYDZIEŃ 2: Singleton + Factory + Builder + Prototype");
//        System.out.println("===========================================================");
//        System.out.println();
//
//        demoSingleton();
//        demoFactory();
//        demoBuilder();
//        demoPrototype();
//
//        System.out.println();
//        System.out.println("===========================================================");
    }

    private void demoSingleton() {
        System.out.println("=========================");
        System.out.println("SINGLETON");
        System.out.println("=========================");

        System.out.println("Zastosowanie 1: PricingConfig (Eager Initialization)");
        PricingConfig config1 = PricingConfig.getInstance();
        PricingConfig config2 = PricingConfig.getInstance();
        System.out.println("PricingConfig instancja 1 hash: " + config1.hashCode());
        System.out.println("PricingConfig instancja 2 hash: " + config2.hashCode());
        System.out.println("Czy ta sama instancja? " + (config1 == config2));
        System.out.println("Base price per hour: " + config1.getBasePricePerHour());
        System.out.println("-------------------------");

        System.out.println("Zastosowanie 2: IdGenerator (Thread-safe synchronized)");
        IdGenerator gen1 = IdGenerator.getInstance();
        IdGenerator gen2 = IdGenerator.getInstance();
        System.out.println("IdGenerator instancja 1 hash: " + gen1.hashCode());
        System.out.println("IdGenerator instancja 2 hash: " + gen2.hashCode());
        System.out.println("Czy ta sama instancja? " + (gen1 == gen2));
        System.out.println("Wygenerowane ID:");
        System.out.println(" - Unicorn ID: " + gen1.nextUnicornId());
        System.out.println(" - Customer ID: " + gen2.nextCustomerId());
        System.out.println(" - Rental ID: " + gen1.nextRentalId());
        System.out.println("-------------------------");

        System.out.println("Zastosowanie 3: UnicornStore (Bill Pugh)");
        UnicornStore store1 = UnicornStore.getInstance();
        UnicornStore store2 = UnicornStore.getInstance();
        System.out.println("UnicornStore instancja 1 hash: " + store1.hashCode());
        System.out.println("UnicornStore instancja 2 hash: " + store2.hashCode());
        System.out.println("Czy ta sama instancja? " + (store1 == store2));

    }

    private void demoFactory() {
        System.out.println();
        System.out.println("=========================");
        System.out.println("FACTORY");
        System.out.println("=========================");

        System.out.println("Zastosowanie 1: NotificationFactory (Simple Factory)");
        Notification smsNotif = NotificationFactory.createNotification(NotificationType.SMS);
        Notification emailNotif = NotificationFactory.createNotification(NotificationType.EMAIL);
        Notification consoleNotif = NotificationFactory.createNotification(NotificationType.CONSOLE);

        System.out.println("Utworzono powiadomienia:");
        smsNotif.send("Testowa wiadomość SMS");
        emailNotif.send("Testowa wiadomość Email");
        consoleNotif.send("Testowa wiadomość Console");
        System.out.println("-------------------------");

        System.out.println("Zastosowanie 2: UnicornFactory (Factory Method)");
        UnicornFactory fireFactory = new FireUnicornFactory();
        UnicornFactory waterFactory = new WaterUnicornFactory();

        Unicorn fireUnicorn = fireFactory.createUnicorn(
                IdGenerator.getInstance().nextUnicornId(),
                "Blaze",
                "Red"
        );
        Unicorn waterUnicorn = waterFactory.createUnicorn(
                IdGenerator.getInstance().nextUnicornId(),
                "Aqua",
                "Blue"
        );

        System.out.println("Utworzono jednorożce za pomocą Factory Method:");
        System.out.println(" - " + fireUnicorn);
        fireUnicorn.useSpecialAbility();
        System.out.println(" - " + waterUnicorn);
        waterUnicorn.useSpecialAbility();
        System.out.println("-------------------------");

        System.out.println("Zastosowanie 3: PricingFactory (Abstract Factory)");
        PricingFactory standardFactory = new StandardPricingFactory();
        PricingFactory vipFactory = new VipPricingFactory();

        PricingPolicy standardPricing = standardFactory.creaetPricingPolicy();
        CancellationPolicy standardCancellation = standardFactory.creaetCancellationPolicy();

        PricingPolicy vipPricing = vipFactory.creaetPricingPolicy();
        CancellationPolicy vipCancellation = vipFactory.creaetCancellationPolicy();

        System.out.println("Utworzono polityki cenowe za pomocą Abstract Factory:");
        System.out.println(" - Standard Pricing: " + standardPricing.getClass().getSimpleName());
        System.out.println(" - Standard Cancellation: " + standardCancellation.getClass().getSimpleName());
        System.out.println(" - VIP Pricing: " + vipPricing.getClass().getSimpleName());
        System.out.println(" - VIP Cancellation: " + vipCancellation.getClass().getSimpleName());
    }

    private void demoBuilder() {
        System.out.println();
        System.out.println("=========================");
        System.out.println("BUILDER");
        System.out.println("=========================");

        System.out.println("Zastosowanie 1: CustomerBuilder");
        Customer customer = new CustomerBuilder()
                .name("Anna Kowalska")
                .email("anna.kowalska@example.com")
                .phone("+48 123 456 789")
                .vip(true)
                .build();

        System.out.println("Utworzono klienta za pomocą Builder:");
        System.out.println(" - " + customer);
        System.out.println("-------------------------");

        System.out.println("Zastosowanie 2: RentalBuilder");
        Rental rental = new RentalBuilder()
                .unicornId("U1")
                .customerId(customer.getId())
                .start(LocalDateTime.now())
                .end(LocalDateTime.now().plusDays(3))
                .basePrice(2331.0)
                .finalPrice(2100.0)
                .termsAccepted(true)
                .build();

        System.out.println("Utworzono wypożyczenie za pomocą Builder:");
        System.out.println(" - " + rental);
        System.out.println("-------------------------");


        System.out.println("Zastosowanie 3: AbstractUnicornBuilder (Ice & Lightning)");
        Unicorn iceUnicorn = new IceUnicornBuilder()
                .name("Frosty")
                .color("Ice Blue")
                .powerLevel(20)
                .build();

        Unicorn lightningUnicorn = new LightningUnicornBuilder()
                .name("Thunder")
                .color("Electric Yellow")
                .powerLevel(40)
                .build();

        System.out.println("Utworzono jednorożce za pomocą Builder:");
        System.out.println(" - " + iceUnicorn);
        iceUnicorn.useSpecialAbility();
        System.out.println(" - " + lightningUnicorn);
        lightningUnicorn.useSpecialAbility();

        // Dodajemy do store
        UnicornStore.getInstance().add(iceUnicorn);
        UnicornStore.getInstance().add(lightningUnicorn);
    }

    private void demoPrototype() {
        System.out.println();
        System.out.println("=========================");
        System.out.println("PROTOTYPE");
        System.out.println("=========================");

        System.out.println("Zastosowanie 1: Customer.clone()");
        Customer originalCustomer = new CustomerBuilder()
                .name("Jan Nowak")
                .email("jan.nowak@example.com")
                .phone("+48 987 654 321")
                .vip(false)
                .build();

        Customer clonedCustomer = originalCustomer.clone();

        System.out.println("Oryginalny klient:");
        System.out.println("  " + originalCustomer);
        System.out.println("Sklonowany klient:");
        System.out.println("  " + clonedCustomer);
        System.out.println("Czy różne obiekty? " + (originalCustomer != clonedCustomer));
        System.out.println("Czy różne ID? " + (!originalCustomer.getId().equals(clonedCustomer.getId())));
        System.out.println("-------------------------");

        System.out.println("Zastosowanie 2: Rental.clone()");
        Rental originalRental = new RentalBuilder()
                .unicornId("U5")
                .customerId(originalCustomer.getId())
                .start(LocalDateTime.now())
                .end(LocalDateTime.now().plusDays(5))
                .basePrice(3885.0)
                .finalPrice(3500.0)
                .termsAccepted(true)
                .build();

        Rental clonedRental = originalRental.clone();

        System.out.println("Oryginalne wypożyczenie:");
        System.out.println(" - " + originalRental);
        System.out.println("Sklonowane wypożyczenie:");
        System.out.println(" - " + clonedRental);
        System.out.println("Czy różne obiekty? " + (originalRental != clonedRental));
        System.out.println("Czy różne ID? " + (!originalRental.getId().equals(clonedRental.getId())));
        System.out.println("-------------------------");


        System.out.println("Zastosowanie 3: Unicorn.clone() (Fire, Ice, Lightning)");

        UnicornFactory fireFactory = new FireUnicornFactory();
        Unicorn originalFire = fireFactory.createUnicorn(
                IdGenerator.getInstance().nextUnicornId(),
                "Inferno",
                "Dark Red"
        );

        Unicorn originalIce = new IceUnicornBuilder()
                .name("Crystal")
                .color("White")
                .powerLevel(18)
                .build();

        Unicorn originalLightning = new LightningUnicornBuilder()
                .name("Bolt")
                .color("Golden")
                .powerLevel(38)
                .build();

        Unicorn clonedFire = originalFire.clone();
        Unicorn clonedIce = originalIce.clone();
        Unicorn clonedLightning = originalLightning.clone();

        System.out.println("Sklonowano jednorożce:");
        System.out.println(" - Fire Unicorn:");
        System.out.println("   Oryginalny:  " + originalFire);
        System.out.println("   Sklonowany:  " + clonedFire);
        System.out.println("   Różne obiekty? " + (originalFire != clonedFire));
        System.out.println(" - Ice Unicorn:");
        System.out.println("   Oryginalny:  " + originalIce);
        System.out.println("   Sklonowany:  " + clonedIce);
        System.out.println("   Różne obiekty? " + (originalIce != clonedIce));
        System.out.println(" - Lightning Unicorn:");
        System.out.println("   Oryginalny:  " + originalLightning);
        System.out.println("   Sklonowany:  " + clonedLightning);
        System.out.println("   Różne obiekty? " + (originalLightning != clonedLightning));
        System.out.println();
    }
}
