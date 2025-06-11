package com.info.dominio;

public class JugadorTitular extends Jugador{
    private int minutosJugados;

    public JugadorTitular(String nombre, int edad, Equipo equipo) {
        super(nombre, edad, equipo);
        this.minutosJugados = 0;
    }

    public int getMinutosJugados() {
        return minutosJugados;
    }

    public String getTipoJugador(){
        return "Titular";
    }

    public void agregarMinutosJugados(int minutos){
        this.minutosJugados += minutos;
    }
}
