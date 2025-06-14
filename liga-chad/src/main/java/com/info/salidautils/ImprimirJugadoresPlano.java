package com.info.salidautils;

import com.info.dominio.Jugador;
import com.info.dominio.JugadorTitular;

import java.util.List;

public class ImprimirJugadoresPlano {
    public static void imprimir(List<Jugador> jugadores){
        for(Jugador jugador : jugadores){
            System.out.println(jugador.getNombre() + " " +
                    "edad: " + jugador.getEdad() + " " +
                    "goles: " + jugador.getCantidadGoles() +
                    " equipo: " + jugador.getEquipo().getNombre());
        }
    }
}
