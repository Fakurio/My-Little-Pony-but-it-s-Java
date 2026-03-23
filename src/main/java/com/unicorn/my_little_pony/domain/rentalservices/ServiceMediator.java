package com.unicorn.my_little_pony.domain.rentalservices;

// Tydzień 5, Wzorzec Mediator, Zastosowanie 3
// Mediator, który zarządza komunikacją między różnymi usługami wynajmu, takimi jak usługa wyceny, usługa ubezpieczenia i usługa rabatów. Każda z tych usług może wysyłać wiadomości do innych usług za pośrednictwem mediatora, co pozwala na luźne powiązanie między nimi.
public interface ServiceMediator {
    void addService(RentalService service);
    void sendMessage(String message, RentalService sender);
}
// Koniec, Tydzień 5, Wzorzec Mediator, Zastosowanie 3