package com.HotelAndRestuarantBooking.service.impl;

import com.HotelAndRestuarantBooking.constants.AuthConstants;
import com.HotelAndRestuarantBooking.dto.StaffRegisterRequestDto;
import com.HotelAndRestuarantBooking.entity.StaffEntity;
import com.HotelAndRestuarantBooking.exception.UserAlreadyExistsException;
import com.HotelAndRestuarantBooking.repository.StaffRepository;
import com.HotelAndRestuarantBooking.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    public PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private StaffRepository staffRepository;
    @Override
    public String staffRegistration(StaffRegisterRequestDto staffRegisterRequestDto) {

        Optional<StaffEntity> staffEntityOptional = staffRepository.findByEmail(staffRegisterRequestDto.getEmail());

        if(staffEntityOptional.isPresent()) {

            throw new UserAlreadyExistsException(AuthConstants.ERROR_USER_ALREADY_EXISTS);
        } else {

            StaffEntity staffEntity = new StaffEntity();

            staffEntity.setEmail(staffRegisterRequestDto.getEmail());
            staffEntity.setName(staffRegisterRequestDto.getName());
            staffEntity.setPhone(staffRegisterRequestDto.getPhone());
            staffEntity.setRole(staffRegisterRequestDto.getRole());
            staffEntity.setStatus("P");
            staffEntity.setHotelId(staffRegisterRequestDto.getHotelId());
            staffEntity.setPassword(passwordEncoder.encode(staffRegisterRequestDto.getPassword()));

            staffEntity = staffRepository.save(staffEntity);

            return AuthConstants.SUCCESS_STAFF_REGISTERED;
        }
    }
}
