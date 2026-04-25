package com.unicorn.my_little_pony.domain.exceptions;

public class UnicornNotAvailableException extends RuntimeException {
    public UnicornNotAvailableException(String unicornName) {
        super("Unicorn not available: " + unicornName);
    }
}
