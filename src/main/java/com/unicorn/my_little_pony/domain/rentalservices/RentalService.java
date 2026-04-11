package com.unicorn.my_little_pony.domain.rentalservices;

// Tydzień 5, Wzorzec Mediator, Zastosowanie 3
// Interfejs reprezentujący usługę wynajmu, która będzie komunikować się z innymi usługami za pośrednictwem mediatora. Każda usługa
// implementująca ten interfejs będzie miała możliwość wysyłania i odbierania wiadomości,
// co pozwoli na luźne powiązanie między różnymi komponentami systemu wynajmu jednorożców.
public interface RentalService {
    String getName();
    void send(String message);
    void receive(String message);
}
// Koniec, Tydzień 5, Wzorzec Mediator, Zastosowanie 3