package com.unicorn.my_little_pony.domain.models.customer.interpreter;
import com.unicorn.my_little_pony.domain.models.customer.Customer;

// Tydzień 5, Wzorzec Interpreter, Zastosowanie 1
// Łączy dwa warunki logiczne OR

public class OrCustomerExpression implements CustomerExpression {

    private CustomerExpression left;
    private CustomerExpression right;

    public OrCustomerExpression(CustomerExpression left, CustomerExpression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean interpret(Customer customer) {
        return left.interpret(customer) || right.interpret(customer);
    }
}
// Koniec, Tydzień 5, Wzorzec Interpreter, Zastosowanie 1
