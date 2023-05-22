package com.example.booking.customvalidators;


import com.example.booking.exception.InvalidPaymentModeException;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * Payment mode validator class
 */
public class PaymentModeValidator implements ConstraintValidator<CustomValidatePaymentMode, String> {

    private final static String UPI_MODE="UPI";

    private final static String CARD_MODE="CARD";

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(!s.equals(UPI_MODE) && !s.equals(CARD_MODE))
            throw new InvalidPaymentModeException("Invalid mode of payment");
        return true;
    }
}
