package com.unicorn.my_little_pony.domain.models.unicorn.strategies.unicornSelection;

import com.unicorn.my_little_pony.domain.models.customer.Customer;
import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;

import java.util.Comparator;
import java.util.List;

//Tydzień 6, Wzorzec Strategy, Zastosowanie 2
//Konkretna strategia implementująca dany algorytm wyboru jednorożca
public class CheapestUnicornStrategy implements UnicornSelectionStrategy {

    @Override
    public Unicorn select(List<Unicorn> available, Customer customer) {
        System.out.println("Wybór jednorożca: Algorytm 'Najtańszy dostępny'");
        return available.stream()
                .min(Comparator.comparingDouble(Unicorn::getPrice))
                .orElseThrow(() -> new IllegalStateException("Brak dostępnych jednorożców"));
    }
}
// Koniec, Tydzień 6, Wzorzec Strategy