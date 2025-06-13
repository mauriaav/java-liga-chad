package com.info.servicios.gestorEquipo;

import com.info.dominio.Equipo;

import java.util.List;

public interface EquipoService {
    Equipo crearEquipo();
    List<Equipo> getEquipos();
    int calcularGolesEquipo(Equipo equipo);
    void crearEquipoTest();
    List<Equipo> equiposOrdenados();
}
