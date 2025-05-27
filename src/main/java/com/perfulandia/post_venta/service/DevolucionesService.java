package com.perfulandia.post_venta.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perfulandia.post_venta.model.Devolucion;
import com.perfulandia.post_venta.model.Usuario;
import com.perfulandia.post_venta.repository.DevolucionRepository;

@Service
public class DevolucionesService {
    @Autowired
    private DevolucionRepository devolucionesRepository;

    public List<Devolucion> findAll() {
        return devolucionesRepository.findAll();
    }
    public Devolucion findById(int id) {
        return devolucionesRepository.findById(id);
    }

    public Devolucion crearDevolucion(Devolucion Devolucion) {
        return devolucionesRepository.save(Devolucion);
    }

    public Devolucion cambiarEstado(int id, Devolucion nuevoEstadoObj){ 
        Devolucion buscarDevolucion = this.findById(id); 
        if (buscarDevolucion != null) {
            buscarDevolucion.setEstado(nuevoEstadoObj.getEstado()); 
            return devolucionesRepository.save(buscarDevolucion); 
        }
        return null;
    }
}
