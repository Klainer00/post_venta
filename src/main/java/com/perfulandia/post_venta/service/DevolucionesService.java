package com.perfulandia.post_venta.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perfulandia.post_venta.model.Devolucion;
import com.perfulandia.post_venta.repository.DevolucionRepository;

@Service
public class DevolucionesService {
    @Autowired
    private DevolucionRepository devolucionesRepository;

    public List<Devolucion> findAll() {
        return devolucionesRepository.findAll();
    }

    public Devolucion findById(int id) {
        return devolucionesRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No se encontró una devolución con el ID: " + id));
    }

    public Devolucion crearDevolucion(Devolucion devolucion) {
        if (devolucion == null) {
            throw new IllegalArgumentException("La devolucion no puede ser nula");
        }
        List<Devolucion> devoluciones = devolucionesRepository.findAll();
        for (Devolucion d : devoluciones) {
            if (d.getId_venta() == devolucion.getId_venta()) {
                throw new IllegalArgumentException(
                        "Ya existe una devolución : " + devolucion.getIdDevoluciones());
            }
        }
        return devolucionesRepository.save(devolucion);
    }

    public Devolucion cambiarEstado(int id, Devolucion nuevoEstadoObj) {
        Devolucion buscarDevolucion = this.findById(id);
        if (buscarDevolucion != null) {
            buscarDevolucion.setEstado(nuevoEstadoObj.getEstado());
            return devolucionesRepository.save(buscarDevolucion);
        }
        return null;
    }
}
