package com.unicorn.my_little_pony.domain.exceptions;

public class VipAccessRequiredException extends RuntimeException {
    public VipAccessRequiredException(String customerName) {
        super("Dostawa teleportacją jest dostępna tylko dla klientów VIP. Klient: " + customerName);
    }
}
