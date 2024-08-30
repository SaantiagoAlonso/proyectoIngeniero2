package co.scastillos.security2.dto;

public record AuthResponse(String username,
                           String message,

                           String jwt,

                           boolean status) {
}
