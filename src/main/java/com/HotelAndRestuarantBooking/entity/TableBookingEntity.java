package com.HotelAndRestuarantBooking.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "table_bookings")
public class TableBookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long tableId;

    private LocalDateTime bookingTime;

    private String status;

    private Long roomBookingId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customerEntity;

    @ManyToOne
    @JoinColumn(name="restuarantTable_id")
    private RestaurantTableEntity restaurantTableEntity;

}
