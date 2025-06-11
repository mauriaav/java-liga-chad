package com.info.dominio;

public class JugadorSuplente extends Jugador{
    private int partidosIngresados;
    public JugadorSuplente(String nombre, int edad,Equipo equipo){
        super(nombre,edad,equipo);
        this.partidosIngresados = 0;
    }

    public int getpartidosIngresados() {
        return partidosIngresados;
    }

    public String getTipoJugador(){
        return "Titular";
    }

    public void agregarPartidosIngresados(){
        this.partidosIngresados += 1;
    }
}
