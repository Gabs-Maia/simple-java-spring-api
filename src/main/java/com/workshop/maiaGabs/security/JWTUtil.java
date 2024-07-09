package com.workshop.maiaGabs.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

@Component
public class JWTUtil {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    public String generateToken(String username){
        SecretKey key = getKeyBySecret();
        Date expiration = new Date(System.currentTimeMillis() + this.expiration);
        JwtBuilder generatedToken = Jwts.builder()
                                    .subject(username).expiration(expiration)
                                    .signWith(key);
        return generatedToken.compact();//compact it into a string
    }

    private SecretKey getKeyBySecret(){
        byte[] secretInBytes = this.secret.getBytes();
        SecretKey key = Keys.hmacShaKeyFor(secretInBytes);
        return key;
    }

    public boolean isValidToken(String token){
        Claims claims = getClaims(token);
        if(Objects.nonNull(claims)){

            String username = claims.getSubject();
            boolean assertUsername = Objects.nonNull(username);

            Date expirationDate = claims.getExpiration();
            boolean assertExpiration = Objects.nonNull(expirationDate);

            Date now = new Date(System.currentTimeMillis());
            boolean assertNow = now.before(expirationDate);

            return assertUsername && assertExpiration && assertNow;
        }
        return false;
    }

    private String getUsername(String token){
        Claims claims = getClaims(token);
        return (Objects.nonNull(claims)) ? claims.getSubject() : null;
    }

    private Claims getClaims(String token){
        SecretKey key = getKeyBySecret();
        try{
            return Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload();
        }catch(Exception e){
            return null;
        }
    }
}