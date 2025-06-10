package com.info.dominio;

import java.util.ArrayList;
import java.util.List;
public class Equipo {
    private String nombre;
    private List<Jugador> jugadores;
    private List<Partido> partidosJugados ;

    public Equipo(String nombre){
        this.nombre = nombre;
        this.jugadores = new ArrayList<>();
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Partido> getPartidosJugados() {
        return partidosJugados;
    }

    public void agregarJugadores(List<Jugador> listaJugadores){
        this.jugadores.addAll(listaJugadores);
    }

    public void agregarJugador( Jugador nuevoJugador){
        System.out.println("Se agregó el jugador " + nuevoJugador.getNombre() + " a "+ this.getNombre() );
        this.jugadores.add(nuevoJugador);
    }
}
