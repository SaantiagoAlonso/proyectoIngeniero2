package co.scastillos.security2.controller;

import co.scastillos.security2.dto.DatosReservaDto;
import co.scastillos.security2.dto.RespuestaDisp;
import co.scastillos.security2.dto.SolicitudExtencionDto;
import co.scastillos.security2.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5500")
@RestController
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    ReservaService reservaService;

    @PostMapping("/verificarReserva")
    public ResponseEntity<RespuestaDisp> reservarAhora(@RequestBody DatosReservaDto reservaDto){

       if(reservaService.verificarDisponibilidad(reservaDto)){
           RespuestaDisp res = new RespuestaDisp("habitacion disponible ");
           return ResponseEntity.ok(res);
       }
        RespuestaDisp res = new RespuestaDisp("habitacion no disponible");
        return ResponseEntity.ok(res);
    }

    @PutMapping("/extencion")
    public ResponseEntity<RespuestaDisp> solicitudExtencion(@RequestBody SolicitudExtencionDto solicitud){

        if (reservaService.solicitudExtencion(solicitud)){
            return ResponseEntity.ok(new RespuestaDisp("Solicitud Aceptada"));
        }
        return ResponseEntity.ok(new RespuestaDisp("Solicitud Denegada La habitacion ya esta reservada"));

    }




}
