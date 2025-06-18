package com.perfulandia.post_venta.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.perfulandia.post_venta.model.Venta;
@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer>{
    Venta findById(int id);
    
}
