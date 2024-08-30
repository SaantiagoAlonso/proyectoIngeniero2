package co.scastillos.security2.configuration;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CustomOAuth2AuthenticationSuccessHandler implements AuthenticationSuccessHandler {


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        // Aquí puedes realizar las acciones que necesites tras la autenticación exitosa
        // Por ejemplo, redirigir al usuario a una página específica:
        // Redirige a la página de inicio después de un login exitoso
//        System.out.println(authentication.getName() + authentication.toString());
//         String <t> usuario = authentication.getPrincipal().;
//        System.out.println(usuario.s);
        OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) authentication;
        Map<String, Object> userAttributes = oauthToken.getPrincipal().getAttributes();
        String email = (String) userAttributes.get("email");
        System.out.println(email);
        response.sendRedirect("http://localhost:5500/hola.html");
    }
}

