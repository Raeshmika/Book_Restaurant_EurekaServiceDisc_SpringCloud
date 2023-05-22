package com.example.payment.controller;

import com.example.payment.TransactionDetailsDTO;
import com.example.payment.entities.TransactionDetailsEntity;
import com.example.payment.service.TransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Transaction Controller
 */
@RestController
@RequestMapping(value = "/payment")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Process transaction for a booking id
     * @param transactionDetailsDTO transaction request DTO
     * @return returns transaction id
     */
    @PostMapping(value = "/transaction", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity processPayment(@RequestBody TransactionDetailsDTO transactionDetailsDTO) {
        TransactionDetailsEntity transactionDetailsEntity = modelMapper.map(transactionDetailsDTO, TransactionDetailsEntity.class);
        TransactionDetailsEntity savedTransactionDetailsEntity =  transactionService.makePayment(transactionDetailsEntity);
        return new ResponseEntity(savedTransactionDetailsEntity.getTransactionId(), HttpStatus.CREATED);
    }

    /**
     * Fetch transaction details by transactionId
     * @param transactionId Transaction Id
     * @return returns Transaction details DTO
     */
    @GetMapping(value = "/transaction/{transactionId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getTransactionDetails(@PathVariable Integer transactionId) {
        TransactionDetailsEntity transactionDetailsEntity = transactionService.getTransactionDetails(transactionId);
        if(transactionDetailsEntity == null) {
            return  new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        TransactionDetailsDTO transactionDetailsDTO = modelMapper.map(transactionDetailsEntity, TransactionDetailsDTO.class);
        transactionDetailsDTO.setId(transactionDetailsEntity.getTransactionId());
        return new ResponseEntity(transactionDetailsDTO, HttpStatus.OK);
    }

}
