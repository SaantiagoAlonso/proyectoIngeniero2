package co.scastillos.security2.service;

import co.scastillos.security2.dto.SolicitudPasaDiaDto;
import co.scastillos.security2.entity.PasaDia;
import co.scastillos.security2.repository.RepoPasaDia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PasaDiaService {

    @Autowired
    RepoPasaDia repoPasaDia;


    public void solicitarPasaDia(SolicitudPasaDiaDto solicitud) {
        PasaDia cliente = new PasaDia(solicitud);
        repoPasaDia.save(cliente);
    }
}
