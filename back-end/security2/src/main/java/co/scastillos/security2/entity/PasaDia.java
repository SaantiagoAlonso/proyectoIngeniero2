package co.scastillos.security2.entity;

import co.scastillos.security2.dto.SolicitudPasaDiaDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "pasa-dia")
public class PasaDia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pasaDia;

    private String nombre;

    private String email;

    private Date fechaVisita;

    private String servicio;

    private String comentario;

    public PasaDia(SolicitudPasaDiaDto solicitud) {
        this.nombre = solicitud.nombre();
        this.email = solicitud.email();
        this.fechaVisita = solicitud.fechaVisita();
        this.servicio = solicitud.servicio();
        this.comentario = solicitud.comentario();

    }
}
