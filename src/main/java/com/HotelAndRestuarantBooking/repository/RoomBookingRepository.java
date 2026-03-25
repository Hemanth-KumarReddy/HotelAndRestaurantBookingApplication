package com.HotelAndRestuarantBooking.repository;

import com.HotelAndRestuarantBooking.entity.RoomBookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomBookingRepository extends JpaRepository<RoomBookingEntity,Long> {
}
