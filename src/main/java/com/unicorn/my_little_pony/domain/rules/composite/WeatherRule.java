package com.unicorn.my_little_pony.domain.rules.composite;

// Tydzień 3, Wzorzec Composite, Zastosowanie 3
// Pojedyncza reguła walidacji wynajmu
public class WeatherRule implements Rule {

    private final boolean goodWeather;

    public WeatherRule(boolean goodWeather) {
        this.goodWeather = goodWeather;
    }

    @Override
    public boolean check() {
        return goodWeather;
    }
}
//Koniec, Tydzień 3, Wzorzec Composite, Zastosowanie 3