package com.example.booking.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class BookingResponseDTO {

    private Integer id;

    private LocalDate fromDate;

    private LocalDate toDate;

    private String aadharNumber;

    private int numOfRooms;

    private int roomPrice;

    private int transactionId;

    private LocalDateTime bookedOn;

    private List<String> roomNumbers;

    public String getRoomNumbers() {
        StringBuilder builder = new StringBuilder();
        for(String i: roomNumbers) {
            builder.append(i);
            builder.append(",");
        }
        builder.delete(builder.length() - 1, builder.length());
        return builder.toString();
    }

    public void setRoomNumbers(List<String> roomNumbers) {
        this.roomNumbers = roomNumbers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
