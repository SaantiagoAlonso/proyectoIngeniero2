package co.scastillos.security2.dto;

import co.scastillos.security2.entity.hospedaje.Pedido;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Map;

public record RegistroPedidoDto(

        String nombre_cliente,

        Integer n_mesa,

        LocalDateTime fecha_pedido,

        Map<String, Double> articulos,// Nombre del artículo y su precio

        Double precioTotal
) {


    public RegistroPedidoDto(Pedido p) {
        this(p.getNombre_cliente(), p.getN_mesa(),p.getFecha_pedido(),p.getArticulos(),p.getPrecioTotal());
    }
}
