package com.info.salidautils;

import com.info.dominio.Jugador;

import java.util.List;

public class ImprimirJugadoresDeEquipo {
    public static void imprimir(List<Jugador> jugadores){
        System.out.println("-------Titulares-------");
        for(Jugador jugador : jugadores){
            if(jugador.getTipoJugador().equals("Titular")){
                System.out.println(jugador.getNombre() + " edad: " + jugador.getEdad());
            }
        }
        System.out.println("-------Suplentes-------");
        for(Jugador jugador : jugadores){
            if(jugador.getTipoJugador().equals("Suplente")){
                System.out.println(jugador.getNombre() + " edad: " + jugador.getEdad());
            }
        }
    }
}
