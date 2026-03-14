package com.unicorn.my_little_pony.domain.models.unicorn.proxies;

import com.unicorn.my_little_pony.domain.models.customer.Customer;
import com.unicorn.my_little_pony.domain.models.unicorn.types.IUnicorn;
import lombok.AllArgsConstructor;

// Tydzień 4, Wzorzec Proxy, Zastosowanie 1
// Proxy ochronne dające dostęp do umiejętności specjalnej jednorożca tylko vipom
@AllArgsConstructor
public class ProtectedUnicornProxy implements IUnicorn {
    private final Customer customer;
    private final IUnicorn unicorn;

    @Override
    public void useSpecialAbility() throws Exception {
        if (!customer.isVip()) {
            throw new Exception("Access Denied: " + customer.getName() +
                    " must be a VIP to use " + unicorn.getName() + "'s special ability!");
        }
        unicorn.useSpecialAbility();
    }

    @Override
    public String getName() {
        return unicorn.getName();
    }
}
// Koniec, Tydzień 4, Wzorzec Proxy