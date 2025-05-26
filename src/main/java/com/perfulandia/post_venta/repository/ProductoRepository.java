package com.perfulandia.post_venta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.perfulandia.post_venta.model.Producto;
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{
    List<Producto> findAll();
    @SuppressWarnings("unchecked")
    Producto findById(int id);
    Producto save(Producto reclamo);
    
}
