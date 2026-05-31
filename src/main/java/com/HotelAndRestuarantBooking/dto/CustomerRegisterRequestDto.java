package com.HotelAndRestuarantBooking.dto;

import com.HotelAndRestuarantBooking.constants.AuthConstants;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import jakarta.validation.constraints.NotNull;

@Data
public class CustomerRegisterRequestDto {

    @NotNull(message = AuthConstants.ERROR_EMAIL_REQUIRED)
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9._%+-]+\\.[a-zA-Z]{2,}$", message = AuthConstants.ERROR_EMAIL_IS_NOT_VALID)
    private String email;

    @NotNull(message = AuthConstants.ERROR_NAME_REQUIRED)
    private String name;

    @NotNull(message = AuthConstants.ERROR_PHONE_NUMBER_REQUIRED)
    @Size(min = 10, message = AuthConstants.ERROR_PHONE_NUMBER_IS_NOT_VALID)
    private String phone;

    @NotNull(message = AuthConstants.ERROR_PASSWORD_IS_REQUIRED)
    @Size(min = 6,message = AuthConstants.ERROR_PASSWORD_IS_NOT_INVALID)
    private String password;
}
