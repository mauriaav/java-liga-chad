package com.info.servicios.gestorJugadores;

import com.info.dominio.Equipo;
import com.info.dominio.Jugador;

import java.util.List;

public interface JugadorService {
    void crearJugador(Equipo equipo);
    void crearJugadores(Equipo equipo);
    void transferirJugadorEntreEquipos(List<Equipo> equipos);
    void crearJugadoresTest(Equipo equipo);
    List<Jugador> jugadoresTitular(Equipo equipo);
    List<Jugador> jugadoresSuplentes(Equipo equipo);
}
