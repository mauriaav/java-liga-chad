package com.info.servicios.gestorPartidos;

import com.info.dominio.Equipo;
import com.info.dominio.Partido;

import java.util.List;

public interface PartidoService {
    Partido crearPartido(List<Equipo> equipos);
}
