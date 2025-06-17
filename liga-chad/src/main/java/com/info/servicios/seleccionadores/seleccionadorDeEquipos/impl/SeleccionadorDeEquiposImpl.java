package com.info.servicios.seleccionadores.seleccionadorDeEquipos.impl;

import com.info.dominio.Equipo;
import com.info.entradautils.ValidadoresDeEntradas;
import com.info.servicios.seleccionadores.seleccionadorDeEquipos.SeleccionadorDeEquipos;

import java.util.List;
import java.util.Scanner;

public class SeleccionadorDeEquiposImpl implements SeleccionadorDeEquipos {
    private final Scanner scanner;

    public SeleccionadorDeEquiposImpl(Scanner scanner){
        this.scanner = scanner;
    }
    @Override
    public Equipo seleccionar(List<Equipo> equipos) {
        if ( equipos == null ||equipos.isEmpty()) {
            System.out.println("No hay equipos disponibles.");
            return null;
        }

        System.out.println("--Equipos Disponibles--");
        for (int i = 0; i < equipos.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, equipos.get(i).getNombre());
        }

        int opcion = ValidadoresDeEntradas.leerEnteroRango(scanner,"Seleccione un equipo (número): ",1,equipos.size());
        return equipos.get(opcion - 1);
    }
}
