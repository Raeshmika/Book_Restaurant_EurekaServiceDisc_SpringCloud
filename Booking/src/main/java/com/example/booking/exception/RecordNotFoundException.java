package com.example.booking.exception;

/**
 * Record not found Exception
 */
public class RecordNotFoundException extends RuntimeException {

    public RecordNotFoundException(String message) {
        super(message);
    }

}
