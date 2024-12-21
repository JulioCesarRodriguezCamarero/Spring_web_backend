package org.grisu.spring_web_backend.services;

import org.grisu.spring_web_backend.entities.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoServicoInterface {
    List<Producto> obtenerProductos();

    Optional<Producto> obtenerProductoPorId(Long id);

    Producto guardarProducto(Producto producto);

    Optional<Producto>  eliminarProducto(Long id);


}
