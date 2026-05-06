package com.unicorn.my_little_pony;

import com.unicorn.my_little_pony.domain.facades.booking.CustomerBookingFacade;
import com.unicorn.my_little_pony.domain.facades.rental.UnicornRentalFacade;
import com.unicorn.my_little_pony.domain.facades.returnprocess.UnicornReturnFacade;
import com.unicorn.my_little_pony.domain.models.unicorn.builders.IceUnicornBuilder;
import com.unicorn.my_little_pony.domain.models.unicorn.builders.LightningUnicornBuilder;
import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;

public class DemoWeek4Facade {
    private static final int ICE_UNICORN_POWER_LEVEL = 20;
    private static final int LIGHTNING_UNICORN_POWER_LEVEL = 35;

    public static void main(String[] args) throws Exception {
        new DemoWeek4Facade().run();
    }
    public void run(String... args) throws Exception {
        printHeader();
        Unicorn iceUnicorn = createIceUnicorn();
        Unicorn lightningUnicorn = createLightningUnicorn();
        UnicornRentalFacade rentalFacade = new UnicornRentalFacade();
        runRentalDemo(rentalFacade, iceUnicorn);
        runReturnDemo(rentalFacade, iceUnicorn);
        runBookingDemo(lightningUnicorn);
    }

    private void printHeader() {
        System.out.println("=========================");
        System.out.println("FACADE");
        System.out.println("=========================");
    }

    private Unicorn createIceUnicorn() {
        return new IceUnicornBuilder()
                .name("Frosty")
                .color("Blue")
                .powerLevel(ICE_UNICORN_POWER_LEVEL)
                .build();
    }

    private Unicorn createLightningUnicorn() {
        return new LightningUnicornBuilder()
                .name("Thunder")
                .color("Yellow")
                .powerLevel(LIGHTNING_UNICORN_POWER_LEVEL)
                .build();
    }

    private void runRentalDemo(UnicornRentalFacade rentalFacade, Unicorn unicorn) {
        System.out.println("Zastosowanie 1: Unicorn rental process");
        String firstRentalId = rentalFacade.rentUnicorn(unicorn, "CUSTOMER-1");
        System.out.println("First rental attempt: " + firstRentalId);
        String secondRentalId = rentalFacade.rentUnicorn(unicorn, "CUSTOMER-2");
        System.out.println("Second rental attempt (should fail if already rented): " + secondRentalId);
    }

    private void runReturnDemo(UnicornRentalFacade rentalFacade, Unicorn unicorn) {
        System.out.println("-------------------------");
        System.out.println("Zastosowanie 2: Unicorn return process");
        UnicornReturnFacade returnFacade = new UnicornReturnFacade();
        String returnResult = returnFacade.returnUnicorn(unicorn);
        System.out.println("Return result: " + returnResult);
        String thirdRentalId = rentalFacade.rentUnicorn(unicorn, "CUSTOMER-3");
        System.out.println("Third rental attempt after return (should succeed): " + thirdRentalId);
    }

    private void runBookingDemo(Unicorn unicorn) {
        System.out.println("-------------------------");
        System.out.println("Zastosowanie 3: Customer booking (offer preparation)");
        CustomerBookingFacade bookingFacade = new CustomerBookingFacade();
        bookingFacade.prepareOffer("CUSTOMER-1", unicorn);
    }
}
