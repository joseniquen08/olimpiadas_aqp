package pe.edu.utp.olimpiadas_aqp.security;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {
    private final SecretKey SECRET_KEY = Jwts.SIG.HS512.key().build();
    private final JwtParser jwtParser;

    public JwtUtil() {
        this.jwtParser = Jwts.parser().verifyWith(SECRET_KEY).build();
    }

    public String createToken(String email) {
        long EXPIRATION_DATE = 86400000;
        return Jwts.builder()
                .subject(email)
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_DATE))
                .signWith(SECRET_KEY)
                .compact();
    }

    private Claims parseJwtClaims(String token) {
        return jwtParser.parseSignedClaims(token).getPayload();
    }

    public String resolveToken(String bearerToken) {
        String TOKEN_PREFIX = "Bearer ";
        if (bearerToken != null && bearerToken.startsWith(TOKEN_PREFIX)) {
            return bearerToken.substring(TOKEN_PREFIX.length());
        }
        return null;
    }

    public Claims resolveClaims(String bearerToken) {
        try {
            String token = resolveToken(bearerToken);
            if (token != null) {
                return parseJwtClaims(token);
            }
            return null;
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean validateToken(String bearerToken) {
        try {
            Claims claims = resolveClaims(bearerToken);
            if (claims != null) {
                return claims.getSubject().equals("admin@olimpiadasaqp.com");
            }
            return false;
        } catch (Exception e) {
            throw e;
        }
    }
}
