package com.info.servicios.gestorEquipo;

import com.info.dominio.Equipo;
import com.info.dominio.Jugador;

import java.util.List;

public interface EquipoService {
    Equipo crearEquipo();
    List<Equipo> getEquipos();
    int calcularGolesEquipo(Equipo equipo);
    Equipo crearEquipoTest(String nombre);
    List<Equipo> equiposOrdenados();
    List<Jugador> suplentesQueNoIngresaron();
    Jugador jugadorConMasMinutos();
}
