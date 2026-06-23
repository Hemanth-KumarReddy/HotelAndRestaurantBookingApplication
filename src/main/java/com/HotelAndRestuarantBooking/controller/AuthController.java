package com.HotelAndRestuarantBooking.controller;

import com.HotelAndRestuarantBooking.apiResponse.ApiResponse;
import com.HotelAndRestuarantBooking.constants.AuthConstants;
import com.HotelAndRestuarantBooking.dto.AdminLoginDto;
import com.HotelAndRestuarantBooking.dto.StaffRegisterRequestDto;
import com.HotelAndRestuarantBooking.service.impl.AuthServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthServiceImpl authServiceImpl;

    @PostMapping("/register-user")
    public ResponseEntity<ApiResponse<String>> registerUser(@Valid @RequestBody StaffRegisterRequestDto customerRegisterRequestDto){

        String message = authServiceImpl.staffRegistration(customerRegisterRequestDto);

        ApiResponse<String> apiResponse = new ApiResponse<>(true, AuthConstants.SUCCESS_STAFF_REGISTERED, "Registered Successfully!!");

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);

    }
    @PostMapping("/admin/login")
//    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<ApiResponse<AdminLoginDto>> adminLogin( @RequestBody AdminLoginDto adminLoginDto){

        AdminLoginDto adminLoginDtoCon = authServiceImpl.adminLogin(adminLoginDto);

        ApiResponse<AdminLoginDto> apiResponse = new ApiResponse<>(true,AuthConstants.SUCCESS_LOGIN_MSG,adminLoginDtoCon);

        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }
}
