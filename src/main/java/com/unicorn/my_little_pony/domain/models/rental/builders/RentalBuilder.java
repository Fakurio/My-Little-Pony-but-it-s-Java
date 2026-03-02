package com.unicorn.my_little_pony.domain.models.rental.builders;

import com.unicorn.my_little_pony.domain.models.rental.Rental;
import com.unicorn.my_little_pony.util.IdGenerator;

import java.time.LocalDateTime;

// Tydzień 2, Wzorzec Builder
//Builder dla obiektów Rental

public class RentalBuilder {
    private String id;
    private String unicornId;
    private String customerId;
    private LocalDateTime start;
    private LocalDateTime end;
    private double basePrice;
    private double finalPrice;
    private boolean termsAccepted;

    public RentalBuilder() {
        this.id = IdGenerator.getInstance().nextRentalId();
        this.termsAccepted = false;
        this.basePrice = 0;
        this.finalPrice = 0;
    }

    public RentalBuilder unicornId(String unicornId) {
        this.unicornId = unicornId;
        return this;
    }

    public RentalBuilder customerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    public RentalBuilder start(LocalDateTime start) {
        this.start = start;
        return this;
    }

    public RentalBuilder end(LocalDateTime end) {
        this.end = end;
        return this;
    }

    public RentalBuilder basePrice(double basePrice) {
        this.basePrice = basePrice;
        return this;
    }

    public RentalBuilder finalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
        return this;
    }

    public RentalBuilder termsAccepted(boolean termsAccepted) {
        this.termsAccepted = termsAccepted;
        return this;
    }

    public Rental build() {
        if (start == null || end == null) {
            throw new IllegalArgumentException("Start and end dates must be provided");
        }
        if (end.isBefore(start)) {
            throw new IllegalArgumentException("End date cannot be before start date");
        }
        return new Rental(id, unicornId, customerId, start, end, basePrice, finalPrice, termsAccepted);
    }
}

// Koniec Tydzień 2, Wzorzec Builder