package com.info.salidautils;

import com.info.dominio.Jugador;
import com.info.dominio.JugadorSuplente;
import com.info.dominio.JugadorTitular;

import java.util.List;

public class ImprimirJugadoresDeEquipo {
    public static void imprimir(List<Jugador> jugadores){
        System.out.println("-------Titulares-------");
        for(Jugador jugador : jugadores){
            if(jugador.getTipoJugador().equals("Titular")){
                JugadorTitular jugadorTitular = (JugadorTitular) jugador;
                System.out.println(jugadorTitular.getNombre() + " " +
                        "edad: " + jugadorTitular.getEdad() + " " +
                        "goles: " + jugadorTitular.getCantidadGoles() + " " +
                        "total minutos jugados: " + jugadorTitular.getMinutosJugados());
            }
        }
        System.out.println("-------Suplentes-------");
        for(Jugador jugador : jugadores){
            if(jugador.getTipoJugador().equals("Suplente")){
                JugadorSuplente jugadorSuplente = (JugadorSuplente) jugador;
                System.out.println(jugadorSuplente.getNombre() + " " +
                        "edad: " + jugadorSuplente.getEdad() + " " +
                        "goles: " + jugadorSuplente.getCantidadGoles() + " "+
                        "partidos que ingresó: " + jugadorSuplente.getpartidosIngresados());
            }
        }
    }
}
