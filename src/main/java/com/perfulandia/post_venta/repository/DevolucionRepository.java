package com.perfulandia.post_venta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.perfulandia.post_venta.model.Devolucion;
@Repository
public interface DevolucionRepository extends JpaRepository<Devolucion, Integer> {
    List<Devolucion> findAll();
    @SuppressWarnings("unchecked")
    Devolucion findById(int id);
    Devolucion save(Devolucion reclamo);

    
}
