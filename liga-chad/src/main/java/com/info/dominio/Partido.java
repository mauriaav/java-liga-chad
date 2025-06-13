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
        this.resultado = new HashMap<>();
        this.golesPorJugador = new HashMap<>();
    }

    public Map<Equipo, Integer> getResultado() {
        return resultado;
    }

    public Map<Jugador, Integer> getGolesPorJugador() {
        return golesPorJugador;
    }

    public void sumarGolEquipo(Equipo e){
        int golesAcumulados = resultado.get(e);
        golesAcumulados += 1;
        this.resultado.put(e, golesAcumulados);
    }


    public void agregarGol(Jugador jugador){
        if(golesPorJugador.containsKey(jugador)){
            int golesAcumulados = golesPorJugador.get(jugador);
            golesAcumulados += 1;
            golesPorJugador.put(jugador, golesAcumulados);
        }else{
            golesPorJugador.put(jugador,1);
        }
        this.sumarGolEquipo(jugador.getEquipo());
    }
}
