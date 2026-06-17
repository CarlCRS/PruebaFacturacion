package ec.sasf.ms_comp_prueba_Carlos_Chica.Security;

import java.security.Key;
import java.util.Date;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import ec.sasf.ms_comp_prueba_Carlos_Chica.Entity.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtUtil {

    private static final String SECRET_KEY = "dI+x6W6EQPvJqQrWzVT5GvEC8NOUwZeKgcp1OGDvh6Y=";

    private Key getKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET_KEY));
    }

    public String getToken(UserDetails user) {
        Usuario usuario = (Usuario) user;
        return Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000))
                .addClaims(Map.of("rol", usuario.getRol().name()))
                .signWith(getKey())
                .compact();
    }

    public String getUsernameFromToken(String token) {
        return Jwts.parser().setSigningKey(getKey()).build().parseClaimsJws(token).getBody().getSubject();
    }

    public boolean isTokenValid(String token, UserDetails user) {
        String username = getUsernameFromToken(token);
        return username.equals(user.getUsername());
    }
}
