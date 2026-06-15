package com.HotelAndRestuarantBooking.service;

import com.HotelAndRestuarantBooking.dto.AdminLoginDto;
import com.HotelAndRestuarantBooking.dto.StaffRegisterRequestDto;

public interface AuthService {
    String staffRegistration(StaffRegisterRequestDto staffRegisterRequestDto) throws Exception;
    AdminLoginDto adminLogin(AdminLoginDto adminLoginDto) throws Exception;
}
