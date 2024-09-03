package co.scastillos.security2.dto;

import co.scastillos.security2.entity.Usuario;

public record UserResponse(Long id, String username, String email, Integer age) {

    public UserResponse(Usuario usuario) {
        this(usuario.getId(), usuario.getUsername(), usuario.getEmail(), usuario.getAge());
    }
}
