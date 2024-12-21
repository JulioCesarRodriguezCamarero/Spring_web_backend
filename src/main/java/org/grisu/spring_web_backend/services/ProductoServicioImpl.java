package org.grisu.spring_web_backend.services;

import org.grisu.spring_web_backend.entities.Producto;
import org.grisu.spring_web_backend.repositories.ProductoRespositorio;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServicioImpl implements ProductoServicoInterface {

    private final ProductoRespositorio repo;

    public ProductoServicioImpl(ProductoRespositorio productoRespositorio) {
        this.repo = productoRespositorio;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Producto> obtenerProductos() {
        return repo.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Producto> obtenerProductoPorId(Long id) {
        return Optional.of(repo.findById(id).orElseThrow());
    }

    @Transactional
    @Override
    public Producto guardarProducto(Producto producto) {
        return repo.save(producto);
    }

    @Transactional
    @Override
    public Optional<Producto> eliminarProducto(Long id) {
        return repo.findById(id) // Busca el producto por ID
                .map(producto -> {   // Si existe, procede con la lógica
                    repo.delete(producto); // Elimina el producto
                    return producto;       // Devuelve el producto eliminado
                }); // Si no existe, retorna Optional.empty()
    }
}
