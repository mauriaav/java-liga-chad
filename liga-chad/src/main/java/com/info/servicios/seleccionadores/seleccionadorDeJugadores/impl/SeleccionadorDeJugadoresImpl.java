package com.info.servicios.seleccionadores.seleccionadorDeJugadores.impl;

import com.info.dominio.Jugador;
import com.info.entradautils.ValidadoresDeEntradas;
import com.info.servicios.seleccionadores.seleccionadorDeJugadores.SeleccionadorDeJugadores;

import java.util.List;
import java.util.Scanner;

public class SeleccionadorDeJugadoresImpl implements SeleccionadorDeJugadores {
    private final Scanner scanner;
    public SeleccionadorDeJugadoresImpl(Scanner scanner) {
        this.scanner = scanner;
    }
    @Override
    public Jugador seleccionar(List<Jugador> jugadores){
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores disponibles.");
            return null;
        }

        System.out.println("--Jugadores Disponibles--");
        for (int i = 0; i < jugadores.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, jugadores.get(i).getNombre());
        }
        int opcion = ValidadoresDeEntradas.leerEnteroRango(scanner,"Seleccione un jugador (número):",1,jugadores.size());
        return jugadores.get(opcion - 1);
    }
}
