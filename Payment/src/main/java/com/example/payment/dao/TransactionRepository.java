package com.example.payment.dao;

import com.example.payment.entities.TransactionDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionDetailsEntity,Integer> {
}
