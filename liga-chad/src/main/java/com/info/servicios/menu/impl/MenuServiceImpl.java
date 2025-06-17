package com.info.servicios.menu.impl;

import com.info.entradautils.ValidadoresDeEntradas;
import com.info.servicios.generadorCSV.GeneradorCVSService;
import com.info.servicios.generadorCSV.impl.GeneradorCVSServiceImpl;
import com.info.servicios.gestorPartidos.PartidoService;
import com.info.servicios.gestorPartidos.impl.PartidoServiceImpl;
import com.info.servicios.ligaChad.LigaChadService;
import com.info.servicios.ligaChad.impl.LigaChadServiceImpl;
import com.info.servicios.seleccionadores.seleccionadorDeEquipos.SeleccionadorDeEquipos;
import com.info.servicios.seleccionadores.seleccionadorDeEquipos.impl.SeleccionadorDeEquiposImpl;
import com.info.servicios.gestorEquipo.EquipoService;
import com.info.servicios.gestorEquipo.impl.EquipoServiceImpl;
import com.info.servicios.gestorJugadores.JugadorService;
import com.info.servicios.gestorJugadores.impl.JugadorServiceImpl;
import com.info.servicios.menu.MenuService;
import java.util.Scanner;

public class MenuServiceImpl implements MenuService {

    private EquipoService equipoService;
    private SeleccionadorDeEquipos seleccionadorDeEquipos;
    private JugadorService jugadorService;
    private PartidoService partidoService;
    private LigaChadService ligaChadService;
    private MenuService MenuEquipo;
    private MenuService MenuJugador;
    private MenuService MenuEstadisticas;
    GeneradorCVSService generadorCVSService;
    Scanner scanner ;

    public MenuServiceImpl (){
        this.scanner = new Scanner(System.in);
        this.equipoService = new EquipoServiceImpl(scanner);
        this.seleccionadorDeEquipos = new SeleccionadorDeEquiposImpl(scanner);
        this.partidoService = new PartidoServiceImpl(scanner);
        this.jugadorService = new JugadorServiceImpl(scanner);
        this.ligaChadService = new LigaChadServiceImpl(scanner);
        this.generadorCVSService = new GeneradorCVSServiceImpl();
        this.MenuEquipo = new MenuEquiposServiceImpl(scanner,equipoService,jugadorService);
        this.MenuJugador = new MenuJugadoresServiceImpl(scanner,equipoService,jugadorService,seleccionadorDeEquipos);
        this.MenuEstadisticas = new MenuEstadisticasServiceImpl(scanner,equipoService,ligaChadService);
    }

    @Override
    public int seleccionarOpcionMenu(){

        int condition = 0;

        do {
            System.out.println("INDIQUE UNA OPCION : ");
            System.out.println("1. Gestionar equipos");
            System.out.println("2. Gestionar jugadores");
            System.out.println("3. Jugar partido");
            System.out.println("4. Estadísticas");
            System.out.println("5. Descargar CSV de equipo");
            System.out.println("6. SALIR : ");

            condition = ValidadoresDeEntradas.leerEnteroPositivo(scanner,"Seleccione una opción: ");
            ejecutarOpcion(condition);

        } while (condition != 6);
        scanner.close();
        return condition;
    }

    @Override
    public void ejecutarOpcion(int opcion){
        switch (opcion) {
            case 1:
                System.out.println("\n");
                MenuEquipo.seleccionarOpcionMenu();
                System.out.println("\n");
                break;
            case 2:
                System.out.println("\n");
                MenuJugador.seleccionarOpcionMenu();
                System.out.println("\n");
                break;
            case 3:
                System.out.println("\n");
                partidoService.crearPartido(equipoService.getEquipos());
                System.out.println("\n");
                break;
            case 4:
                System.out.println("\n");
                MenuEstadisticas.seleccionarOpcionMenu();
                System.out.println("\n");
                break;
            case 5:
                System.out.println("\n");
                generadorCVSService.exportarDatos(seleccionadorDeEquipos.seleccionar(equipoService.getEquipos()));
                System.out.println("\n");
                break;
            case 6:
                System.out.println("\n");
                System.out.println("Adios.");
                System.out.println("\n");
                break;
            case 99:
                System.out.println("\n");
                equipoService.crearEquipoTest();
                jugadorService.crearJugadoresTest(equipoService.getEquipos().get(0));
                jugadorService.crearJugadoresTest(equipoService.getEquipos().get(1));
                System.out.println("\n");
                break;

            default:
                break;
        }

    }

}
