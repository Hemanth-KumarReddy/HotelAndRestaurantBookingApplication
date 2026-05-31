package com.HotelAndRestuarantBooking.repository;


import com.HotelAndRestuarantBooking.entity.RestaurantTableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantTableRepository extends JpaRepository<RestaurantTableEntity,Long> {

}
