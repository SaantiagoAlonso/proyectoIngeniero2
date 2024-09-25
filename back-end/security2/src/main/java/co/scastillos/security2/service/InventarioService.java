package co.scastillos.security2.service;

import co.scastillos.security2.dto.ProductoDto;
import co.scastillos.security2.dto.RegistroProductoDto;
import co.scastillos.security2.entity.Categoria;
import co.scastillos.security2.entity.Inventario;
import co.scastillos.security2.repository.RepoInventario;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventarioService {

    @Autowired
    RepoInventario repoInventario;



    public List<Inventario> mostrarInventario() {
      return repoInventario.findAll();

    }

    public ProductoDto registrarProducto(RegistroProductoDto producto) {
        Inventario nuevoProducto = new Inventario(producto);
        repoInventario.save(nuevoProducto);
        return new ProductoDto(nuevoProducto);
    }


    public Inventario verProducto(Long id) {
        return repoInventario.findById(id).orElse(null);


    }


    @Transactional
    public ProductoDto actualizarProducto(ProductoDto productoDto) {

        Inventario producto = repoInventario.getReferenceById(productoDto.id());
        if (productoDto.nombreProducto() != null){
            producto.setNombreProducto(productoDto.nombreProducto());
        }
        if(productoDto.categoria() != null){
            producto.setCategoria(Categoria.valueOf(productoDto.categoria()));
        }
        if (productoDto.cantidad() != null){
            producto.setCantidad(productoDto.cantidad());
        }
        if(productoDto.precioUnitario() != null){
            producto.setPrecioUnitario(productoDto.precioUnitario());
        }

        return new ProductoDto(producto);
    }

    public void borrarProducto(Long id) {
        repoInventario.delete(repoInventario.getReferenceById(id));
    }
}
