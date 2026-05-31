package com.HotelAndRestuarantBooking.repository;

import com.HotelAndRestuarantBooking.entity.TableBookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableBookingRepository extends JpaRepository<TableBookingEntity,Long> {
}
