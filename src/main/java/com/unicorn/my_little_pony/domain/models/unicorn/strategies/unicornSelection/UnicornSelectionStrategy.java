package com.unicorn.my_little_pony.domain.models.unicorn.strategies.unicornSelection;

import com.unicorn.my_little_pony.domain.models.customer.Customer;
import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;

import java.util.List;

//Tydzień 6, Wzorzec Strategy, Zastosowanie 2
//Interfejs dla konkretnych algorytmów wyboru jednorożca
public interface UnicornSelectionStrategy {
    Unicorn select(List<Unicorn> available, Customer customer);
}
// Koniec, Tydzień 6, Wzorzec Strategy