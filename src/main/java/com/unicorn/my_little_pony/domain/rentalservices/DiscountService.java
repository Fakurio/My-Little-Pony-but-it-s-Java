package com.unicorn.my_little_pony.domain.rentalservices;

// Tydzień 5, Wzorzec Mediator, Zastosowanie 3
// DiscountService to usługa odpowiedzialna za zarządzanie zniżkami i promocjami w systemie wynajmu jednorożców.
public class DiscountService extends AbstractRentalService {

    public DiscountService(ServiceMediator mediator) {
        super(mediator, "DiscountService");
    }

    @Override
    public void receive(String message) {
        System.out.println(name + " received message " + message);
    }
}
// Koniec, Tydzień 5, Wzorzec Mediator, Zastosowanie 3