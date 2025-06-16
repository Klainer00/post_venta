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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVenta;
    @Column(nullable = false)
    private LocalDate fecha; // Fecha de la venta
    @ManyToOne()
    @JoinColumn(name = "id_producto" )
    @JsonBackReference // Aquí se evita la serialización en la parte "muchos"
    private Producto producto;
    @ManyToOne()
    @JoinColumn(name = "id_usuario" )
    @JsonBackReference("usuario-venta") // Aquí se evita la serialización en la parte "muchos"
    private Usuario usuario; 
}
