package com.perfulandia.post_venta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.perfulandia.post_venta.service.ProductoService;
import com.perfulandia.post_venta.service.VentaService;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {
    @Autowired
    private VentaService ventaService;
    @Autowired
    private ProductoService productoService;
    
    
}
