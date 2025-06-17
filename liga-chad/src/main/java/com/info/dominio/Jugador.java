package com.info.dominio;

public class Jugador {
    private String nombre;
    private Equipo equipo;
    private int edad;
    private int cantidadGoles;

    public Jugador(String nombre,  int edad, Equipo equipo){
        this.nombre = nombre;
        this.edad = edad;
        this.equipo = equipo;
        this.cantidadGoles = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public int getEdad() {
        return edad;
    }

    public int getCantidadGoles() {
        return cantidadGoles;
    }

    public void setEquipo(Equipo e){
        this.equipo = e;
    }

    public String getTipoJugador(){
        return "Libre";
    }

    public void agregarGol(){
        this.cantidadGoles++;
    }
}
