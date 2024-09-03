package co.scastillos.security2.controller;

import co.scastillos.security2.dto.NewUserDto;
import co.scastillos.security2.dto.SetPasswordDto;
import co.scastillos.security2.dto.UpdateUserDto;
import co.scastillos.security2.dto.UserResponse;
import co.scastillos.security2.service.PasswordService;
import co.scastillos.security2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5500")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    PasswordService passwordService;

    @Autowired
    UserService userService;

    @PostMapping("/setPassword")
    public ResponseEntity<String> changePassword(@RequestBody SetPasswordDto email){
        passwordService.changePassword(email);
        return ResponseEntity.ok("la contraseña ha sido restablecida porfavor compruebe su correo ");
    }

    @PostMapping("/registrationUser")
    public ResponseEntity<UserResponse> createUser(@RequestBody NewUserDto newUser){
        UserResponse user = userService.createNewUser(newUser);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/seeUser/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long id){
        return ResponseEntity.ok(userService.getUser(id));
    }


    @PutMapping("/updateUser")
    public  ResponseEntity<UserResponse> updateUser(@RequestBody UpdateUserDto userDto){
        return ResponseEntity.ok(userService.updateUser(userDto));
    }

    @GetMapping("/listUsers")
    public ResponseEntity<List<UserResponse>> listUsers(){
        return ResponseEntity.ok(userService.listUsers());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @GetMapping("/prueba")
    public ResponseEntity<String> pueaba(){
        return ResponseEntity.ok("prueba lograda");
    }

}
