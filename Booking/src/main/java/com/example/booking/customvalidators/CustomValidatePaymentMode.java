package com.example.booking.customvalidators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;


import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Custom Annotation for validating payment mode
 */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = PaymentModeValidator.class)
@Documented
public @interface CustomValidatePaymentMode {
    String message() default "Invalid mode of payment";
    Class<?>[] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
