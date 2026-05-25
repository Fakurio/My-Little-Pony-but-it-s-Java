package com.unicorn.my_little_pony.aspect.vipaccess;

import com.unicorn.my_little_pony.domain.models.customer.Customer;

// Tydzień 11, Programowanie Aspektowe, Zastosowanie 2
// VipContext jest uchwytem ThreadLocal przechowującym aktualnie obsługiwanego klienta.
// Aspekt VipAccessAspect odczytuje klienta z tego kontekstu,
// aby sprawdzić czy ma on status VIP zanim wywoła metodę oznaczoną @VipOnly.
public final class VipContext {

    private static final ThreadLocal<Customer> CURRENT_CUSTOMER = new ThreadLocal<>();

    private VipContext() {}

    public static void set(Customer customer) {
        CURRENT_CUSTOMER.set(customer);
    }

    public static Customer get() {
        return CURRENT_CUSTOMER.get();
    }

    public static void clear() {
        CURRENT_CUSTOMER.remove();
    }
}
// Koniec, Tydzień 11, Programowanie Aspektowe, Zastosowanie 2
