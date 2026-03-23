package com.unicorn.my_little_pony.domain.rentalservices;

// Tydzień 5, Wzorzec Mediator, Zastosowanie 3
// Kolejny współpracownik w systemie wynajmu jednorożców, odpowiedzialny za zarządzanie cenami i kalkulacjami kosztów wynajmu.
public class PricingService extends AbstractRentalService {

    public PricingService(ServiceMediator mediator) {
        super(mediator, "PricingService");
    }

    @Override
    public void receive(String message) {
        System.out.println(name + " received message " + message);
    }
}
// Koniec, Tydzień 5, Wzorzec Mediator, Zastosowanie 3