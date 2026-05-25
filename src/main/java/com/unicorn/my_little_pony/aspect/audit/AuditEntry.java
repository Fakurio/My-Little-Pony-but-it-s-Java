package com.unicorn.my_little_pony.aspect.audit;

import java.time.LocalDateTime;

// Tydzień 11, Programowanie Aspektowe, Zastosowanie 3
// Rekord reprezentujący pojedynczy wpis w dzienniku audytu.
public record AuditEntry(LocalDateTime timestamp, String unicornName, String transitionName) {

    @Override
    public String toString() {
        return "[AUDIT] " + timestamp
                + " | Jednorożec: " + unicornName
                + " | Przejście: " + transitionName;
    }
}
// Koniec, Tydzień 11, Programowanie Aspektowe, Zastosowanie 3
