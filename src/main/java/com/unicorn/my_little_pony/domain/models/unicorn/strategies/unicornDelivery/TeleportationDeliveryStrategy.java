package com.unicorn.my_little_pony.domain.models.unicorn.strategies.unicornDelivery;

import com.unicorn.my_little_pony.domain.exceptions.VipAccessRequiredException;
import com.unicorn.my_little_pony.domain.models.customer.Customer;
import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;

//Tydzień 6, Wzorzec Strategy, Zastosowanie 3
//Konkretna strategia implementująca dany algorytm dostawy jednorożca
public class TeleportationDeliveryStrategy implements DeliveryStrategy {

    @Override
    public void deliver(Unicorn unicorn, Customer customer) {
        //Tydzień 7, SRP
        // Nowa zasada dla teleportacji -> sprawdzenie czy klient jest Vipem
        // Dotyczy ona tylko strategii teloportacji i nie wymaga ingerencji w inne klasy strategii dostawy
        if (!customer.isVip()) {
            throw new VipAccessRequiredException(customer.getName());
        }
        System.out.println("Dostawa: " + unicorn.getName() + " został przeteleportowany "
                + "pod drzwi klienta " + customer.getName() + ".");
        // Koniec, Tydzień 7, SRP
    }
}
// Koniec, Tydzień 6, Wzorzec Strategy
