package com.unicorn.my_little_pony.domain.models.customer.interpreter;
import com.unicorn.my_little_pony.domain.models.customer.Customer;
// Tydzień 5, Wzorzec Interpreter, Zastosowanie 1
// Sprawdza czy klient jest VIP
public class VipCustomerExpression implements CustomerExpression {

    @Override
    public boolean interpret(Customer customer) {
        return customer.isVip();
    }
}
// Koniec, Tydzień 5, Wzorzec Interpreter, Zastosowanie 1