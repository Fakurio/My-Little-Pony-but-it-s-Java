package com.unicorn.my_little_pony;

import com.unicorn.my_little_pony.database.DatabaseRentingHistoryLoader;
import com.unicorn.my_little_pony.database.RentingHistoryLoader;
import com.unicorn.my_little_pony.domain.facades.booking.CustomerBookingFacade;
import com.unicorn.my_little_pony.domain.facades.rental.UnicornRentalFacade;
import com.unicorn.my_little_pony.domain.facades.returnprocess.UnicornReturnFacade;
import com.unicorn.my_little_pony.domain.models.customer.Customer;
import com.unicorn.my_little_pony.domain.models.rental.Rental;
import com.unicorn.my_little_pony.domain.models.route.RidePlan;
import com.unicorn.my_little_pony.domain.models.route.RideRouteFlyweight;
import com.unicorn.my_little_pony.domain.models.route.RideRouteFlyweightFactory;
import com.unicorn.my_little_pony.domain.models.unicorn.builders.IceUnicornBuilder;
import com.unicorn.my_little_pony.domain.models.unicorn.builders.LightningUnicornBuilder;
import com.unicorn.my_little_pony.domain.models.unicorn.equipment.flyweight.EquipmentFlyweight;
import com.unicorn.my_little_pony.domain.models.unicorn.equipment.flyweight.EquipmentFlyweightFactory;
import com.unicorn.my_little_pony.domain.models.unicorn.equipment.flyweight.RentalEquipmentAssignment;
import com.unicorn.my_little_pony.domain.models.unicorn.flyweight.Unicorn;
import com.unicorn.my_little_pony.domain.models.unicorn.flyweight.UnicornVariantFactory;
import com.unicorn.my_little_pony.domain.models.unicorn.flyweight.UnicornVariantFlyweight;
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
        System.out.println("  DEMO TYDZIEŃ 4: Proxy + Flyweight ");
        System.out.println("===========================================================");
        System.out.println();
        demoProxy();
        demoFlyweight();
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

    private void demoFlyweight() {
        System.out.println("=========================");
        System.out.println("Flyweight");
        System.out.println("=========================");
        System.out.println("Zastosowanie 1: Unicorn Flyweight");
        UnicornVariantFlyweight moonlight =
                UnicornVariantFactory.getUnicornVariant(
                        "Moonlight",
                        "Spiral Horn",
                        "Silver Wings",
                        "Pearl Mane",
                        "Night Glow"
                );

        UnicornVariantFlyweight moonlightAgain =
                UnicornVariantFactory.getUnicornVariant(
                        "Moonlight",
                        "Spiral Horn",
                        "Silver Wings",
                        "Pearl Mane",
                        "Night Glow"
                );

        UnicornVariantFlyweight sparkle =
                UnicornVariantFactory.getUnicornVariant(
                        "Sparkle",
                        "Crystal Horn",
                        "Rainbow Wings",
                        "Pink Mane",
                        "Star Dust"
                );

        Unicorn u1 = new Unicorn("U1", "Luna", moonlight, "Stable A", true);
        Unicorn u2 = new Unicorn("U2", "Nova", moonlightAgain, "Stable B", true);
        Unicorn u3 = new Unicorn("U3", "Pixie", sparkle, "Stable C", false);
        Unicorn u4 = new Unicorn("U3", "Pluto", moonlight, "Stable A", false);

        System.out.println(u1.getInfo());
        System.out.println(u2.getInfo());
        System.out.println(u3.getInfo());
        System.out.println(u4.getInfo());

        System.out.println("Flyweights created: " + UnicornVariantFactory.getFlyweightCount());

        System.out.println("u1 and u2 share flyweight: " + (u1.getType() == u2.getType()));

        System.out.println("-------------------------");
        System.out.println("Zastosowanie 2: Equipment Flyweight");
        EquipmentFlyweight basic1 = EquipmentFlyweightFactory.getEquipmentPackage(
                "BASIC",
                "Forest Basic Set",
                "Standard Saddle",
                "Classic Harness",
                "Green Ribbons",
                "STANDARD"
        );

        EquipmentFlyweight basic2 = EquipmentFlyweightFactory.getEquipmentPackage(
                "BASIC",
                "Forest Basic Set",
                "Standard Saddle",
                "Classic Harness",
                "Green Ribbons",
                "STANDARD"
        );

        EquipmentFlyweight premium1 = EquipmentFlyweightFactory.getEquipmentPackage(
                "PREMIUM",
                "Royal Parade Set",
                "Luxury Saddle",
                "Golden Harness",
                "Crystal Decorations",
                "HIGH"
        );
        IdGenerator gen = IdGenerator.getInstance();

        RentalEquipmentAssignment a1 = new RentalEquipmentAssignment(
                "EA-001", gen.nextRentalId(), basic1, "CLEAN", true
        );

        RentalEquipmentAssignment a2 = new RentalEquipmentAssignment(
                "EA-002", gen.nextRentalId(), basic2, "USED", false
        );

        RentalEquipmentAssignment a3 = new RentalEquipmentAssignment(
                "EA-003", gen.nextRentalId(), premium1, "PERFECT", true
        );

        System.out.println(a1.getInfo());
        System.out.println(a2.getInfo());
        System.out.println(a3.getInfo());

        System.out.println("Equipment flyweights created: "
                + EquipmentFlyweightFactory.getFlyweightCount());

        System.out.println("a1 and a2 share flyweight: "
                + (a1.getEquipmentFlyweight() == a2.getEquipmentFlyweight()));

        System.out.println("-------------------------");
        System.out.println("Zastosowanie 3: RideRoute");
        RideRouteFlyweight shortRoute1 = RideRouteFlyweightFactory.getRideRoute(
                "SHORT",
                "Moonlight Garden",
                "EASY",
                20,
                "FLAT"
        );

        RideRouteFlyweight shortRoute2 = RideRouteFlyweightFactory.getRideRoute(
                "SHORT",
                "Moonlight Garden",
                "EASY",
                20,
                "FLAT"
        );

        RideRouteFlyweight adventureRoute = RideRouteFlyweightFactory.getRideRoute(
                "ADVENTURE",
                "Crystal Mountain Trail",
                "HARD",
                60,
                "MOUNTAIN"
        );

        RidePlan p1 = new RidePlan(
                "RP-001", gen.nextUnicornId(), shortRoute1, "2026-03-20", "Sunny", 2
        );

        RidePlan p2 = new RidePlan(
                "RP-002", gen.nextUnicornId(), shortRoute2, "2026-03-21", "Cloudy", 3
        );

        RidePlan p3 = new RidePlan(
                "RP-003", gen.nextUnicornId(), adventureRoute, "2026-03-22", "Windy", 1
        );

        System.out.println(p1.getInfo());
        System.out.println(p2.getInfo());
        System.out.println(p3.getInfo());

        System.out.println("Ride route flyweights created: "
                + RideRouteFlyweightFactory.getFlyweightCount());

        System.out.println("p1 and p2 share flyweight: "
                + (p1.getRouteFlyweight() == p2.getRouteFlyweight()));


    }

}