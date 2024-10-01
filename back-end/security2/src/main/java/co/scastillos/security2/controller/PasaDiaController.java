package co.scastillos.security2.controller;

import co.scastillos.security2.dto.RespuestaDisp;
import co.scastillos.security2.dto.SolicitudPasaDiaDto;
import co.scastillos.security2.service.PasaDiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5500")
@RestController
@RequestMapping("/pasaDia")
public class PasaDiaController {

    @Autowired
    PasaDiaService pasaDiaService;


    @PostMapping("/solicitarPasaDia")
    public ResponseEntity<RespuestaDisp> solicitudPasaDia(@RequestBody SolicitudPasaDiaDto solicitud){

        pasaDiaService.solicitarPasaDia(solicitud);

        return ResponseEntity.ok(new RespuestaDisp("solicitud enviada"));
    }









}
