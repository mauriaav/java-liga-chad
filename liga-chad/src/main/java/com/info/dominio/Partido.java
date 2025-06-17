package com.info.dominio;

import java.util.HashMap;
import java.util.Map;

public class Partido {
    private Equipo local;
    private Equipo visitante;
    private Map<Equipo, Integer> resultado;
    private Map<Jugador, Integer> golesPorJugador;

    public Partido(Equipo local, Equipo visitante, Map<Equipo,Integer> resultado, Map<Jugador,Integer> golesPorJugador) {
        this.local = local;
        this.visitante = visitante;
        this.resultado = resultado;
        this.golesPorJugador = golesPorJugador;
    }

    public Map<Equipo, Integer> getResultado() {
        return resultado;
    }
}
