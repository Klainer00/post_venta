package com.perfulandia.post_venta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.perfulandia.post_venta.model.Producto;
import com.perfulandia.post_venta.model.Venta;
@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer>{
    @SuppressWarnings("unchecked")
    Venta findById(int id);
    Venta save(Producto reclamo);
    
}
