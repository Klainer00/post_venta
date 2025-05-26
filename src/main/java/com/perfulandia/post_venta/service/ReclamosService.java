package com.perfulandia.post_venta.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.perfulandia.post_venta.model.Reclamo;
import com.perfulandia.post_venta.repository.ReclamosRepository;

@Service
public class ReclamosService {
    private ReclamosRepository reclamosRepository;
    public ReclamosService(ReclamosRepository reclamosRepository) {
        this.reclamosRepository = reclamosRepository;
    }
    public List<Reclamo> findAll(){
        return reclamosRepository.findAll();
    }
    public Reclamo crearReclamo(Reclamo reclamo) {
        return reclamosRepository.save(reclamo);
    }
    public Reclamo findById(int id) {
        return reclamosRepository.findById(id);
    }   
}
