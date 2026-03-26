package com.unicorn.my_little_pony.domain.models.rental.mementos;

//Tydzień 5, Wzorzec Memento, Zastosowanie 2
// Klasa sesji umożliwiająca dostęp do szkicu formularza wypożyczenia
public class SessionCache {
    private RentalApplication.RentalDraftMemento savedDraft;

    public void save(RentalApplication.RentalDraftMemento draft) {
        this.savedDraft = draft;
    }

    public RentalApplication.RentalDraftMemento getDraft() {
        return savedDraft;
    }
}
// Koniec, Tydzień 5, Wzorzec Memento