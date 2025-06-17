package com.info.servicios.menu.impl;

import com.info.dominio.Equipo;
import com.info.entradautils.ValidadoresDeEntradas;
import com.info.salidautils.ImprimirEquipos;
import com.info.salidautils.ImprimirJugadoresDeEquipo;
import com.info.servicios.gestorEquipo.EquipoService;
import com.info.servicios.gestorJugadores.JugadorService;
import com.info.servicios.menu.MenuService;
import com.info.servicios.seleccionadores.seleccionadorDeEquipos.SeleccionadorDeEquipos;

import java.util.Scanner;

public class MenuJugadoresServiceImpl implements MenuService {

    private EquipoService equipoService;
    private JugadorService jugadorService;
    private SeleccionadorDeEquipos seleccionadorDeEquipos;
    private final Scanner scanner ;

    public MenuJugadoresServiceImpl(Scanner scanner, EquipoService equipoService, JugadorService jugadorService, SeleccionadorDeEquipos seleccionadorDeEquipos){
        this.scanner = scanner;
        this.equipoService = equipoService;
        this.jugadorService = jugadorService;
        this.seleccionadorDeEquipos = seleccionadorDeEquipos;
    }

    @Override
    public int seleccionarOpcionMenu(){
        int condition = 0;
        do {
            System.out.println("1. Crear jugador");
            System.out.println("2. Ver jugadores");
            System.out.println("3. Transferir jugadores");
            System.out.println("4. Volver");
            condition = ValidadoresDeEntradas.leerEnteroRango(scanner,"Selecciona una opción: ",1,4);
            ejecutarOpcion(condition);
        } while (condition != 4);
        return condition;
    }

    @Override
    public void ejecutarOpcion(int opcion){
        switch (opcion) {
            case 1:
                System.out.println("\n");
                jugadorService.crearJugador(seleccionadorDeEquipos.seleccionar(equipoService.getEquipos()));
                System.out.println("\n");
                break;
            case 2:
                System.out.println("\n");
                ImprimirJugadoresDeEquipo.imprimir(seleccionadorDeEquipos.seleccionar(equipoService.getEquipos()).getJugadores());
                System.out.println("\n");
                break;
            case 3:
                System.out.println("\n");
                jugadorService.transferirJugadorEntreEquipos(equipoService.getEquipos());
                System.out.println("\n");
                break;
            case 4:
                System.out.println("\n");
                System.out.println("Volviendo.");
                System.out.println("\n");
                break;
            default:
                break;
        }

    }

}
