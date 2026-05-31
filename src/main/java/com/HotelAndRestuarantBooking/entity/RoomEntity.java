package com.HotelAndRestuarantBooking.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "rooms")
public class RoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String roomNumber;

    @Column(nullable = false)
    private String roomType;

    private Double price;

    private String status;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private BranchEntity branchEntity;

    @OneToMany(mappedBy = "roomEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RoomBookingEntity> roomBookingEntityList;
}
