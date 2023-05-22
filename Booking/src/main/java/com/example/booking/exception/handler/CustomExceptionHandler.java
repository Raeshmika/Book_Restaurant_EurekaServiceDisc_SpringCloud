package com.example.booking.exception.handler;


import com.example.booking.exception.InvalidPaymentModeException;
import com.example.booking.exception.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Exception Handler
 */
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    private String INVALID_BOOKING_ID = "Invalid Booking Id";

    private String INVALID_PAYMENT_MODE= "Invalid mode of payment";

    @ExceptionHandler({RecordNotFoundException.class})
    public final ResponseEntity handleRecordNotFoundException(RecordNotFoundException exception, WebRequest req) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("message", INVALID_BOOKING_ID);
        body.put("statusCode",  HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({InvalidPaymentModeException.class})
    public final ResponseEntity handleInvalidPaymentMode(InvalidPaymentModeException exception, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("message", INVALID_PAYMENT_MODE);
        body.put("statusCode",  HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity(body, HttpStatus.BAD_REQUEST);
    }
}
