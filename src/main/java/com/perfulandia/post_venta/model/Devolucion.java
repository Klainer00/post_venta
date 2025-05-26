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
@Table(name = "devoluciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Devolucion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDevoluciones;
    @Column(nullable = false)
    private String descripcion; // Motivo de la devolución
    @Column(nullable = false)
    private LocalDate fecha; // Fecha de la devolución
    @Column(nullable = false)
    private int estado;// 1 para pendiente, 2 para aceptada, 3 para rechazada

    @ManyToOne()
    @JoinColumn(name = "id_venta" , nullable = false)
    private Venta venta;
     

}
