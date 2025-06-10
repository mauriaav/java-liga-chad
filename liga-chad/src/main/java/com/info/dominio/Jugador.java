package com.info.dominio;

public class Jugador {
    private String nombre;
    private Equipo equipo;
    private int edad;
    private int cantidadGoles;

    public Jugador(String nombre,  int edad){
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo e){
        this.equipo = e;
    }

    public int getEdad() {
        return edad;
    }

    public int getCantidadGoles() {
        return cantidadGoles;
    }

    public void agregarGoles(int goles){
        this.cantidadGoles += goles;
    }
}
