package com.HotelAndRestuarantBooking.exception;

import com.HotelAndRestuarantBooking.apiResponse.ApiResponse;
import com.HotelAndRestuarantBooking.constants.ExceptionConstants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResponse<Map<String, String>> handleValidationErrors(MethodArgumentNotValidException ex){

        Map<String, String> errorsMap = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorsMap.put(error.getField(),error.getDefaultMessage());
        });

        ApiResponse<Map<String, String>> response = new ApiResponse<>(false, ExceptionConstants.API_FAILED, errorsMap);

        return response;
    }
}







//@RestControllerAdvice
//public class GlobalExceptionHandler {
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<ApiResponse<Map<String,String>>> handleValidationErrors(MethodArgumentNotValidException ex){
//
//        Map<String,String> errorsmap = new HashMap<String, String>();
//
//        ex.getBindingResult().getFieldErrors().forEach(error ->{
//            errorsmap.put(error.getField(),error.getDefaultMessage());
//        });
//        ApiResponse<Map<String,String>> response = new ApiResponse<Map<String,String>>(false,ExceptionConstants.API_FAILED, errorsmap);
//        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//    }