package com.bridgelabz.hospital_management_system;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Encoders;

public class SecretKeyGenerator {

    public static void main(String[] args) {

        String secretKey = Encoders.BASE64.encode(
                Jwts.SIG.HS256.key().build().getEncoded()
        );

        System.out.println("JWT Secret Key: " + secretKey);
    }
}