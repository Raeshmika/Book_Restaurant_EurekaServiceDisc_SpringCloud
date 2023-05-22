package com.example.booking.dao;

import com.example.booking.entities.BookingInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingDao extends JpaRepository<BookingInfoEntity, Integer> {

}
