package com.unicorn.my_little_pony.domain.models.customer.interpreter;
import com.unicorn.my_little_pony.domain.models.customer.Customer;

// Tydzień 5, Wzorzec Interpreter, Zastosowanie 1
// Sprawdza czy klient posiada email

public class HasEmailExpression implements CustomerExpression {

    @Override
    public boolean interpret(Customer customer) {
        return customer.getEmail() != null && !customer.getEmail().isEmpty();
    }
}
// Koniec, Tydzień 5, Wzorzec Interpreter, Zastosowanie 1