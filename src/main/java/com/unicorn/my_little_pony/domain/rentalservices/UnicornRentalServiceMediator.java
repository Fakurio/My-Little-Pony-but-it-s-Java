package com.unicorn.my_little_pony.domain.rentalservices;

import java.util.ArrayList;
import java.util.List;

// Tydzień 5, Wzorzec Mediator, Zastosowanie 3
// Konkretny mediator, który zarządza komunikacją między różnymi usługami wynajmu jednorożców. Odpowiada za przekazywanie
// wiadomości między usługami i utrzymanie listy zarejestrowanych usług.
public class UnicornRentalServiceMediator implements ServiceMediator {

    private final List<RentalService> services = new ArrayList<>();

    @Override
    public void addService(RentalService service) {
        if (service == null) {
            throw new IllegalArgumentException("Service cannot be null");
        }
        services.add(service);
    }

    @Override
    public void sendMessage(String message, RentalService sender) {
        for (RentalService service : services) {
            if (service != sender) {
                service.receive("[" + sender.getName() + "]: " + message);
            }
        }
    }
}
// Koniec, Tydzień 5, Wzorzec Mediator, Zastosowanie 3