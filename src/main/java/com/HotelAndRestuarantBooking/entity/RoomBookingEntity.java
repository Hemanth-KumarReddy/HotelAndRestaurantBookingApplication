package com.HotelAndRestuarantBooking.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "room_bookings")
public class RoomBookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;

    private Long roomId;

    private Boolean checkIn;

    private Boolean checkOut;

    private String status;
}
