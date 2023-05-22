package com.example.booking.exception;

public class InvalidPaymentModeException extends RuntimeException {

    public InvalidPaymentModeException(String message) {
        super(message);
    }
}
