package co.scastillos.security2.dto;

import co.scastillos.security2.entity.Inventario;

public record ProductoDto(Long id,
                          String nombreProducto,

                          String categoria,

                          Integer cantidad,

                          Double precioUnitario
                          )  {
    public ProductoDto(Inventario producto) {
        this(producto.getId_producto(), producto.getNombreProducto(),producto.getCategoria().toString(), producto.getCantidad(), producto.getPrecioUnitario());
    }
}
