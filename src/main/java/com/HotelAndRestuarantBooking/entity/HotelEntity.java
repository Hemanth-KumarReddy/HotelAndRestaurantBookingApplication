package com.HotelAndRestuarantBooking.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

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

    @OneToMany(mappedBy = "hotelEntity",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<BranchEntity> branches;
}
