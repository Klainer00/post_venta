package com.perfulandia.post_venta.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.perfulandia.post_venta.model.Venta;
import com.perfulandia.post_venta.repository.VentaRepository;

@Service
public class VentaService {
    private VentaRepository ventaRepository;
    public VentaService(VentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }
    public List<Venta> findAll() {
        return ventaRepository.findAll();
    }
    public Venta crearVenta(Venta venta) {
        return ventaRepository.save(venta);
    }
    public Venta findById(int id) {
        return ventaRepository.findById(id);
    }
}
