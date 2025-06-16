package com.perfulandia.post_venta.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // para marcar que la id sea auto increment
    @Column(unique = true)//indica el atributo de abajo
    private int id_usuario;
    @Column(length = 13 , nullable = false)
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL,orphanRemoval = true)
    //@JsonManagedReference("usuario-reclamo")
    @JsonIgnore
    private List<Reclamo> reclamosList;
@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL,orphanRemoval = true)
//@JsonManagedReference("usuario-venta") // <-- ¡Añádele un nombre único aquí!
@JsonIgnore

private List<Venta> ventasList;

}
