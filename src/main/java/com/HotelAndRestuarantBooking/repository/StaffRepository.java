package com.HotelAndRestuarantBooking.repository;

import com.HotelAndRestuarantBooking.entity.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StaffRepository extends JpaRepository<StaffEntity,Long> {

    Optional<StaffEntity> findByEmail(String email);
}
