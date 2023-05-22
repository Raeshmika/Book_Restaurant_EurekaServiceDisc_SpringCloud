package com.example.payment.service;

import com.example.payment.dao.TransactionRepository;
import com.example.payment.entities.TransactionDetailsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

/**
 * Transaction service
 */
@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;


    /**
     * Process transaction for a booking id
     * @param transactionDetailsEntity transaction details entity
     * @return returns transaction details entity
     */
    public TransactionDetailsEntity makePayment(TransactionDetailsEntity transactionDetailsEntity) {
        return transactionRepository.save(transactionDetailsEntity);
    }

    /**
     * Fetch transaction details by id
     * @param transactionId transaction id
     * @return returns transaction details entity
     */
    public TransactionDetailsEntity getTransactionDetails(Integer transactionId) {
        Optional<TransactionDetailsEntity> transactionDetailsEntity =  transactionRepository.findById(transactionId);
        return transactionDetailsEntity.orElse(null);
    }
}
