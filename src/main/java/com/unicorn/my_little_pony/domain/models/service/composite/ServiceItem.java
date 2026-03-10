package com.unicorn.my_little_pony.domain.models.service.composite;

// Tydzień 3, Wzorzec Composite, Zastosowanie 1
//Klasa reprezentująca pojedynczą usługę
public class ServiceItem implements ServiceComponent {

    private final String description;
    private final double price;

    public ServiceItem(String description, double price) {
        this.description = description;
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
//Koniec, Tydzień 3, Wzorzec Composite, Zastosowanie 1