package com.unicorn.my_little_pony.aspect.vipaccess;

import com.unicorn.my_little_pony.domain.exceptions.VipAccessRequiredException;
import com.unicorn.my_little_pony.domain.models.customer.Customer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

// Tydzień 11, Programowanie Aspektowe, Zastosowanie 2
// Aspekt kontroli dostępu VIP – przechwytuje wywołania każdej metody oznaczonej adnotacją
// @VipOnly i sprawdza czy aktualny klient (z VipContext) ma status VIP.
@Aspect
@Component
public class VipAccessAspect {

    @Before("call(* *(..)) && @annotation(VipOnly)")
    public void checkVipAccess(JoinPoint jp) {
        Customer customer = VipContext.get();

        if (customer == null) {
            throw new VipAccessRequiredException("nieznany (brak klienta w kontekście)");
        }

        System.out.println("[AOP - VipAccess] Sprawdzanie dostępu VIP dla klienta: "
                + customer.getName() + " → metoda: " + jp.getSignature().toShortString());

        if (!customer.isVip()) {
            throw new VipAccessRequiredException(customer.getName());
        }

        System.out.println("[AOP - VipAccess] Dostęp przyznany dla klienta VIP: "
                + customer.getName());
    }
}
// Koniec, Tydzień 11, Programowanie Aspektowe, Zastosowanie 2
