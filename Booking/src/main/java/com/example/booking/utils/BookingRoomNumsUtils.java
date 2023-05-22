package com.example.booking.utils;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class BookingRoomNumsUtils {

    /**
     * Generate roomm numbers for a booking
     * @param numOfRooms num of rooms
     * @return returns list of room numbers
     */
    public List<String> assignRoomNumbers(int numOfRooms) {
        return getRandomNumbers(numOfRooms);
    }

    /**
     * generates random numbers between 1-100
     * @param count number of numbers b/w 1-100
     * @return returns list of numbers
     */
    private static List<String> getRandomNumbers(int count){
        Random rand = new Random();
        int upperBound = 100;
        ArrayList<String> numberList = new ArrayList<String>();

        for (int i=0; i<count; i++){
            numberList.add(String.valueOf(rand.nextInt(upperBound)));
        }

        return numberList;
    }
}
