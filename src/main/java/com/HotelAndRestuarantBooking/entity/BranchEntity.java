package com.HotelAndRestuarantBooking.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Branches")
public class BranchEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    private String city;

    private String state;

    private Long hotelId;
}
