package com.unicorn.my_little_pony.domain.models.unicorn.memento;

import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;

import java.util.HashMap;
import java.util.Map;

//Tydzień 5, Wzorzec Memento, Zastosowanie 1
// Menedżer przechowujący nazwane zestawy ekwipunku jednorożca
public class LoadoutManager {
    private final Map<String, Unicorn.UnicornMemento> favoriteLoadouts = new HashMap<>();

    public void saveFavorite(String loadoutName, Unicorn.UnicornMemento memento) {
        favoriteLoadouts.put(loadoutName, memento);
    }

    public Unicorn.UnicornMemento getFavorite(String loadoutName) {
        return favoriteLoadouts.get(loadoutName);
    }
}
// Koniec, Tydzień 5, Wzorzec Memento