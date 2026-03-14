package com.unicorn.my_little_pony;

import com.unicorn.my_little_pony.domain.decorators.insurance.*;
import com.unicorn.my_little_pony.domain.decorators.support.*;
import com.unicorn.my_little_pony.domain.decorators.unicornAddOns.BasicUnicornRental;
import com.unicorn.my_little_pony.domain.decorators.unicornAddOns.GlitterDecorator;
import com.unicorn.my_little_pony.domain.decorators.unicornAddOns.WingPolishDecorator;
import com.unicorn.my_little_pony.domain.decorators.unicornAddOns.RainbowManeDecorator;

import com.unicorn.my_little_pony.domain.decorators.unicornAddOns.UnicornRental;
import com.unicorn.my_little_pony.domain.models.notification.channels.FacebookChannel;
import com.unicorn.my_little_pony.domain.models.notification.channels.InstagramChannel;
import com.unicorn.my_little_pony.domain.models.notification.channels.SocialChannel;
import com.unicorn.my_little_pony.domain.models.notification.notifiers.BookingNotifier;
import com.unicorn.my_little_pony.domain.models.notification.notifiers.PaymentNotifier;
import com.unicorn.my_little_pony.domain.models.notification.notifiers.SocialNotifier;
import com.unicorn.my_little_pony.domain.models.service.composite.ServiceBundle;
import com.unicorn.my_little_pony.domain.models.service.composite.ServiceItem;
import com.unicorn.my_little_pony.domain.models.unicorn.builders.IceUnicornBuilder;
import com.unicorn.my_little_pony.domain.models.unicorn.builders.LightningUnicornBuilder;
import com.unicorn.my_little_pony.domain.models.unicorn.composite.Herd;
import com.unicorn.my_little_pony.domain.models.unicorn.composite.SingleUnicorn;
import com.unicorn.my_little_pony.domain.models.unicorn.equipment.Equipment;
import com.unicorn.my_little_pony.domain.models.unicorn.equipment.RainbowSaddle;
import com.unicorn.my_little_pony.domain.models.unicorn.equipment.TitaniumArmor;
import com.unicorn.my_little_pony.domain.models.unicorn.factories.FireUnicornFactory;
import com.unicorn.my_little_pony.domain.models.unicorn.factories.UnicornFactory;
import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;
import com.unicorn.my_little_pony.domain.pricing.engines.DailyPricingEngine;
import com.unicorn.my_little_pony.domain.pricing.engines.HourlyPricingEngine;
import com.unicorn.my_little_pony.domain.pricing.engines.PricingEngine;
import com.unicorn.my_little_pony.domain.pricing.plans.PricingPlan;
import com.unicorn.my_little_pony.domain.pricing.plans.StandardPricingPlan;
import com.unicorn.my_little_pony.domain.pricing.plans.VipPricingPlan;
import com.unicorn.my_little_pony.domain.rules.composite.*;
import com.unicorn.my_little_pony.domain.store.UnicornStore;
import com.unicorn.my_little_pony.integration.inventory.StoreAvailabilityAdapter;
import com.unicorn.my_little_pony.integration.inventory.UnicornAvailabilityService;
import com.unicorn.my_little_pony.integration.payment.PaymentAdapter;
import com.unicorn.my_little_pony.integration.payment.PaymentService;
import com.unicorn.my_little_pony.integration.transport.TransportAdapter;
import com.unicorn.my_little_pony.integration.transport.UnicornTransportService;
import com.unicorn.my_little_pony.util.IdGenerator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoWeek3Runner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
//        System.out.println("\n");
//        System.out.println("===========================================================");
//        System.out.println("  DEMO TYDZIEŃ 3: Adapter + Composite + Dekorator + Bridge");
//        System.out.println("===========================================================");
//        System.out.println();
//        demoAdapter();
//        demoBridge();
//        demoComposite();
//        demoDecorator();
//        System.out.println();
//        System.out.println("===========================================================");
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
        System.out.println("Zastosowanie 1: ServiceBundle + pricing");

        ServiceItem unicorn = new ServiceItem("Unicorn rental", 200);
        ServiceItem decoration = new ServiceItem("Decoration", 100);
        ServiceItem trainer = new ServiceItem("Trainer", 150);
        ServiceItem transport = new ServiceItem("Transport", 80);
        ServiceItem birthdayCake = new ServiceItem("Birthday Cake", 220);
        ServiceBundle wedding = new ServiceBundle("Wedding Premium");

        wedding.add(unicorn);
        wedding.add(decoration);
        wedding.add(trainer);
        wedding.add(transport);

        System.out.println(" - Price: " + wedding.getPrice() + " PLN");
        System.out.println(" - Wedding bundle description: " + wedding.getDescription());

        ServiceBundle birthdayParty = new ServiceBundle("Birthday Party");

        birthdayParty.add(unicorn);
        birthdayParty.add(decoration);
        birthdayParty.add(birthdayCake);
        birthdayParty.add(transport);

        System.out.println(" - Price: " + birthdayParty.getPrice() + " PLN");
        System.out.println(" - Bundle description: " + birthdayParty.getDescription());

        System.out.println("-------------------------");
        System.out.println("Zastosowanie 2: Unicorn fleet management");
        System.out.println("Checking if a herd contains enough unicorns for an event reservation");

        Herd herd = new Herd();

        Unicorn unicorn1 = new IceUnicornBuilder()
                .name("Frosty")
                .color("Ice Blue")
                .powerLevel(20)
                .build();

        Unicorn unicorn2 = new LightningUnicornBuilder()
                .name("Thunder")
                .color("Electric Yellow")
                .powerLevel(40)
                .build();

        Unicorn unicorn3 = new LightningUnicornBuilder()
                .name("Lighting")
                .color("Blue")
                .powerLevel(30)
                .build();

        herd.add(new SingleUnicorn(unicorn1));
        herd.add(new SingleUnicorn(unicorn2));
        herd.add(new SingleUnicorn(unicorn3));

        int available = herd.getAvailableCount();

        if (available >= 3) {
            System.out.println("Reservation possible - enough unicorns available");
        }
        System.out.println("-------------------------");
        System.out.println("Zastosowanie 3: Rental validation rules");
        System.out.println("Rentals are only permitted after all rules are met");
        Rule ageRule = new AgeRule(20);
        Rule licenseRule = new LicenseRule(true);
        Rule weatherRule = new WeatherRule(false);

        OrRule rentalRules = new OrRule();

        rentalRules.add(ageRule);
        rentalRules.add(licenseRule);
        rentalRules.add(weatherRule);

        boolean allowed = rentalRules.check();

        System.out.println("Rental allowed: " + allowed);

    }

    private void demoBridge() {
        System.out.println("=========================");
        System.out.println("BRIDGE");
        System.out.println("=========================");
        System.out.println("Zastosowanie 1: Pricing engine + pricing plan");

        PricingEngine hourlyEngine = new HourlyPricingEngine();
        PricingPlan standardHourly = new StandardPricingPlan(hourlyEngine);
        System.out.println("Standard Hourly (5 hrs): $" + standardHourly.calculateFinalPrice(5));

        PricingEngine dailyEngine = new DailyPricingEngine();
        PricingPlan vipDaily = new VipPricingPlan(dailyEngine);
        System.out.println("VIP Daily (3 days): $" + vipDaily.calculateFinalPrice(3));

        PricingPlan vipHourly = new VipPricingPlan(hourlyEngine);
        PricingPlan standardDaily = new StandardPricingPlan(dailyEngine);
        System.out.println("VIP Hourly (5 hrs): $" + vipHourly.calculateFinalPrice(5));
        System.out.println("Standard Daily (3 days): $" + standardDaily.calculateFinalPrice(3));

        System.out.println("-------------------------");
        System.out.println("Zastosowanie 2: Social media channel + event notifier");

        SocialChannel facebookChannel = new FacebookChannel();
        SocialChannel instagramChannel = new InstagramChannel();

        SocialNotifier bookingFacebookNotifier = new BookingNotifier(facebookChannel);
        SocialNotifier paymentInstagramNotifier = new PaymentNotifier(instagramChannel);

        bookingFacebookNotifier.notifyUser("1", "Happy riding");
        paymentInstagramNotifier.notifyUser("1", "$777");

        System.out.println("-------------------------");
        System.out.println("Zastosowanie 3: Unicorn + it's equipment");

        UnicornFactory factory = new FireUnicornFactory();
        Unicorn blaze = factory.createUnicorn(
                IdGenerator.getInstance().nextUnicornId(),
                "Blaze",
                "Black"
        );

        System.out.println("Fresh unicorn spawned: " + blaze.getName());
        System.out.println("Base Power (No Equipment): " + blaze.getTotalPower());
        System.out.println();

        Equipment saddle = new RainbowSaddle();
        blaze.setEquipment(saddle);
        System.out.println("Equipped: " + saddle.getDescription());
        System.out.println("Power boost applied. New Total Power: " + blaze.getTotalPower());
        System.out.println();

        Equipment armor = new TitaniumArmor();
        blaze.setEquipment(armor);
        System.out.println("Swapped Equipment to: " + armor.getDescription());
        System.out.println("Power level updated. New Total Power: " + blaze.getTotalPower());
        System.out.println();
    }

    private void demoDecorator() {
        System.out.println("=========================");
        System.out.println("DECORATOR");
        System.out.println("=========================");
        System.out.println("Przykład 1: Pakiet podstawowy");
        System.out.println("Zastosowanie 1: UnicornRental");

        UnicornRental rental1 = new BasicUnicornRental(200.0);
        rental1 = new GlitterDecorator(rental1);

        System.out.println("AddOns:");
        System.out.println(" - Description: " + rental1.getDescription());
        System.out.println(" - Price: " + rental1.getPrice() + " PLN");
        System.out.println();
        System.out.println("-------------------------");

        System.out.println("Zastosowanie 2: ");
        RentalInsurance insurance1 = new NoInsurance();
        insurance1 = new BasicInsurance(insurance1);

        System.out.println("Insurance:");
        System.out.println(" - Coverage: " + insurance1.getCoverage());
        System.out.println(" - Price: " + insurance1.getCost() + " PLN");
        System.out.println();

        System.out.println("-------------------------");
        System.out.println("Zastosowanie 3: ");
        CustomerSupport support1 = new NoSupport();
        support1 = new StandardSupport(support1);

        System.out.println("Support:");
        System.out.println(" - Coverage: " + support1.getDescription());
        System.out.println(" - Price: " + support1.getCost() + " PLN");
        System.out.println();

        double totalCost1 = rental1.getPrice() + insurance1.getCost() + support1.getCost();
        System.out.println("Overall price: " + totalCost1 + " PLN");
        System.out.println("=========================");

        System.out.println("Przykład 2: Pakiet premium");
        UnicornRental rental2 = new BasicUnicornRental(200.0);
        rental2 = new GlitterDecorator(rental2);
        rental2 = new WingPolishDecorator(rental2);
        rental2 = new RainbowManeDecorator(rental2);

        System.out.println("AddOns:");
        System.out.println(" - Description: " + rental2.getDescription());
        System.out.println(" - Price: " + rental2.getPrice() + " PLN");
        System.out.println();

        // Decorator #2: Ubezpieczenia (wszystkie)
        RentalInsurance insurance2 = new NoInsurance();
        insurance2 = new BasicInsurance(insurance2);
        insurance2 = new ExtendedInsurance(insurance2);
        insurance2 = new ExtremeWeatherCoverage(insurance2);

        System.out.println("Insurance:");
        System.out.println(" - Coverage: " + insurance2.getCoverage());
        System.out.println(" - Price: " + insurance2.getCost() + " PLN");
        System.out.println();

        // Decorator #3: Wsparcie klienta
        CustomerSupport support2 = new NoSupport();
        support2 = new StandardSupport(support2);
        support2 = new PrioritySupport(support2);
        support2 = new TwentyFourHourCaretaker(support2);

        System.out.println("Support:");
        System.out.println(" - Coverage: " + support2.getDescription());
        System.out.println(" - Price: " + support2.getCost() + " PLN");
        System.out.println();

        double totalCost2 = rental2.getPrice() + insurance2.getCost() + support2.getCost();
        System.out.println("Overall price: " + totalCost2 + " PLN");

    }
}
