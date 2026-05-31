package com.HotelAndRestuarantBooking.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

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

    @ManyToOne
    @JoinColumn(name="branch_id")
    private BranchEntity branchEntity;

    @OneToMany(mappedBy = "restaurantTableEntity",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<TableBookingEntity> tableBookingEntityList;
}
