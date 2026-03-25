package com.HotelAndRestuarantBooking.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "restaurantTables")
public class RestaurantTableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String tableNumber;

    private Integer capacity;

    private String status;

    private Long branchId;
}
