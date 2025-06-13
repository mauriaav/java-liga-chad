package com.info.servicios.ligaChad.impl;

import com.info.dominio.Equipo;
import com.info.dominio.Jugador;
import com.info.servicios.gestorEquipo.EquipoService;
import com.info.servicios.gestorJugadores.JugadorService;
import com.info.servicios.ligaChad.LigaChadService;
import com.info.servicios.seleccionadores.seleccionadorDeEquipos.SeleccionadorDeEquipos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LigaChadServiceImpl implements LigaChadService {
    private Scanner scanner;
    private EquipoService equipoService;
    private SeleccionadorDeEquipos seleccionadorDeEquipos;
    private JugadorService jugadorService;

    public LigaChadServiceImpl(Scanner scanner){
        this.scanner = scanner;
    }
    @Override
    public void iniciarLiga(){
    }

    @Override
    public void goleadorDeLaLiga(List<Equipo> equipos){
        List<Jugador> jugadoresLiga = new ArrayList<>();
        for(Equipo equipo : equipos){
            jugadoresLiga.addAll(equipo.getJugadores());
        }
        Jugador goleador = jugadoresLiga.get(0);
        for(Jugador jugador : jugadoresLiga){
            if(jugador.getCantidadGoles()> goleador.getCantidadGoles()){
                goleador = jugador;
            }
        }
        System.out.println("El goleador es: " + goleador.getNombre() + " con " + goleador.getCantidadGoles() + " goles.");
    }

}
