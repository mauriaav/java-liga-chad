package com.info.servicios.seleccionadores.seleccionadorDeEquipos;

import com.info.dominio.Equipo;

import java.util.List;

public interface SeleccionadorDeEquipos {
    Equipo seleccionar(List<Equipo> equipos);
}
