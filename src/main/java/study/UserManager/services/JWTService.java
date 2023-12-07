package study.UserManager.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Service;
import study.UserManager.User;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class JWTService {

    private final Algorithm algorithm;
    private final String issuer;
    private final long tokenDuration;
    private final String brasiliaZoneOffset;

    public JWTService(){
        Dotenv dotenv = Dotenv.configure().load();
        this.algorithm = Algorithm.HMAC256(dotenv.get("SECRET"));
        this.issuer = "userManager";
        this.tokenDuration = 2L;
        this.brasiliaZoneOffset = "-03:00";
    }

    public String generateToken(User user){
        try {
            String token = JWT.create()
                    .withIssuer(this.issuer)
                    .withSubject(user.getEmail())
                    .withExpiresAt(generateExpirationDate())
                    .sign(this.algorithm);
            return token;
        } catch (JWTCreationException exception){
            throw new RuntimeException("ERROR WHILE TOKEN GENERATION", exception);
        }
    }

    public String validateToken(String token){
        try {
            String subject = JWT.require(this.algorithm)
                    .withIssuer(this.issuer)
                    .build()
                    .verify(token)
                    .getSubject();
            return subject;
        } catch (JWTVerificationException exception){
            return "";
        }
    }
    public Instant generateExpirationDate(){
        return LocalDateTime.now().plusHours(this.tokenDuration).toInstant(ZoneOffset.of(this.brasiliaZoneOffset));
    }
}
