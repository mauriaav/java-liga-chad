package com.info.servicios.seleccionadores.seleccionadorDeJugadores.impl;

import com.info.dominio.Jugador;
import com.info.servicios.seleccionadores.seleccionadorDeJugadores.SeleccionadorDeJugadores;

import java.util.List;
import java.util.Scanner;

public class SeleccionadorDeJugadoresImpl implements SeleccionadorDeJugadores {
    @Override
    public Jugador seleccionar(List<Jugador> jugadores, Scanner scanner){
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores disponibles.");
            return null;
        }

        System.out.println("--Jugadores Disponibles--");
        for (int i = 0; i < jugadores.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, jugadores.get(i).getNombre());
        }

        int opcion = -1;
        do {
            System.out.print("Seleccione un jugador (número): ");
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                if (opcion < 1 || opcion > jugadores.size()) {
                    System.out.println("Opción inválida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número válido.");
            }
        } while (opcion < 1 || opcion > jugadores.size());

        return jugadores.get(opcion - 1);
    }
}
