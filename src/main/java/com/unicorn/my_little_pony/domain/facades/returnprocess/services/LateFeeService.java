package com.unicorn.my_little_pony.domain.facades.returnprocess.services;

// Tydzień 4, Wzorzec Facade
// Serwis naliczający opłaty za spóźnienie.

public class LateFeeService {

    public double calculateFee() {

        double fee = 50;

        System.out.println("Late fee: " + fee);

        return fee;
    }
}
//Koniec Tydzień 4, Wzorzec Facade