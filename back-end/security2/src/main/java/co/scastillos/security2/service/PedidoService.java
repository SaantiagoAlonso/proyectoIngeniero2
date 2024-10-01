package co.scastillos.security2.service;

import co.scastillos.security2.dto.RegistroPedidoDto;
import co.scastillos.security2.entity.hospedaje.Pedido;
import co.scastillos.security2.repository.RepoPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    @Autowired
    private RepoPedido repoPedido;

    public void registarPedido(RegistroPedidoDto pedido) {
        Pedido newPedido = new Pedido(pedido);
        repoPedido.save(newPedido);
    }

    public List<RegistroPedidoDto> verPedidos() {
        return repoPedido.findAll().stream()
                .map(p -> new RegistroPedidoDto(p)).
                collect(Collectors.toList());

    }
}
