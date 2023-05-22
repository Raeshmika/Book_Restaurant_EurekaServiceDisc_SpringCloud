package com.example.booking.controller;

import com.example.booking.dto.BookingRequestDTO;
import com.example.booking.dto.BookingResponseDTO;
import com.example.booking.dto.TransactionRequestDTO;
import com.example.booking.entities.BookingInfoEntity;
import com.example.booking.exception.RecordNotFoundException;
import com.example.booking.services.BookingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * Booking controller class
 */
@RestController
@RequestMapping(value = "/hotel")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    ModelMapper modelMapper;

    /**
     * End point to book hotel room
     * @param bookingRequestDTO Booking request object
     * @return returns  BookingResponseDTO
     */
    @PostMapping(value = "/booking", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createBooking(@RequestBody BookingRequestDTO bookingRequestDTO) {

        //convert BookingResponseDTO to BookingInfoEntity
        BookingInfoEntity bookingInfoEntity = modelMapper.map(bookingRequestDTO, BookingInfoEntity.class);

        BookingInfoEntity savedBooking = bookingService.bookRooms(bookingInfoEntity);

        BookingResponseDTO bookingResponseDTO = modelMapper.map(savedBooking, BookingResponseDTO.class);
        bookingResponseDTO.setId(savedBooking.getBookingId());
        return new ResponseEntity(bookingResponseDTO, HttpStatus.CREATED);

    }

    /**
     * Finds booking details by booking id
     * @param bookingId booking id
     * @return returns BookingResponseDTO
     */
    @GetMapping(value = "/booking/{bookingId}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getBookingDetails(@PathVariable Integer bookingId) {
        BookingInfoEntity savedBooking = bookingService.getBookingInfoById(bookingId);
        BookingResponseDTO bookingResponseDTO = modelMapper.map(savedBooking, BookingResponseDTO.class);
        bookingResponseDTO.setId(savedBooking.getBookingId());
        return new ResponseEntity(bookingResponseDTO, HttpStatus.OK);
    }

    /**
     * API end point to process transaction for a booking id
     * @param bookingId booking id
     * @param transactionRequestDTO transaction request details
     * @return returns updated Booking response DTO
     */
    @PostMapping(value = "/booking/{bookingId}/transaction", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity paymentForBooking(@PathVariable Integer bookingId,
                                            @Validated @RequestBody TransactionRequestDTO transactionRequestDTO) {
        if (!Objects.equals(bookingId, transactionRequestDTO.getBookingId()))
            throw new RecordNotFoundException("Invalid booking Id");
        BookingInfoEntity bookingInfoEntity = bookingService.payForBooking(bookingId, transactionRequestDTO);
        BookingResponseDTO bookingResponseDTO = modelMapper.map(bookingInfoEntity, BookingResponseDTO.class);
        bookingResponseDTO.setId(bookingInfoEntity.getBookingId());
        return new ResponseEntity(bookingResponseDTO, HttpStatus.CREATED);
    }
}
