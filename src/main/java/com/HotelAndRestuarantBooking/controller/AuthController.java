package com.HotelAndRestuarantBooking.controller;

import com.HotelAndRestuarantBooking.dto.StaffRegisterRequestDto;
import com.HotelAndRestuarantBooking.service.impl.AuthServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthServiceImpl authServiceImpl;

    @PostMapping("/register-user")
    public void registerUser(@Valid @RequestBody StaffRegisterRequestDto customerRegisterRequestDto){



    }
}