package com.unicorn.my_little_pony.domain.models.rental.builders;

import com.unicorn.my_little_pony.domain.models.rental.Rental;
import com.unicorn.my_little_pony.util.IdGenerator;
import com.unicorn.my_little_pony.enums.RentalStatus;
import lombok.Getter;

import java.time.LocalDateTime;

// Tydzień 2, Wzorzec Builder, Zastosowanie 2
//Builder dla obiektów Rental
@Getter
public class RentalBuilder {
    private static final double DEFAULT_BASE_PRICE = 0.0;
    private static final double DEFAULT_FINAL_PRICE = 0.0;

    private String id;
    private String unicornId;
    private String customerId;
    private LocalDateTime start;
    private LocalDateTime end;
    private double basePrice;
    private double finalPrice;
    private boolean termsAccepted;
    private RentalStatus status = RentalStatus.NEW;

    public RentalBuilder() {
        this.id = IdGenerator.getInstance().nextRentalId();
        this.termsAccepted = false;
        this.basePrice = DEFAULT_BASE_PRICE;
        this.finalPrice = DEFAULT_FINAL_PRICE;
    }

    public RentalBuilder unicornId(String unicornId) {
        this.unicornId = unicornId;
        return this;
    }

    public RentalBuilder id(String id) {
        this.id = id;
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

    public RentalBuilder status(RentalStatus status) {
        this.status = status;
        return this;
    }

    public Rental build() {
        if (start == null || end == null) {
            throw new IllegalArgumentException("Start and end dates must be provided");
        }
        if (end.isBefore(start)) {
            throw new IllegalArgumentException("End date cannot be before start date");
        }
        return new Rental(this);
    }
}

// Koniec, Tydzień 2, Wzorzec Builder, Zastosowanie 2
