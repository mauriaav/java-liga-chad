package com.info.servicios.menu.impl;

import com.info.dominio.Jugador;
import com.info.dominio.JugadorTitular;
import com.info.entradautils.ValidadoresDeEntradas;
import com.info.salidautils.ImprimirEquipos;
import com.info.salidautils.ImprimirJugadoresPlano;
import com.info.servicios.gestorEquipo.EquipoService;
import com.info.servicios.ligaChad.LigaChadService;
import com.info.servicios.menu.MenuService;
import java.util.Scanner;

public class MenuEstadisticasServiceImpl implements MenuService {

    private EquipoService equipoService;
    private LigaChadService ligaChadService;
    private final Scanner scanner ;

    public MenuEstadisticasServiceImpl(Scanner scanner, EquipoService equipoService, LigaChadService ligaChadService){
        this.scanner = scanner;
        this.equipoService = equipoService;
        this.ligaChadService = ligaChadService;
    }

    @Override
    public int seleccionarOpcionMenu(){
        if(equipoService.getEquipos() == null ||equipoService.getEquipos().isEmpty()){
            System.out.println("No hay equipos para mostrar estadísticas, por lo menos cree 1.");
            return 0;
        }
        int condition = 0;
        do {
            System.out.println("1. Ver goleador de la liga");
            System.out.println("2. Ver promedio de gol de los equipos");
            System.out.println("3. Ver equipos por goles ");
            System.out.println("4. Ver jugadores que no ingresaron");
            System.out.println("5. Jugador con más minutos");
            System.out.println("6. Volver");
            condition = ValidadoresDeEntradas.leerEnteroRango(scanner,"Selecciona una opción: ",1,6);
            ejecutarOpcion(condition);
        } while (condition != 6);
        return condition;
    }

    @Override
    public void ejecutarOpcion(int opcion){
        switch (opcion) {
            case 1:
                System.out.println("\n");
                ligaChadService.goleadorDeLaLiga(equipoService.getEquipos());
                System.out.println("\n");
                break;
            case 2:
                System.out.println("\n");
                ligaChadService.promedioGol(equipoService.getEquipos());
                System.out.println("\n");
                break;
            case 3:
                System.out.println("\n");
                ImprimirEquipos.imprimirOrdenado(equipoService);
                System.out.println("\n");
                break;
            case 4:
                System.out.println("\n");
                ImprimirJugadoresPlano.imprimir(equipoService.suplentesQueNoIngresaron());
                System.out.println("\n");
                break;
            case 5:
                System.out.println("\n");
                System.out.println("El jugador con más minutos es: " + equipoService.jugadorConMasMinutos().getNombre() +
                        " con " + ((JugadorTitular) equipoService.jugadorConMasMinutos()).getMinutosJugados() + " minutos jugados.");
                System.out.println("\n");
                break;
            case 6:
                System.out.println("\n");
                System.out.println("Volviendo.");
                System.out.println("\n");
                break;
            default:
                break;
        }

    }

}
