package com.info.servicios.menu.impl;

import com.info.dominio.Equipo;
import com.info.salidautils.ImprimirEquipos;
import com.info.salidautils.ImprimirJugadoresDeEquipo;
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
    Scanner scanner ;

    public MenuServiceImpl (){
        this.scanner = new Scanner(System.in);
        this.equipoService = new EquipoServiceImpl(scanner);
        this.seleccionadorDeEquipos = new SeleccionadorDeEquiposImpl(scanner);
        this.partidoService = new PartidoServiceImpl(scanner);
        this.jugadorService = new JugadorServiceImpl(scanner);
        this.ligaChadService = new LigaChadServiceImpl(scanner);
    }

    @Override
    public int seleccionarOpcionMenu(){

        int condition = 0;

        do {
            System.out.println("INDIQUE UNA OPCION : ");
            System.out.println("1. Crear equipo");
            System.out.println("2. Obtener equipos");
            System.out.println("3. Crear jugador");
            System.out.println("4. Ver jugadores");
            System.out.println("5. Transferir jugadores");
            System.out.println("6. Jugar partido");
            System.out.println("7. Ver goleador de la liga");
            System.out.println("8. Ver promedio de gol de los equipos");
            System.out.println("9. Ver equipos por goles ");
            System.out.print("10. SALIR : ");

            condition = this.scanner.nextInt();
            ejecutarOpcion(condition);

        } while (condition != 10);
        scanner.close();
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
                jugadorService.crearJugador(seleccionadorDeEquipos.seleccionar(equipoService.getEquipos()));
                System.out.println("\n");
                break;
            case 4:
                System.out.println("\n");
                Equipo seleccionado = seleccionadorDeEquipos.seleccionar(equipoService.getEquipos());
                ImprimirJugadoresDeEquipo.imprimir(seleccionado.getJugadores());
                System.out.println("\n");
                break;
            case 5:
                System.out.println("\n");
                jugadorService.transferirJugadorEntreEquipos(equipoService.getEquipos());
                System.out.println("\n");
                break;
            case 6:
                System.out.println("\n");
                partidoService.crearPartido(equipoService.getEquipos());
                System.out.println("\n");
                break;
            case 7:
                System.out.println("\n");
                ligaChadService.goleadorDeLaLiga(equipoService.getEquipos());
                System.out.println("\n");
                break;
            case 8:
                System.out.println("\n");
                ligaChadService.promedioGol(equipoService.getEquipos());
                System.out.println("\n");
                break;
            case 9:
                System.out.println("\n");
                ImprimirEquipos.imprimirOrdenado(equipoService);
                System.out.println("\n");
                break;
            case 10:
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
