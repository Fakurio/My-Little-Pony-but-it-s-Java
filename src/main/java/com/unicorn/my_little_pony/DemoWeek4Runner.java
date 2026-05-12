package com.unicorn.my_little_pony;

import com.unicorn.my_little_pony.database.DatabaseRentalHistoryLoader;
import com.unicorn.my_little_pony.database.RentalHistoryLoader;
import com.unicorn.my_little_pony.domain.models.customer.Customer;
import com.unicorn.my_little_pony.domain.models.customer.CustomerContact;
import com.unicorn.my_little_pony.domain.models.customer.CustomerIdentity;
import com.unicorn.my_little_pony.domain.models.rental.Rental;
import com.unicorn.my_little_pony.domain.models.route.RidePlan;
import com.unicorn.my_little_pony.domain.models.route.RideRouteConfig;
import com.unicorn.my_little_pony.domain.models.route.RideRouteFlyweight;
import com.unicorn.my_little_pony.domain.models.route.RideRouteFlyweightFactory;
import com.unicorn.my_little_pony.domain.models.route.RideRouteType;
import com.unicorn.my_little_pony.domain.models.unicorn.equipment.flyweight.EquipmentFlyweight;
import com.unicorn.my_little_pony.domain.models.unicorn.equipment.flyweight.EquipmentFlyweightFactory;
import com.unicorn.my_little_pony.domain.models.unicorn.equipment.flyweight.EquipmentPackageConfig;
import com.unicorn.my_little_pony.domain.models.unicorn.equipment.flyweight.EquipmentPackageType;
import com.unicorn.my_little_pony.domain.models.unicorn.equipment.flyweight.RentalEquipmentAssignment;
import com.unicorn.my_little_pony.domain.models.unicorn.flyweight.Unicorn;
import com.unicorn.my_little_pony.domain.models.unicorn.flyweight.UnicornVariantConfig;
import com.unicorn.my_little_pony.domain.models.unicorn.flyweight.UnicornVariantFactory;
import com.unicorn.my_little_pony.domain.models.unicorn.flyweight.UnicornVariantFlyweight;
import com.unicorn.my_little_pony.domain.models.unicorn.proxies.CachingRentalHistoryProxy;
import com.unicorn.my_little_pony.domain.models.unicorn.proxies.ProtectedUnicornProxy;
import com.unicorn.my_little_pony.domain.models.unicorn.types.FireUnicorn;
import com.unicorn.my_little_pony.domain.models.unicorn.types.UnicornContract;
import com.unicorn.my_little_pony.domain.models.unicorn.types.UnicornIdentity;
import com.unicorn.my_little_pony.integration.payment.external.PaymentAdapter;
import com.unicorn.my_little_pony.integration.payment.external.PaymentLoggingProxy;
import com.unicorn.my_little_pony.integration.payment.external.PaymentService;
import com.unicorn.my_little_pony.util.IdGenerator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DemoWeek4Runner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
//        System.out.println("\n");
//        System.out.println("===========================================================");
//        System.out.println("  DEMO TYDZIEŃ 4: Proxy + Flyweight ");
//        System.out.println("===========================================================");
//        System.out.println();
//        demoProxy();
//        demoFlyweight();
//        System.out.println();
//        System.out.println("===========================================================");
    }

    private void demoProxy() {
        System.out.println("=========================");
        System.out.println("Proxy");
        System.out.println("=========================");
        System.out.println("Zastosowanie 1: Protection proxy");

        Customer standard = new Customer(
                new CustomerIdentity(IdGenerator.getInstance().nextCustomerId(), "Timmy"),
                new CustomerContact("timmy@gmail.com", "111111111"),
                false
        );
        Customer vip = new Customer(
                new CustomerIdentity(IdGenerator.getInstance().nextCustomerId(), "Princess Celestia"),
                new CustomerContact("celly@gmail.com", "111111111"),
                true
        );
        UnicornContract blaze = new FireUnicorn(new UnicornIdentity("1", "Blaze", "Red"), 100);

        System.out.println("Non VIP user try to use unicorn special ability...");
        UnicornContract standardProxy = new ProtectedUnicornProxy(standard, blaze);
        try {
            standardProxy.useSpecialAbility();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("VIP user try to use unicorn special ability...");
        UnicornContract vipProxy = new ProtectedUnicornProxy(vip, blaze);
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

        RentalHistoryLoader loader = new DatabaseRentalHistoryLoader();
        CachingRentalHistoryProxy service = new CachingRentalHistoryProxy(loader);
        String unicornId = IdGenerator.getInstance().nextUnicornId();

        System.out.println("First service call (without cache)");
        long start1 = System.currentTimeMillis();
        List<Rental> history1 = service.fetchRentalHistory(unicornId);
        long end1 = System.currentTimeMillis();
        System.out.println("Fetched " + history1.size() + " records in " + (end1 - start1) + " ms.");

        System.out.println("Second service call (with cache)");
        long start2 = System.currentTimeMillis();
        List<Rental> history2 = service.fetchRentalHistory(unicornId);
        long end2 = System.currentTimeMillis();
        System.out.println("Fetched " + history2.size() + " records in " + (end2 - start2) + " ms.");
    }

    private void demoFlyweight() {
        System.out.println("=========================");
        System.out.println("Flyweight");
        System.out.println("=========================");
        System.out.println("Zastosowanie 1: Unicorn Flyweight");
        UnicornVariantConfig moonlightConfig = UnicornVariantConfig.builder()
                .breed("Moonlight")
                .hornStyle("Spiral Horn")
                .wingType("Silver Wings")
                .maneColor("Pearl Mane")
                .magicAura("Night Glow")
                .build();
        UnicornVariantFlyweight moonlight =
                UnicornVariantFactory.getUnicornVariant(moonlightConfig);

        UnicornVariantFlyweight moonlightAgain =
                UnicornVariantFactory.getUnicornVariant(moonlightConfig);

        UnicornVariantFlyweight sparkle =
                UnicornVariantFactory.getUnicornVariant(
                        UnicornVariantConfig.builder()
                                .breed("Sparkle")
                                .hornStyle("Crystal Horn")
                                .wingType("Rainbow Wings")
                                .maneColor("Pink Mane")
                                .magicAura("Star Dust")
                                .build()
                );

        Unicorn u1 = Unicorn.builder()
                .id("U1")
                .name("Luna")
                .unicornVariant(moonlight)
                .stableLocation("Stable A")
                .available(true)
                .build();
        Unicorn u2 = Unicorn.builder()
                .id("U2")
                .name("Nova")
                .unicornVariant(moonlightAgain)
                .stableLocation("Stable B")
                .available(true)
                .build();
        Unicorn u3 = Unicorn.builder()
                .id("U3")
                .name("Pixie")
                .unicornVariant(sparkle)
                .stableLocation("Stable C")
                .available(false)
                .build();
        Unicorn u4 = Unicorn.builder()
                .id("U3")
                .name("Pluto")
                .unicornVariant(moonlight)
                .stableLocation("Stable A")
                .available(false)
                .build();

        System.out.println(u1.getDescription());
        System.out.println(u2.getDescription());
        System.out.println(u3.getDescription());
        System.out.println(u4.getDescription());

        System.out.println("Flyweights created: " + UnicornVariantFactory.getFlyweightCount());

        System.out.println("u1 and u2 share flyweight: " + (u1.getType() == u2.getType()));

        System.out.println("-------------------------");
        System.out.println("Zastosowanie 2: Equipment Flyweight");
        EquipmentPackageConfig forestBasicSet = EquipmentPackageConfig.builder()
                .packageType(EquipmentPackageType.BASIC)
                .packageName("Forest Basic Set")
                .saddleType("Standard Saddle")
                .harnessType("Classic Harness")
                .decorationStyle("Green Ribbons")
                .safetyLevel("STANDARD")
                .build();
        EquipmentFlyweight basic1 = EquipmentFlyweightFactory.getEquipmentPackage(
                forestBasicSet
        );

        EquipmentFlyweight basic2 = EquipmentFlyweightFactory.getEquipmentPackage(
                forestBasicSet
        );

        EquipmentFlyweight premium1 = EquipmentFlyweightFactory.getEquipmentPackage(
                EquipmentPackageConfig.builder()
                        .packageType(EquipmentPackageType.PREMIUM)
                        .packageName("Royal Parade Set")
                        .saddleType("Luxury Saddle")
                        .harnessType("Golden Harness")
                        .decorationStyle("Crystal Decorations")
                        .safetyLevel("HIGH")
                        .build()
        );
        IdGenerator gen = IdGenerator.getInstance();

        RentalEquipmentAssignment a1 = RentalEquipmentAssignment.builder()
                .assignmentId("EA-001")
                .rentalId(gen.nextRentalId())
                .equipmentFlyweight(basic1)
                .conditionStatus("CLEAN")
                .currentlyAssigned(true)
                .build();

        RentalEquipmentAssignment a2 = RentalEquipmentAssignment.builder()
                .assignmentId("EA-002")
                .rentalId(gen.nextRentalId())
                .equipmentFlyweight(basic2)
                .conditionStatus("USED")
                .currentlyAssigned(false)
                .build();

        RentalEquipmentAssignment a3 = RentalEquipmentAssignment.builder()
                .assignmentId("EA-003")
                .rentalId(gen.nextRentalId())
                .equipmentFlyweight(premium1)
                .conditionStatus("PERFECT")
                .currentlyAssigned(true)
                .build();

        System.out.println(a1.getDescription());
        System.out.println(a2.getDescription());
        System.out.println(a3.getDescription());

        System.out.println("Equipment flyweights created: "
                + EquipmentFlyweightFactory.getFlyweightCount());

        System.out.println("a1 and a2 share flyweight: "
                + (a1.getEquipmentFlyweight() == a2.getEquipmentFlyweight()));

        System.out.println("-------------------------");
        System.out.println("Zastosowanie 3: RideRoute");
        RideRouteConfig moonlightGardenRoute = RideRouteConfig.builder()
                .routeType(RideRouteType.SHORT)
                .routeName("Moonlight Garden")
                .difficultyLevel("EASY")
                .defaultDurationMinutes(20)
                .terrainType("FLAT")
                .build();
        RideRouteFlyweight shortRoute1 = RideRouteFlyweightFactory.getRideRoute(
                moonlightGardenRoute
        );

        RideRouteFlyweight shortRoute2 = RideRouteFlyweightFactory.getRideRoute(
                moonlightGardenRoute
        );

        RideRouteFlyweight adventureRoute = RideRouteFlyweightFactory.getRideRoute(
                RideRouteConfig.builder()
                        .routeType(RideRouteType.ADVENTURE)
                        .routeName("Crystal Mountain Trail")
                        .difficultyLevel("HARD")
                        .defaultDurationMinutes(60)
                        .terrainType("MOUNTAIN")
                        .build()
        );

        RidePlan p1 = RidePlan.builder()
                .rideId("RP-001")
                .unicornId(gen.nextUnicornId())
                .routeFlyweight(shortRoute1)
                .rideDate("2026-03-20")
                .weather("Sunny")
                .participantCount(2)
                .build();

        RidePlan p2 = RidePlan.builder()
                .rideId("RP-002")
                .unicornId(gen.nextUnicornId())
                .routeFlyweight(shortRoute2)
                .rideDate("2026-03-21")
                .weather("Cloudy")
                .participantCount(3)
                .build();

        RidePlan p3 = RidePlan.builder()
                .rideId("RP-003")
                .unicornId(gen.nextUnicornId())
                .routeFlyweight(adventureRoute)
                .rideDate("2026-03-22")
                .weather("Windy")
                .participantCount(1)
                .build();

        System.out.println(p1.getDescription());
        System.out.println(p2.getDescription());
        System.out.println(p3.getDescription());

        System.out.println("Ride route flyweights created: "
                + RideRouteFlyweightFactory.getFlyweightCount());

        System.out.println("p1 and p2 share flyweight: "
                + (p1.getRouteFlyweight() == p2.getRouteFlyweight()));


    }

}
