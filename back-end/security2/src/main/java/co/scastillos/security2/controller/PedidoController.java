package co.scastillos.security2.controller;

import co.scastillos.security2.dto.RegistroPedidoDto;
import co.scastillos.security2.dto.RespuestaDisp;
import co.scastillos.security2.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5500")
@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    @PostMapping("/registarPedido")
    public ResponseEntity<RespuestaDisp> registrarPedido(@RequestBody RegistroPedidoDto pedido){
        pedidoService.registarPedido(pedido);
        return ResponseEntity.ok(new RespuestaDisp("pedido Registrado "));
    }

    @GetMapping("/verPedidos")
    public ResponseEntity<List<RegistroPedidoDto>> listarPedidos(){
        List<RegistroPedidoDto> pedidos = pedidoService.verPedidos();
        return ResponseEntity.ok(pedidos);
    }



}
