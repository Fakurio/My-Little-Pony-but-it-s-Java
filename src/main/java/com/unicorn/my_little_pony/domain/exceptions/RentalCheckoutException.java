package com.unicorn.my_little_pony.domain.exceptions;

public class RentalCheckoutException extends RuntimeException {
    public RentalCheckoutException(String message, Throwable cause) {
        super("Error during checkout: " + message, cause);
    }
}
