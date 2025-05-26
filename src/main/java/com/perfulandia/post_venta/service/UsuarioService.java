package com.perfulandia.post_venta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perfulandia.post_venta.model.Usuario;
import com.perfulandia.post_venta.repository.UsuarioRepository;
@Service
public class UsuarioService {
    @Autowired 
    private UsuarioRepository usuarioRepository;
        public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }
    public Usuario crearReclamo(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    public Usuario findById(int id) {
        return usuarioRepository.findById(id);
    }  
}
