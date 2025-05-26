package com.perfulandia.post_venta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.perfulandia.post_venta.model.Reclamo;

@Repository
public interface ReclamosRepository  extends JpaRepository<Reclamo, Integer> {
    
    // Aquí puedes agregar métodos personalizados si es necesario
    List<Reclamo> findAll();
    @SuppressWarnings("unchecked")
    Reclamo findById(int id);
    Reclamo save(Reclamo reclamo);
    
}
