package co.scastillos.security2.entity.hospedaje;


import co.scastillos.security2.dto.RegistroPedidoDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pedido;

    private String nombre_cliente;

    private Integer n_mesa;

    private LocalDateTime fecha_pedido;

    @ElementCollection
    @CollectionTable(name = "articulos_pedido", joinColumns = @JoinColumn(name = "pedido_id"))
    @MapKeyColumn(name = "articulo")
    @Column(name = "precio")
    private Map<String, Double> articulos; // Nombre del artículo y su precio

    private Double precioTotal;

    public Pedido(RegistroPedidoDto pedido) {
        this.nombre_cliente = pedido.nombre_cliente();
        this.n_mesa = pedido.n_mesa();
        this.fecha_pedido = pedido.fecha_pedido();
        this.articulos = pedido.articulos();
        this.precioTotal = pedido.precioTotal();
    }
}
