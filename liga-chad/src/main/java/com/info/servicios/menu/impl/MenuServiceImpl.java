package com.info.servicios.menu.impl;

import com.info.entradautils.CreadorDeEquiposUtil;
import com.info.salidautils.ImprimirEquipos;
import com.info.servicios.SeleccionadorDeEquipos.SeleccionadorDeEquipos;
import com.info.servicios.SeleccionadorDeEquipos.impl.SeleccionadorDeEquiposImpl;
import com.info.servicios.gestorEquipo.EquipoService;
import com.info.servicios.gestorEquipo.impl.EquipoServiceImpl;
import com.info.servicios.gestorJugadores.JugadorService;
import com.info.servicios.gestorJugadores.impl.JugadorServiceImpl;
import com.info.servicios.menu.MenuService;
import java.util.Scanner;

public class MenuServiceImpl implements MenuService {

    private EquipoService equipoService;
    private CreadorDeEquiposUtil creadorDeEquipos;
    private SeleccionadorDeEquipos seleccionadorDeEquipos;
    private JugadorService jugadorService;
    Scanner scanner ;

    public MenuServiceImpl (){
        this.equipoService = new EquipoServiceImpl();
        this.scanner = new Scanner(System.in);
        this.seleccionadorDeEquipos = new SeleccionadorDeEquiposImpl();
        this.jugadorService = new JugadorServiceImpl(scanner);
    }

    @Override
    public int seleccionarOpcionMenu(){

        int condition = 0;

        do {
            System.out.println("INDIQUE UNA OPCION : ");
            System.out.println("1. Crear equipo");
            System.out.println("2. Obtener equipos");
            System.out.println("3. Crear jugador");
            System.out.print("4. SALIR : ");

            condition = this.scanner.nextInt();
            ejecutarOpcion(condition);

        } while (condition != 4);
        scanner.close();
        return condition;
    }

    @Override
    public void ejecutarOpcion(int opcion){
        switch (opcion) {
            case 1:
                System.out.println("\n");
                creadorDeEquipos = new CreadorDeEquiposUtil(scanner);
                equipoService.crearEquipo(creadorDeEquipos.crearEquipo());
                System.out.println("\n");
                break;
            case 2:
                System.out.println("\n");
                ImprimirEquipos.imprimir(equipoService.getEquipos());
                System.out.println("\n");
                break;
            case 3:
                System.out.println("\n");
                jugadorService.crearJugador(seleccionadorDeEquipos.seleccionar(equipoService.getEquipos(),scanner));
                System.out.println("\n");
                break;
            case 4:
                System.out.println("\n");
                System.out.println("Adios.");
                System.out.println("\n");
                break;

            default:
                break;
        }

    }

}
