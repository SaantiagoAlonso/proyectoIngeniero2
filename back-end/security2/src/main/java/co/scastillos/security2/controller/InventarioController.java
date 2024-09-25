package co.scastillos.security2.controller;

import co.scastillos.security2.dto.ProductoDto;
import co.scastillos.security2.dto.RegistroProductoDto;
import co.scastillos.security2.entity.Inventario;
import co.scastillos.security2.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5500")
@RestController
@RequestMapping("/inventario")
public class InventarioController {

    @Autowired
    InventarioService inventarioService;



    @PostMapping("/ingresarProducto")
    public ResponseEntity<ProductoDto> registrarProducto(@RequestBody RegistroProductoDto producto){

        ProductoDto newProducto =  inventarioService.registrarProducto(producto);

        return new ResponseEntity<>(newProducto,HttpStatus.CREATED);
    }

    @GetMapping("/listarProductos") ResponseEntity<List<Inventario>> mostrarInventario(){
        return ResponseEntity.ok(inventarioService.mostrarInventario());
    }

    @GetMapping("/verProducto/{id}")
    public ResponseEntity<Inventario> obtenerProducto(@PathVariable Long id){
        return ResponseEntity.ok(inventarioService.verProducto(id));
    }

    @PutMapping("/actualizarProducto")
    public ResponseEntity<ProductoDto> actualizarProducto(@RequestBody ProductoDto producto){
        return ResponseEntity.ok(inventarioService.actualizarProducto(producto));
    }

    @DeleteMapping("/eliminarProducto/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id){
        inventarioService.borrarProducto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }



}
