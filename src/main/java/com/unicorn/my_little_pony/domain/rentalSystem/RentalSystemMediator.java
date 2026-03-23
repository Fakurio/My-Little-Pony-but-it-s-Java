package com.unicorn.my_little_pony.domain.rentalSystem;

import java.util.ArrayList;
import java.util.List;

// Tydzień 5, Wzorzec Mediator, Zastosowanie 1
// Klasa reprezentująca Mediatora, który pośredniczy w komunikacji między modułami systemu
public class RentalSystemMediator implements SystemMediator {

    private final List<SystemModule> modules = new ArrayList<>();

    @Override
    public void addModule(SystemModule module) {
        if (module == null) {
            throw new IllegalArgumentException("Module cannot be null");
        }
        modules.add(module);
    }

    @Override
    public void sendMessage(String message, SystemModule sender) {
        for (SystemModule module : modules) {
            if (module != sender) {
                module.receive("[" + sender.getName() + "]: " + message);
            }
        }
    }
}
// Koniec, Tydzień 5, Wzorzec Mediator, Zastosowanie 1