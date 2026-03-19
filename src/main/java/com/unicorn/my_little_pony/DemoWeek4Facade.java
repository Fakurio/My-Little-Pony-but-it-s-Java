package com.unicorn.my_little_pony;

import com.unicorn.my_little_pony.domain.facades.booking.CustomerBookingFacade;
import com.unicorn.my_little_pony.domain.facades.rental.UnicornRentalFacade;
import com.unicorn.my_little_pony.domain.facades.returnprocess.UnicornReturnFacade;
import com.unicorn.my_little_pony.domain.models.unicorn.builders.IceUnicornBuilder;
import com.unicorn.my_little_pony.domain.models.unicorn.builders.LightningUnicornBuilder;
import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;

public class DemoWeek4Facade {

    public static void main(String[] args) throws Exception {
        new DemoWeek4Facade().run();
    }
    public void run(String... args) throws Exception {
        System.out.println("=========================");
        System.out.println("FACADE");
        System.out.println("=========================");

        Unicorn unicorn1 = new IceUnicornBuilder()
                .name("Frosty")
                .color("Blue")
                .powerLevel(20)
                .build();

        Unicorn unicorn2 = new LightningUnicornBuilder()
                .name("Thunder")
                .color("Yellow")
                .powerLevel(35)
                .build();

        // =========================
        System.out.println("Zastosowanie 1: Unicorn rental process");
        UnicornRentalFacade rentalFacade = new UnicornRentalFacade();

        String rentalId1 = rentalFacade.rentUnicorn(unicorn1, "CUSTOMER-1");
        System.out.println("First rental attempt: " + rentalId1);

        String rentalId2 = rentalFacade.rentUnicorn(unicorn1, "CUSTOMER-2");
        System.out.println("Second rental attempt (should fail if already rented): " + rentalId2);

        // =========================
        System.out.println("-------------------------");
        System.out.println("Zastosowanie 2: Unicorn return process");
        UnicornReturnFacade returnFacade = new UnicornReturnFacade();

        String returnResult = returnFacade.returnUnicorn(unicorn1);
        System.out.println("Return result: " + returnResult);

        String rentalId3 = rentalFacade.rentUnicorn(unicorn1, "CUSTOMER-3");
        System.out.println("Third rental attempt after return (should succeed): " + rentalId3);

        // =========================
        System.out.println("-------------------------");
        System.out.println("Zastosowanie 3: Customer booking (offer preparation)");
        CustomerBookingFacade bookingFacade = new CustomerBookingFacade();
        bookingFacade.prepareOffer("CUSTOMER-1", unicorn2);

    }
}