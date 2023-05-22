package com.example.booking.services;

import com.example.booking.dao.BookingDao;
import com.example.booking.dto.TransactionRequestDTO;
import com.example.booking.entities.BookingInfoEntity;
import com.example.booking.exception.RecordNotFoundException;
import com.example.booking.utils.BookingRoomNumsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Optional;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class BookingService {

    @Autowired
    private BookingDao bookingDao;

    @Autowired
    BookingRoomNumsUtils bookingRoomNumsUtils;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${paymentApp.url}")
    private String paymentUrl;

    /**
     * Method to book rooms
     * @param bookingInfoEntity accepts boooking info entity
     * @return returns updated booking info entity
     */
    public BookingInfoEntity bookRooms(BookingInfoEntity bookingInfoEntity) {
        int numOfDays = (int) DAYS.between(bookingInfoEntity.getFromDate(), bookingInfoEntity.getToDate());
        bookingInfoEntity.setBookedOn(LocalDateTime.now());
        bookingInfoEntity.setRoomPrice(1000*bookingInfoEntity.getNumOfRooms()*numOfDays);
        bookingInfoEntity.setRoomNumbers(bookingRoomNumsUtils.assignRoomNumbers(bookingInfoEntity.getNumOfRooms()));
        BookingInfoEntity savedBookingInfo = bookingDao.save(bookingInfoEntity);
        return savedBookingInfo;
    }

    /**
     * get booking information by booking id
     * @param bookingId booking id
     * @return returns booking info entity
     */
    public BookingInfoEntity getBookingInfoById(Integer bookingId) {
        Optional<BookingInfoEntity> bookingInfoEntity = bookingDao.findById(bookingId);
        return bookingInfoEntity .orElseThrow(() -> new RecordNotFoundException("No record found for booking Id "+bookingId));
    }

    /**
     * Process transaction for a booking by caling payment service
     * @param bookingId booking id
     * @param transactionRequestDTO transaction request DTO
     * @return returns updated booking info entity
     */
    public BookingInfoEntity payForBooking(Integer bookingId, TransactionRequestDTO transactionRequestDTO) {
        Optional<BookingInfoEntity> bookingInfoEntity = bookingDao.findById(bookingId);
        if (!bookingInfoEntity.isPresent()) {
            throw new RecordNotFoundException("No record found for booking Id" + bookingId);
        }
        ResponseEntity<Integer> transactionId = restTemplate.postForEntity(paymentUrl, transactionRequestDTO, Integer.class);
        BookingInfoEntity entity = bookingInfoEntity.get();
        if (null != transactionId.getBody()) {
            entity.setTransactionId(transactionId.getBody());
            entity = bookingDao.save(entity);
        }
        return entity;
    }
}
