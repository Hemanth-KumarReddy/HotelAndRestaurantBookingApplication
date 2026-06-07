package com.HotelAndRestuarantBooking.service;

import com.HotelAndRestuarantBooking.entity.StaffEntity;
import com.HotelAndRestuarantBooking.repository.StaffRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {

    //Process to implement JWT
    /*
       * We need a secret key to create token and this is initialized in application.properties file.
       * add dependencies. --jsonwebtoken maven
       * Decide token live duration.
       * Generate encrypted key using secret key.
       * Decide what to store in the token.
       * Generate jwt token.
     */

    @Value("${jwt.secret.key}")
    private String JwtSecretKey;

    @Value("${jwt.expiration}")
    private int JwtKeyDuration;

    private Key generateSecurityKey(){
        return Keys.hmacShaKeyFor(JwtSecretKey.getBytes());
    }

    public String generateJwtToken(StaffEntity staffData){
        Date tokenGeneratedDate = new Date();

        Date expiryDate = new Date(tokenGeneratedDate.getTime() + JwtKeyDuration);

        Map<String,Object> tokenData = new HashMap<>();
        tokenData.put("id",staffData.getId());
        tokenData.put("name",staffData.getName());
        tokenData.put("email",staffData.getEmail());

        String jwtToken = Jwts.builder()
                .claims().add(tokenData).and()
                .subject(staffData.getEmail())
                .issuedAt(tokenGeneratedDate)
                .expiration(expiryDate)
                .signWith(generateSecurityKey()).compact();
        return jwtToken;
    }
    


}
