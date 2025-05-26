package com.perfulandia.post_venta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.perfulandia.post_venta.model.Usuario;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    List<Usuario> findAll();
    @SuppressWarnings("unchecked")
    Usuario findById(int id);
    Usuario save(Usuario usuario);
}
