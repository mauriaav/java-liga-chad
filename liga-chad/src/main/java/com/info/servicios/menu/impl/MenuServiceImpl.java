package com.info.servicios.menu.impl;

import com.info.entradautils.CreadorDeEquipos;
import com.info.salidautils.ImprimirEquipos;
import com.info.servicios.gestorEquipo.EquipoService;
import com.info.servicios.gestorEquipo.impl.EquipoServiceImpl;
import com.info.servicios.menu.MenuService;
import java.util.Scanner;

public class MenuServiceImpl implements MenuService {

    private EquipoService equipoService;
    private CreadorDeEquipos creadorDeEquipos;
    Scanner scanner ;

    public MenuServiceImpl (){
        this.equipoService = new EquipoServiceImpl();
        this.scanner = new Scanner(System.in);

    }

    @Override
    public int seleccionarOpcionMenu(){

        int condition = 0;

        do {
            System.out.println("INDIQUE UNA OPCION : ");
            System.out.println("1. Crear equipo");
            System.out.println("2. Obtener equipos");
            System.out.print("3. SALIR : ");

            condition = this.scanner.nextInt();
            ejecutarOpcion(condition);

        } while (condition != 3);
        scanner.close();
        return condition;
    }

    @Override
    public void ejecutarOpcion(int opcion){
        switch (opcion) {
            case 1:
                System.out.println("\n");
                creadorDeEquipos = new CreadorDeEquipos(scanner);
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
                System.out.println("Adios.");
                System.out.println("\n");
                break;

            default:
                break;
        }

    }

}
