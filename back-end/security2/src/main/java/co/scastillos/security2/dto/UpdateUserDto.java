package co.scastillos.security2.dto;

public record UpdateUserDto(Long id,String username,String email,String rol, Integer age) {
}
