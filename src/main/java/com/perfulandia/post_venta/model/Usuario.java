package com.perfulandia.post_venta.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name =  "usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // para marcar que la id sea auto increment
    @Column(unique = true)//indica el atributo de abajo
    private int id_usuario;
    @Column(length = 13 , nullable = false)
    private String rut;
    @Column (length = 30, nullable = false)
    private String nombre;
    @Column(length = 30, nullable =false)
    private String p_apellido;
    @Column(length = 30, nullable =false)
    private String s_apellido;
    @Column(length = 20, nullable = false)
    private String usuario;
    @Column(length = 40, nullable = false)
    private String contrasenna;
    @Column(length = 50, nullable =false)
    private String correo;
    @Column(length = 50, nullable =false)
    private String direccion;    
    @Column(nullable = false)
    private int permiso;
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL,orphanRemoval = true)
    //@JsonManagedReference("usuario-reclamo")
    @JsonIgnore
    private List<Reclamo> reclamosList;
@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL,orphanRemoval = true)
//@JsonManagedReference("usuario-venta") // <-- ¡Añádele un nombre único aquí!
@JsonIgnore

private List<Venta> ventasList;

}
