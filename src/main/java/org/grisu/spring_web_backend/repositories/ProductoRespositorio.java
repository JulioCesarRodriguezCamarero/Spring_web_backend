package org.grisu.spring_web_backend.repositories;

import org.grisu.spring_web_backend.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRespositorio extends JpaRepository<Producto, Long> {
}
