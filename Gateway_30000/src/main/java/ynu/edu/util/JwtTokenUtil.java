package ynu.edu.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtTokenUtil {
    private static long ttl = 60 * 1000 * 60;
    private SecretKey key = Jwts.SIG.HS256.key().build();

    public String generateToken(String userId) {
        Date expiryDate = new Date(new Date().getTime() + ttl);
        String jws = null;
        try {
            jws = Jwts.builder()
                    .header()
                    .add("for","user")
                    .and()

                    .claim("userId",userId)
                    .expiration(expiryDate)
                    .issuedAt(new Date())

                    .signWith(key)
                    .compact();
        }catch (JwtException ex){
            ex.printStackTrace();
        }
        return jws;
    }

    public Claims getUsernameFromToken(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .verifyWith(key)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
            System.out.println(claims.get("userId"));
        }catch (JwtException ex){
            ex.printStackTrace();
        }
        return claims;
    }

    public boolean validateToken(String token) {
        try{
            return !isTokenExpired(token);
        }catch (Exception exception){
            exception.printStackTrace();
            return false;
        }
    }

    private boolean isTokenExpired(String token) throws Exception{
        Date expiryDate = getExpirationDateFromToken(token);
        return expiryDate.before(new Date());
    }

    private Date getExpirationDateFromToken(String token) throws IllegalArgumentException {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .verifyWith(key)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
            return claims.getExpiration();
        }catch (IllegalArgumentException exception){
            throw exception;
        }
    }
}

