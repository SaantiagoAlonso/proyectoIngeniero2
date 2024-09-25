package co.scastillos.security2.dto;

public record RegistroProductoDto(String nombreProducto,
                                  String categoria,
                                  Integer cantidad,
                                  Double precioUnitario
) {
}
