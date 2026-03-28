package com.unicorn.my_little_pony.domain.models.unicorn.strategies.unicornSelection;

import com.unicorn.my_little_pony.domain.models.customer.Customer;
import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;

import java.util.List;

//Tydzień 6, Wzorzec Strategy, Zastosowanie 2
//Klasa kontekstu z metodą która wywołuje danę strategie
public class UnicornMatcher {
    public Unicorn findBestUnicorn(UnicornSelectionStrategy strategy, List<Unicorn> available, Customer customer) {
        return strategy.select(available, customer);
    }
}
// Koniec, Tydzień 6, Wzorzec Strategy