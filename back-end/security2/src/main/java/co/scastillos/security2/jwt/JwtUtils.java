package co.scastillos.security2.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class JwtUtils {

    private String private_key = "mi_clave";

    private String authorToken = "backend";


    public String createToken(Authentication authentication){

        Algorithm algorithm = Algorithm.HMAC256(this.private_key);
        
        String username = authentication.getName();
        
        String authorizations = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));


        return  JWT.create()
                .withIssuer(authorToken)
                .withSubject(username)
                .withClaim("authorizations",authorizations)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + 7200000)) // dos horas
                .withJWTId(UUID.randomUUID().toString())
                .withNotBefore(new Date(System.currentTimeMillis()))
                .sign(algorithm);
        
    }


    public  DecodedJWT decodedToken(String token){

        Algorithm algorithm = Algorithm.HMAC256(this.private_key);
        JWTVerifier verifier = JWT.require(algorithm)
                // specify any specific claim validations
                .withIssuer(this.authorToken)
                // reusable verifier instance
                .build();

        DecodedJWT decodedJWT  = verifier.verify(token);

        return decodedJWT;

    }

    public String extractUsername(DecodedJWT decodedJWT){
        return decodedJWT.getSubject().toString();
    }

    public Claim getSpecificClaim(DecodedJWT decodedJWT, String claimName){
        return decodedJWT.getClaim(claimName);
    }

}
