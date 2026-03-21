package com.unicorn.my_little_pony.domain.models.rental.mementos;

import lombok.Setter;

//Tydzień 5, Wzorzec Memento, Zastosowanie 2
// Klasa formularza wypożyczenia jednorożca oraz wew. klasa przechowująca szkic formularza
@Setter
public class RentalApplication {
    private String unicornId;
    private String customerId;

    public RentalDraftMemento saveDraft() {
        System.out.println("Saving rental application draft...");
        return new RentalDraftMemento(this.unicornId, this.customerId);
    }

    public void restoreDraft(RentalDraftMemento memento) {
        System.out.println("Restoring rental application draft...");
        this.unicornId = memento.unicornId;
        this.customerId = memento.customerId;
    }

    @Override
    public String toString() {
        return "RentalApplication [unicornId=" + unicornId + ", customerId=" + customerId + "]";
    }

    public static class RentalDraftMemento {
        private final String unicornId;
        private final String customerId;

        private RentalDraftMemento(String unicornId, String customerId) {
            this.unicornId = unicornId;
            this.customerId = customerId;
        }
    }
}
