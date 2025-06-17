package com.info.servicios.menu.impl;

import com.info.dominio.Equipo;
import com.info.entradautils.ValidadoresDeEntradas;
import com.info.salidautils.ImprimirEquipos;
import com.info.servicios.gestorEquipo.EquipoService;
import com.info.servicios.gestorJugadores.JugadorService;
import com.info.servicios.menu.MenuService;


import java.util.Scanner;

public class MenuEquiposServiceImpl implements MenuService {

    private EquipoService equipoService;
    private JugadorService jugadorService;
    private final Scanner scanner ;

    public MenuEquiposServiceImpl(Scanner scanner, EquipoService equipoService, JugadorService jugadorService){
        this.scanner = scanner;
        this.equipoService = equipoService;
        this.jugadorService = jugadorService;
    }

    @Override
    public int seleccionarOpcionMenu(){
        int condition = 0;
        do {
            System.out.println("INDIQUE UNA OPCION : ");
            System.out.println("1. Crear equipo");
            System.out.println("2. Ver equipos");
            System.out.println("3. Volver");
            condition = ValidadoresDeEntradas.leerEnteroRango(scanner,"Selecciona una opción: ",1,3);
            ejecutarOpcion(condition);
        } while (condition != 3);
        return condition;
    }

    @Override
    public void ejecutarOpcion(int opcion){
        switch (opcion) {
            case 1:
                System.out.println("\n");
                Equipo nuevoEquipo=equipoService.crearEquipo();
                jugadorService.crearJugadores(nuevoEquipo);
                System.out.println("\n");
                break;
            case 2:
                System.out.println("\n");
                ImprimirEquipos.imprimir(equipoService);
                System.out.println("\n");
                break;
            case 3:
                System.out.println("\n");
                System.out.println("Volviendo.");
                System.out.println("\n");
                break;
            default:
                break;
        }

    }

}
