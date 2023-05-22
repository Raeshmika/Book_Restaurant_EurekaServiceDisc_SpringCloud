package com.example.booking.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Booking information entity
 */
@Entity
@Table(name = "booking")
public class BookingInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookingId ;

    @Column(nullable = true)
    private LocalDate fromDate;

    @Column(nullable = true)
    private LocalDate toDate;

    @Column(length = 500, nullable = true)
    private String aadharNumber;

    @Column
    private int numOfRooms;

    @ElementCollection
    @Column(length =500, nullable = true)
    private List<String> roomNumbers;

    @Column(columnDefinition = "Integer default 1000", nullable = false)
    private int roomPrice ;

    @Column(columnDefinition = "Integer default 0", nullable = true)
    private int transactionId ;

    @Column(nullable = true)
    private LocalDateTime bookedOn;

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
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

    public List<String> getRoomNumbers() {
        return roomNumbers;
    }

    public void setRoomNumbers(List<String> roomNumbers) {
        this.roomNumbers = roomNumbers;
    }

    public int getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(int roomPrice) {
        this.roomPrice = roomPrice;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public LocalDateTime getBookedOn() {
        return bookedOn;
    }

    public void setBookedOn(LocalDateTime bookedOn) {
        this.bookedOn = bookedOn;
    }
}
