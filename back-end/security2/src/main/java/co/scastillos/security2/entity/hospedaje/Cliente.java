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
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cliente;

    private Long identificacion;

    private String nombre;

    private String email;

    private Integer telefono;

    // Relación uno-a-muchos con Reserva
    @OneToMany(mappedBy = "cliente")
    private List<Reserva> reservas;

}
