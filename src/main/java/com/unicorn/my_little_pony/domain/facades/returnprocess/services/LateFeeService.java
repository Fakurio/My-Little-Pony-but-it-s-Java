package com.unicorn.my_little_pony.domain.facades.returnprocess.services;

// Tydzień 4, Wzorzec Facade
// Serwis naliczający opłaty za spóźnienie.

public class LateFeeService {
    private static final double STANDARD_LATE_FEE = 50.0;

    public double calculateFee() {
        double fee = STANDARD_LATE_FEE;
        System.out.println("Late fee: " + fee);
        return fee;
    }
}
//Koniec Tydzień 4, Wzorzec Facade
