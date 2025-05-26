package com.perfulandia.post_venta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.perfulandia.post_venta.model.Reclamo;
import com.perfulandia.post_venta.model.Usuario;
import com.perfulandia.post_venta.service.ReclamosService;
import com.perfulandia.post_venta.service.UsuarioService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/reclamos")
public class ReclamosController {
    @Autowired
    private ReclamosService reclamosService;
    @Autowired
    private UsuarioService usuarioService;
    @GetMapping
    public ResponseEntity<List<Reclamo>> getAllReclamos() {
        List<Reclamo> reclamos = reclamosService.findAll();
        if (!reclamos.isEmpty()) {
            return new ResponseEntity<>(reclamos,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            
        }
    }
    @PostMapping("/crear/{id_usuario}")
public ResponseEntity<Reclamo> crearReclamo(@PathVariable int id_usuario, @RequestBody Reclamo reclamo) {
    Usuario buscar = usuarioService.findById(id_usuario);
    if (buscar != null) {
        // Asigna el usuario encontrado al reclamo antes de guardarlo.
        reclamo.setUsuario(buscar); 
        return new ResponseEntity<>(reclamosService.crearReclamo(reclamo), HttpStatus.CREATED);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // O NOT_ACCEPTABLE, pero NOT_FOUND es más común si el usuario no existe.
    }
}
    
}
