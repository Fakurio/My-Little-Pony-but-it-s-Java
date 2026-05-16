package com.unicorn.my_little_pony.domain.exceptions;

public class RentalRecordNotFoundException extends RuntimeException {
    public RentalRecordNotFoundException(String rentalId) {
        super("Rental record not found: " + rentalId);
    }
}
