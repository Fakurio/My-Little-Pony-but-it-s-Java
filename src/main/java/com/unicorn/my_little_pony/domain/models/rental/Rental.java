package com.unicorn.my_little_pony.domain.models.rental;

import com.unicorn.my_little_pony.domain.models.rental.builders.RentalBuilder;
import lombok.Getter;

import java.time.LocalDateTime;

// Tydzień 2, Wzorzec Prototype, Zastosowanie 2
// Klasa implementuje interfejs Cloneable, co pozwala na tworzenie kopii istniejących obiektów.

@Getter
public class Rental implements Cloneable{
    private final String id;
    private final String unicornId;
    private final String customerId;
    private final LocalDateTime start;
    private final LocalDateTime end;
    private final double basePrice;
    private final double finalPrice;
    private final boolean termsAccepted;

    public Rental(String id, String unicornId, String customerId, LocalDateTime start, LocalDateTime end,
                  double basePrice, double finalPrice, boolean termsAccepted) {
        if (end.isBefore(start)) {
            throw new IllegalArgumentException("End date cannot be before start date!");
        }
        this.id = id;
        this.unicornId = unicornId;
        this.customerId = customerId;
        this.start = start;
        this.end = end;
        this.basePrice = basePrice;
        this.finalPrice = finalPrice;
        this.termsAccepted = termsAccepted;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "id='" + id + '\'' +
                ", unicornId='" + unicornId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", basePrice=" + basePrice +
                ", finalPrice=" + finalPrice +
                ", termsAccepted=" + termsAccepted +
                '}';
    }
    @Override
    public Rental clone() {
        return new RentalBuilder()
                .unicornId(this.unicornId)
                .customerId(this.customerId)
                .start(this.start)
                .end(this.end)
                .basePrice(this.basePrice)
                .finalPrice(this.finalPrice)
                .termsAccepted(this.termsAccepted)
                .build();
    }
}
// Koniec, Tydzień 2, Wzorzec Prototype, Zastosowanie 2