package co.scastillos.security2.entity.hospedaje;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "servicio_adicional")
public class ServicioAdicional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_servicio;

    private String nombreServicio;

    private String descripcion;

    private Double precio;

    @ManyToMany(mappedBy = "serviciosAdicionales")
    private List<Reserva> reservas;


}
