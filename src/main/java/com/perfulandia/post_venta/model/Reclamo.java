package com.perfulandia.post_venta.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "reclamos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reclamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReclamos;    
    @Column(length = 200, nullable = false)
    private String descripcion;
    @Column(nullable = false)
    private LocalDate fecha;
    @ManyToOne()
    @JoinColumn(name = "id_usuario" )
   // @JsonBackReference("usuario-reclamo")  // Aquí se evita la serialización en la parte "muchos"
    private Usuario usuario;
    
}
