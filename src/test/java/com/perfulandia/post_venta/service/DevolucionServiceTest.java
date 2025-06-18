package com.perfulandia.post_venta.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.perfulandia.post_venta.model.Devolucion;
import com.perfulandia.post_venta.model.EnumEstado;
import com.perfulandia.post_venta.model.Venta;
import com.perfulandia.post_venta.repository.DevolucionRepository;

public class DevolucionServiceTest {
@Mock
private DevolucionRepository devolucionRepository;
@InjectMocks
private DevolucionesService devolucionService;
@BeforeEach
public void setUp() {
    MockitoAnnotations.openMocks(this);
    
}
@Test
void testListarDevolucion() {
    Venta v1= new Venta(1, null, null, null);
    Venta v2 = new Venta(2, null, null, null);

    Devolucion d1 = new Devolucion(1,"ta malo",LocalDate.now(), EnumEstado.PENDIENTE, v1);
    Devolucion d2 = new Devolucion(2,"ta malo",LocalDate.now(), EnumEstado.PENDIENTE, v2);
    when(devolucionRepository.findAll()).thenReturn(Arrays.asList(d1,d2));

    List<Devolucion> listaDevoluciones = devolucionService.findAll();
    assertThat(listaDevoluciones).hasSize(2).contains(d1, d2); 
    verify(devolucionRepository).findAll();
    
}
@Test
void testCrearDevolucionExitoso() {
    Venta v1 = new Venta(1, null, null, null);
    Devolucion nuevaDevolucion = new Devolucion(1, "Producto defectuoso", LocalDate.now(), EnumEstado.PENDIENTE, v1);

    when(devolucionRepository.findAll()).thenReturn(Arrays.asList());
    when(devolucionRepository.save(nuevaDevolucion)).thenReturn(nuevaDevolucion);

    Devolucion resultado = devolucionService.crearDevolucion(nuevaDevolucion);

    assertThat(resultado).isNotNull();
    assertThat(resultado).isEqualTo(nuevaDevolucion);
    verify(devolucionRepository).findAll();
    verify(devolucionRepository).save(nuevaDevolucion);
}


}