package com.HotelAndRestuarantBooking.dto;

import com.HotelAndRestuarantBooking.constants.AuthConstants;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AdminLoginDto {

    @NotNull(message = AuthConstants.ERROR_EMAIL_REQUIRED)
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9._%+-]+\\.[a-zA-Z]{2,}$", message = AuthConstants.ERROR_EMAIL_IS_NOT_VALID)
    private String email;

    @NotNull(message = AuthConstants.ERROR_PASSWORD_IS_REQUIRED)
    @Size(min = 6,message = AuthConstants.ERROR_PASSWORD_IS_NOT_INVALID)
    private String password;

    private String token;

    private String name;

    private String role;

    private Long staffId;
}
