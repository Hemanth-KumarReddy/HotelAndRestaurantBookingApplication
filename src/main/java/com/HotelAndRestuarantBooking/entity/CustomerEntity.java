package com.HotelAndRestuarantBooking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "customers")
public class CustomerEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String password;

    @Column(updatable = false)
    private LocalDateTime createdAt =LocalDateTime.now();

    @Column(nullable = false)
    private String Status;

    @OneToMany(mappedBy = "customerEntity",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<RoomBookingEntity> roomBookings;

    @OneToMany(mappedBy = "customerEntity",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<TableBookingEntity> tableBookings;
}
