package com.unicorn.my_little_pony.domain.models.unicorn.factories;

import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;

// Tydzień 2, Wzorzec Factory method
// Jedna metoda do tworzenia jednorożców z implementacją oddelegowaną do
// konkretnych fabryk
public abstract class UnicornFactory {
    public abstract Unicorn createUnicorn(String id, String name, String color);
}
// Koniec, Tydzień 2, Wzorzec Factory method
