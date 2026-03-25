package com.HotelAndRestuarantBooking.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "hotels")
public class HotelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;
}
