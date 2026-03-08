package com.unicorn.my_little_pony.integration.transport;

//Tydzień 3, Wzorzec Adapter 2 (przez kompozycję)
//Klasa reprezentująca zewnętrzny system transportowy, który nie jest zgodny z interfejsem UnicornTransportService
public class ExternalTransportSystem {
    public void bookRide(String animalDescription, String address) {
        System.out.println("External transport system: booked ride for " + animalDescription + " to " + address);
    }
}
//Koniec, Tydzień 3, Wzorzec Adapter 2