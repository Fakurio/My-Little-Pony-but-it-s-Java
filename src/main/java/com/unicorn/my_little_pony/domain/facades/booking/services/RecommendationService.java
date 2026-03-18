package com.unicorn.my_little_pony.domain.facades.booking.services;

// Tydzień 4, Wzorzec Facade
// Serwis rekomendujący dodatki do wynajmu.

import java.util.ArrayList;
import java.util.List;

public class RecommendationService {

    public List<String> recommendExtras() {

        List<String> extras = new ArrayList<>();

        extras.add("Decoration");
        extras.add("Trainer");

        System.out.println("Recommended extras: " + extras);

        return extras;
    }
}
//Koniec Tydzień 4, Wzorzec Facade