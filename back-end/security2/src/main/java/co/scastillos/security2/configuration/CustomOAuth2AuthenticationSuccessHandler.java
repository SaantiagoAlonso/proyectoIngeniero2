package co.scastillos.security2.configuration;

import co.scastillos.security2.dto.AuthLoginRequest;
import co.scastillos.security2.dto.AuthResponse;
import co.scastillos.security2.entity.Usuario;
import co.scastillos.security2.repository.UserRepository;
import co.scastillos.security2.service.UserDatailsServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CustomOAuth2AuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    UserDatailsServiceImpl userDatailsService;

    @Autowired
    UserRepository userRepository;


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

        //estoy agregando esto
        Usuario usuario = userRepository.findByEmail(email).orElse(null);

        if(usuario == null){
            response.sendRedirect("http://localhost:5500/index.html");
            return;
        }

        AuthLoginRequest authLoginRequest = new AuthLoginRequest(usuario.getUsername(), usuario.getPassword());


//        ResponseEntity.ok(userDatailsService.loginUserGoogle(authLoginRequest));

        AuthResponse authResponse = userDatailsService.loginUserGoogle(authLoginRequest);
//        response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
//        response.getWriter().write("{\"jwt\": \"" + authResponse.jwt() + "\"}");

        response.sendRedirect("http://localhost:5500/hola.html?jwt=" + authResponse.jwt());
    }
}

