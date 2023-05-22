package com.example.booking.dto;

import jakarta.persistence.Column;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Booking request DTO
 */
public class BookingRequestDTO {

    private String fromDate;

    private String toDate;

    private String aadharNumber;

    private int numOfRooms;

    public LocalDate getFromDate() {
        LocalDate dateTime = LocalDate.parse(fromDate, DateTimeFormatter.ISO_DATE);
        return dateTime;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        LocalDate dateTime = LocalDate.parse(toDate, DateTimeFormatter.ISO_DATE);
        return dateTime;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public int getNumOfRooms() {
        return numOfRooms;
    }

    public void setNumOfRooms(int numOfRooms) {
        this.numOfRooms = numOfRooms;
    }
}
