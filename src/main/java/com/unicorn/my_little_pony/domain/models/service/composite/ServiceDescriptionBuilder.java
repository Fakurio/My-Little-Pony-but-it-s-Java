package com.unicorn.my_little_pony.domain.models.service.composite;

import java.util.List;
//Tydzien 7,
// Klasa pomocnicza do generowania opisu usług.
// Wydzielona z ServiceBundle zgodnie z zasadą SRP.
public class ServiceDescriptionBuilder {

    public static String build(String name, List<ServiceComponent> items) {

        StringBuilder description = new StringBuilder(name + ": ");

        for (ServiceComponent item : items) {
            description.append(item.getDescription()).append(", ");
        }

        return description.toString();
    }
}
