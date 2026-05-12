package com.unicorn.my_little_pony.domain.exceptions;

public class TransportUnavailableException extends RuntimeException {
    public TransportUnavailableException(String unicornId) {
        super("Cannot schedule transport for unavailable unicorn: " + unicornId);
    }
}
