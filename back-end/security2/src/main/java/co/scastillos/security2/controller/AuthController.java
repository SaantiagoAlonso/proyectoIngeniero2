package co.scastillos.security2.controller;

import co.scastillos.security2.dto.AuthLoginRequest;
import co.scastillos.security2.dto.AuthResponse;
import co.scastillos.security2.service.UserDatailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5500")
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UserDatailsServiceImpl userDatailsService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthLoginRequest user) {
        return ResponseEntity.ok(userDatailsService.loginUser(user));
    }

}





