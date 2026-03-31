package com.HotelAndRestuarantBooking.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private HotelEntity hotelEntity;

    @OneToMany(mappedBy = "branchEntity",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<RoomEntity> roomEntityList;

    @OneToMany(mappedBy = "branchEntity",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<RestaurantTableEntity> restaurantTableEntityList;
}
