package com.unicorn.my_little_pony.domain.models.customer.interpreter;

// Tydzień 5, Wzorzec Interpreter, Zastosowanie 1
// Interfejs interpretujący warunki dotyczące klienta

import com.unicorn.my_little_pony.domain.models.customer.Customer;

public interface CustomerExpression {
    boolean interpret(Customer customer);
}
// Koniec, Tydzień 5, Wzorzec Interpreter, Zastosowanie 1