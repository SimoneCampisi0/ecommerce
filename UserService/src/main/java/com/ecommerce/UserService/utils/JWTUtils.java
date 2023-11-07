package com.ecommerce.UserService.utils;

import com.ecommerce.UserService.repository.UserRepository;
import io.jsonwebtoken.*;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.io.Decoders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JWTUtils {

    @Autowired
    private UserRepository userRepository;

    @Value("${secret.key}")
    private String secretKey;

    public String validateToken(final String token) {
        try {
            Jws<Claims> claimsJwt = Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token);
            String email = claimsJwt.getBody().get("sub", String.class);

            if(Objects.isNull(userRepository.findUserByEmail(email))) {
                return "TOKEN_NON_VALIDO";
            }

            return "TOKEN_VALIDO";
        } catch (ExpiredJwtException e) {
            return "TOKEN_SCADUTO";
        } catch (MalformedJwtException | SignatureException | UnsupportedJwtException | IllegalArgumentException e) {
            return "TOKEN_NON_VALIDO";
        }
    }



    public String generateToken(String email) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, email);
    }

    private String createToken(Map<String, Object> claims, String email) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(email)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30))
                .signWith(getSignKey(), SignatureAlgorithm.HS256).compact();
    }

    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
