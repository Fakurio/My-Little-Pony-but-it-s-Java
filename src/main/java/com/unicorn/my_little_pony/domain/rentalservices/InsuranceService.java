package com.unicorn.my_little_pony.domain.rentalservices;

// Tydzień 5, Wzorzec Mediator, Zastosowanie 3
// Interfejs kolejnego serwisu, który będzie komunikował się z innymi usługami za pośrednictwem mediatora. InsuranceService może być
// odpowiedzialna za zarządzanie ubezpieczeniami w systemie wynajmu jednorożców.
public class InsuranceService extends AbstractRentalService {

    public InsuranceService(ServiceMediator mediator) {
        super(mediator, "InsuranceService");
    }

    @Override
    public void receive(String message) {
        System.out.println(name + " received message " + message);
    }
}
// Koniec, Tydzień 5, Wzorzec Mediator, Zastosowanie 3