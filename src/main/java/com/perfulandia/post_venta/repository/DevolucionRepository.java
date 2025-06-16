package com.perfulandia.post_venta.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.perfulandia.post_venta.model.Devolucion;
@Repository
public interface DevolucionRepository extends JpaRepository<Devolucion, Integer> {

    
}
