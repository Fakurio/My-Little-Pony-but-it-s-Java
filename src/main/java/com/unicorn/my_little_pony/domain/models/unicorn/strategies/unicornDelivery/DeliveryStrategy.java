package com.unicorn.my_little_pony.domain.models.unicorn.strategies.unicornDelivery;

import com.unicorn.my_little_pony.domain.models.customer.Customer;
import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;

//Tydzień 6, Wzorzec Strategy, Zastosowanie 3
//Interfejs dla konkretnych algorytmów dostawy jednorożca
public interface DeliveryStrategy {
    void deliver(Unicorn unicorn, Customer customer);
}
// Koniec, Tydzień 6, Wzorzec Strategy