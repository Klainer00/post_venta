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

    public Devolucion crearDevolucion(Devolucion Devolucion) {
        return devolucionesRepository.save(Devolucion);
    }


    public Devolucion actualizarDevolucion(int id, Devolucion datosNuevos) {
        Optional<Devolucion> optionalExistente = devolucionesRepository.findById(id);

        if (optionalExistente.isPresent()) {
            Devolucion devolucionExistente = optionalExistente.get();
            devolucionExistente.setEstado(datosNuevos.getEstado());
            devolucionExistente.setDescripcion(datosNuevos.getDescripcion());
            return devolucionesRepository.save(devolucionExistente);
        } else {

            return null;
        }
    }
}
