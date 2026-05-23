package com.unicorn.my_little_pony.aspect.audit;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

// Tydzień 11, Programowanie Aspektowe, Zastosowanie 3
// Klasa przechowująca wszystkie wpisy audytu zebrane przez StateTransitionAuditAspect.
@Component
public class AuditLog {

    private final List<AuditEntry> entries = new CopyOnWriteArrayList<>();

    @Getter
    private static AuditLog instance;

    private AuditLog() {
        instance = this;
    }

    public void add(AuditEntry entry) {
        entries.add(entry);
    }


    public void printAll() {
        if (entries.isEmpty()) {
            System.out.println("[AuditLog] Brak wpisów.");
            return;
        }
        entries.forEach(System.out::println);
    }
}
// Koniec, Tydzień 11, Programowanie Aspektowe (AOP), Zastosowanie 3
