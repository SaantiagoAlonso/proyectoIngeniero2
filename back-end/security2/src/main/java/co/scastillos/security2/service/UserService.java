package co.scastillos.security2.service;

import co.scastillos.security2.dto.NewUserDto;
import co.scastillos.security2.dto.UpdateUserDto;
import co.scastillos.security2.dto.UserResponse;
import co.scastillos.security2.entity.Rol;
import co.scastillos.security2.entity.Usuario;
import co.scastillos.security2.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public UserResponse createNewUser(NewUserDto newUser){
        Usuario usuario = new Usuario(newUser);
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        userRepository.save(usuario);
        return new UserResponse(usuario);
    }


    public UserResponse getUser(Long id) {
        return new UserResponse(userRepository.getReferenceById(id));
    }

    @Transactional
    public UserResponse updateUser(UpdateUserDto userDto) {
        Usuario user = userRepository.getReferenceById(userDto.id());
        if(userDto.username() != null){
            user.setUsername(userDto.username());
        }
        if(userDto.email() != null){
            user.setEmail(userDto.email());
        }
        if(userDto.rol() != null){
            Rol rol = Rol.valueOf(userDto.rol().toUpperCase());
            user.setRoles(rol);
        }
        if(userDto.age() != null){
            user.setAge(userDto.age());
        }
        return new UserResponse (user);
    }


    public List<UserResponse> listUsers() {
        List<Usuario> users = userRepository.findAll();
        return users.stream().map(UserResponse::new).toList();
    }

    public void deleteUser(Long id) {
        userRepository.delete(userRepository.getReferenceById(id));
    }
}
