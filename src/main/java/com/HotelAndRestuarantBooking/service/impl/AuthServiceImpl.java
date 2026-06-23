package com.HotelAndRestuarantBooking.service.impl;

import com.HotelAndRestuarantBooking.constants.AuthConstants;
import com.HotelAndRestuarantBooking.dto.AdminLoginDto;
import com.HotelAndRestuarantBooking.dto.StaffRegisterRequestDto;
import com.HotelAndRestuarantBooking.entity.StaffEntity;
import com.HotelAndRestuarantBooking.exception.InvalidCredentialsException;
import com.HotelAndRestuarantBooking.exception.UserAlreadyExistsException;
import com.HotelAndRestuarantBooking.exception.UserNotFoundException;
import com.HotelAndRestuarantBooking.repository.StaffRepository;
import com.HotelAndRestuarantBooking.security.JwtService;
import com.HotelAndRestuarantBooking.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private StaffRepository staffRepository;
    @Autowired
    private JwtService jwtService;
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

    @Override
    public AdminLoginDto adminLogin(AdminLoginDto adminLoginDto){

        Optional<StaffEntity> staffEntity = staffRepository.findByEmail(adminLoginDto.getEmail());

        AdminLoginDto adminLoginDtoRes = new AdminLoginDto();

        if(staffEntity.isPresent()){

            if(passwordEncoder.matches(adminLoginDto.getPassword(),staffEntity.get().getPassword())){

                String jwtToken = jwtService.generateJwtToken(staffEntity.get());

                adminLoginDtoRes.setEmail(staffEntity.get().getEmail());
                adminLoginDtoRes.setName(staffEntity.get().getName());
                adminLoginDtoRes.setToken(jwtToken);
                adminLoginDtoRes.setStaffId(staffEntity.get().getId());
                adminLoginDtoRes.setRole(staffEntity.get().getRole());
                adminLoginDtoRes.setPassword("");
            } else {
                throw new InvalidCredentialsException(AuthConstants.ERROR_USER_INVALID_CREDENTIALS);
            }

        }else {
            throw new UserNotFoundException(AuthConstants.ERROR_USER_NOT_FOUND);
        }

        return adminLoginDtoRes;
    }
}
