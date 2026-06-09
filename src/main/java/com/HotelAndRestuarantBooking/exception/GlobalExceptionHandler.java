package com.HotelAndRestuarantBooking.exception;

import com.HotelAndRestuarantBooking.apiResponse.ApiResponse;
import com.HotelAndRestuarantBooking.constants.AuthConstants;
import com.HotelAndRestuarantBooking.constants.ExceptionConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Map<String, String>>> handleValidationErrors(MethodArgumentNotValidException ex){

        Map<String, String> errorsMap = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorsMap.put(error.getField(),error.getDefaultMessage());
        });

        ApiResponse<Map<String, String>> response = new ApiResponse<>(false, ExceptionConstants.API_FAILED, errorsMap);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ApiResponse<String>> handleUserAlreadyExistsError(UserAlreadyExistsException ex){
        ApiResponse<String> response = new ApiResponse<>(false, AuthConstants.ERROR_USER_ALREADY_EXISTS,ex.getMessage());
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }
}