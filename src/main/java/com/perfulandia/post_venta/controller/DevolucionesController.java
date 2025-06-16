package com.perfulandia.post_venta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.perfulandia.post_venta.model.Devolucion;
import com.perfulandia.post_venta.model.Venta;
import com.perfulandia.post_venta.service.DevolucionesService;
import com.perfulandia.post_venta.service.VentaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/devoluciones")
public class DevolucionesController {
    @Autowired
    private DevolucionesService devolucionesService;
    @Autowired
    private VentaService ventaService;

    @GetMapping
    public ResponseEntity<List<Devolucion>> getAll() {
        List<Devolucion> devoluciones = devolucionesService.findAll();
        if (!devoluciones.isEmpty()) {
            return new ResponseEntity<>(devoluciones, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }
    }

    @PostMapping("/crear/{id_venta}")
    public ResponseEntity<Devolucion> crearDevolucion(@PathVariable int id_venta, @RequestBody Devolucion devolucion) {
        Venta buscar = ventaService.findById(id_venta);
        if (buscar != null) {
            // Asigna la venta encontrada a la devolucion antes de guardarla.
            devolucion.setId_venta(buscar);
            return new ResponseEntity<>(devolucionesService.crearDevolucion(devolucion), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }

    }
    @GetMapping("/{idDevoluciones}")
    public ResponseEntity<Devolucion>getDevolucionById(@PathVariable int idDevoluciones){
        Devolucion devolucion = devolucionesService.findById(idDevoluciones);
        if (devolucion != null) {
            return ResponseEntity.ok(devolucion);

        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Devolucion> cambiarEstado(@PathVariable int id,@RequestBody Devolucion devolucionParaActualizar) {
        Devolucion devolucionActualizada = devolucionesService.cambiarEstado(id, devolucionParaActualizar);
    if (devolucionActualizada != null) {
        return ResponseEntity.ok(devolucionActualizada);
    } else {
        return ResponseEntity.notFound().build();
    }
}
}
