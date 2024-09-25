package co.scastillos.security2.configuration;

import co.scastillos.security2.jwt.JwtFilter;
import co.scastillos.security2.jwt.JwtUtils;
import co.scastillos.security2.service.UserDatailsServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import java.io.IOException;


@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Autowired
    private JwtUtils jwtUtils;


    @Autowired
    private CustomOAuth2AuthenticationSuccessHandler successHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.csrf(csrf -> csrf.disable())
                .cors(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(http -> {
                    http.requestMatchers(HttpMethod.POST, "/auth/login").permitAll();
                    http.requestMatchers(HttpMethod.GET,"auth/verify-token").permitAll();
                    http.requestMatchers("/login/oauth2/**").permitAll();
                    http.requestMatchers(HttpMethod.POST,"/user/setPassword").permitAll();
                    http.requestMatchers(HttpMethod.POST,"/user/registrationUser").permitAll();
                    http.requestMatchers(HttpMethod.GET,"user/prueba").hasRole("ADMINISTRADOR");
                    http.requestMatchers(HttpMethod.PUT,"/user/updateUser").hasRole("ADMINISTRADOR");
                    http.requestMatchers(HttpMethod.DELETE,"/user/delete/**").hasRole("ADMINISTRADOR");
                    http.requestMatchers(HttpMethod.POST,"/reserva/verificarReserva").permitAll();
                    http.requestMatchers(HttpMethod.PUT,"/reserva/extencion").permitAll();
                    http.requestMatchers("/inventario/**").permitAll();
//                    http.requestMatchers("/hola.html").authenticated();
                    http.anyRequest().authenticated();
                })
                .addFilterBefore(new JwtFilter(jwtUtils), BasicAuthenticationFilter.class)
//                .formLogin(pagina -> pagina.loginPage("http://localhost:5500/index.html")) //agregado
//                .oauth2Login(Customizer.withDefaults()) //agregado
                .oauth2Login(oauth2 -> oauth2
                        // Redirigir a tu página de login para OAuth2
                        .successHandler(successHandler)
                )
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(UserDatailsServiceImpl userDatailsService){
        DaoAuthenticationProvider provaider = new DaoAuthenticationProvider();
        provaider.setUserDetailsService(userDatailsService);
        provaider.setPasswordEncoder(passwordEncoder());
        return  provaider;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}
