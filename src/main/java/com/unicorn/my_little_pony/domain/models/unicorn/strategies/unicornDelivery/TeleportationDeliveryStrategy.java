package com.unicorn.my_little_pony.domain.models.unicorn.strategies.unicornDelivery;

import com.unicorn.my_little_pony.domain.models.customer.Customer;
import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;

//Tydzień 6, Wzorzec Strategy, Zastosowanie 3
//Konkretna strategia implementująca dany algorytm dostawy jednorożca
public class TeleportationDeliveryStrategy implements DeliveryStrategy {

    @Override
    public void deliver(Unicorn unicorn, Customer customer) {
        System.out.println("Dostawa: " + unicorn.getName() + " został przeteleportowany "
                + "pod drzwi klienta " + customer.getName() + ".");
    }
}
// Koniec, Tydzień 6, Wzorzec Strategy
