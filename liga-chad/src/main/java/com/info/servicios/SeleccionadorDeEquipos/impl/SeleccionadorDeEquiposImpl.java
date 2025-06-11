package com.info.servicios.SeleccionadorDeEquipos.impl;

import com.info.dominio.Equipo;
import com.info.servicios.SeleccionadorDeEquipos.SeleccionadorDeEquipos;

import java.util.List;
import java.util.Scanner;

public class SeleccionadorDeEquiposImpl implements SeleccionadorDeEquipos {
    @Override
    public Equipo seleccionar(List<Equipo> equipos, Scanner scanner) {
        if (equipos.isEmpty()) {
            System.out.println("No hay equipos disponibles.");
            return null;
        }

        System.out.println("--Equipos Disponibles--");
        for (int i = 0; i < equipos.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, equipos.get(i).getNombre());
        }

        int opcion = -1;
        do {
            System.out.print("Seleccione un equipo (número): ");
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                if (opcion < 1 || opcion > equipos.size()) {
                    System.out.println("Opción inválida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número válido.");
            }
        } while (opcion < 1 || opcion > equipos.size());

        return equipos.get(opcion - 1);
    }
}
