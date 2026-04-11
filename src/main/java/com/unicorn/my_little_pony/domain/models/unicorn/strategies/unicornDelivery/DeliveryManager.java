package com.unicorn.my_little_pony.domain.models.unicorn.strategies.unicornDelivery;

import com.unicorn.my_little_pony.domain.models.customer.Customer;
import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;

//Tydzień 6, Wzorzec Strategy, Zastosowanie 3
//Klasa kontekstu z metodą która wywołuje danę strategie
public class DeliveryManager {
    public void arrangeDelivery(DeliveryStrategy strategy, Unicorn unicorn, Customer customer) {
        strategy.deliver(unicorn, customer);
    }
}
// Koniec, Tydzień 6, Wzorzec Strategy