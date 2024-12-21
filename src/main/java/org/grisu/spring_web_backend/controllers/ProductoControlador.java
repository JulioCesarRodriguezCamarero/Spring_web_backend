package org.grisu.spring_web_backend.controllers;

import org.grisu.spring_web_backend.entities.Producto;
import org.grisu.spring_web_backend.services.ProductoServicoInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoControlador {

    private final ProductoServicoInterface servicio;

    public ProductoControlador(ProductoServicoInterface servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public ResponseEntity<List<Producto>> listarProductos() {
        return ResponseEntity.ok(servicio.obtenerProductos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable Long id) {
        return servicio.obtenerProductoPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Producto> guardarProducto(@RequestBody Producto producto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(servicio.guardarProducto(producto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Long id, @RequestBody Producto producto) {
        return servicio.obtenerProductoPorId(id)
                .map(productoActual -> {
                    productoActual.setNombre(producto.getNombre());
                    productoActual.setPrecio(producto.getPrecio());
                    productoActual.setDescripcion(producto.getDescripcion());
                    return ResponseEntity.status(HttpStatus.CREATED).body(servicio.guardarProducto(productoActual));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Producto> eliminarProducto(@PathVariable Long id) {
        return servicio.eliminarProducto(id)
                .map(productoEliminado -> ResponseEntity.ok(productoEliminado))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
