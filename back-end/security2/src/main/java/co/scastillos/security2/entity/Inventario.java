package co.scastillos.security2.entity;


import co.scastillos.security2.dto.RegistroProductoDto;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "inventario")
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_producto;

    @JoinColumn(name = "nombre_producto")
    private String nombreProducto;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    private Integer cantidad;

    private Double precioUnitario;


    public Inventario(RegistroProductoDto producto) {
        this.nombreProducto = producto.nombreProducto();
        this.categoria = Categoria.valueOf(producto.categoria().toUpperCase());
        this.cantidad = producto.cantidad();
        this.precioUnitario = producto.precioUnitario();
    }
}