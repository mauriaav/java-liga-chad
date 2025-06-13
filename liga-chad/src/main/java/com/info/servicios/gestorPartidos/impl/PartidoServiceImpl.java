package com.info.servicios.gestorPartidos.impl;

import com.info.dominio.*;
import com.info.entradautils.CrearGolesUtil;
import com.info.servicios.gestorJugadores.JugadorService;
import com.info.servicios.gestorJugadores.impl.JugadorServiceImpl;
import com.info.servicios.gestorPartidos.PartidoService;
import com.info.servicios.menu.MenuService;
import com.info.servicios.menu.impl.MenuSiNoImpl;
import com.info.servicios.seleccionadores.seleccionadorDeEquipos.SeleccionadorDeEquipos;
import com.info.servicios.seleccionadores.seleccionadorDeEquipos.impl.SeleccionadorDeEquiposImpl;
import com.info.servicios.seleccionadores.seleccionadorDeJugadores.SeleccionadorDeJugadores;
import com.info.servicios.seleccionadores.seleccionadorDeJugadores.impl.SeleccionadorDeJugadoresImpl;

import java.util.*;

public class PartidoServiceImpl implements PartidoService {
    private final SeleccionadorDeEquipos seleccionadorDeEquipos;
    private final SeleccionadorDeJugadores seleccionadorDeJugadores;
    private final JugadorService jugadorService;
    private final CrearGolesUtil crearGolesUtil;
    private final MenuService siNoMenu;
    private final Scanner scanner;

    public PartidoServiceImpl(Scanner scanner){
        this.seleccionadorDeEquipos = new SeleccionadorDeEquiposImpl(scanner);
        this.seleccionadorDeJugadores = new SeleccionadorDeJugadoresImpl(scanner);
        this.crearGolesUtil = new CrearGolesUtil(scanner);
        this.jugadorService = new JugadorServiceImpl(scanner);
        this.siNoMenu = new MenuSiNoImpl(scanner);
        this.scanner = scanner;
    }

    @Override
    public Partido crearPartido(List<Equipo> equipos){
        if (equipos == null || equipos.isEmpty()||equipos.size()<2){
            System.out.println("No hay equipos para que jueguen un partido.");
            return null;
        }
        System.out.println("Seleccione el equipo local:");
        Equipo equipoLocal = seleccionadorDeEquipos.seleccionar(equipos);
        if(noTieneJugadoresDisponibles(equipoLocal)){
            return null;
        }
        List<Equipo> posiblesVisitantes = new ArrayList<>(equipos);
        posiblesVisitantes.remove(equipoLocal);

        System.out.println("Seleccione el equipo visitante:");
        Equipo equipoVisitante = seleccionadorDeEquipos.seleccionar(posiblesVisitantes);
        if(noTieneJugadoresDisponibles(equipoVisitante)){
            return null;
        }

        System.out.println("\nCuántos goles hizo el local?");
        int golesLocal = crearGolesUtil.crearGol();
        Map<Jugador,Integer> golesPorJugador = new HashMap<>(this.quienHizoGoles(equipoLocal,golesLocal));
        this.minutosEIngresos(equipoLocal);

        System.out.println("\nCuántos goles hizo el vistante?");
        int golesVisitante = crearGolesUtil.crearGol();
        golesPorJugador.putAll(this.quienHizoGoles(equipoVisitante,golesVisitante));
        this.minutosEIngresos(equipoVisitante);


        Map<Equipo,Integer> resultado = new HashMap<>();
        resultado.put(equipoLocal,golesLocal);
        resultado.put(equipoVisitante,golesVisitante);
        Partido nuevoPartido = new Partido(equipoLocal, equipoVisitante,resultado,golesPorJugador);
        equipoLocal.agregarPartido(nuevoPartido);
        equipoVisitante.agregarPartido(nuevoPartido);
        return nuevoPartido;

    }

    public Map<Jugador,Integer> quienHizoGoles(Equipo e, int goles) {
        Map<Jugador, Integer> golesPorJugador = new HashMap<>();
        System.out.println();
        System.out.println("Quién hizo los goles de " + e.getNombre()+"?");
        for (int i = 1; i <= goles; i++){
            System.out.println("Gol número " + i +".\nLo hizo: ");
            Jugador autorGol = seleccionadorDeJugadores.seleccionar(e.getJugadores());
            autorGol.agregarGol();
            golesPorJugador.put(autorGol, golesPorJugador.getOrDefault(autorGol, 0) + 1);
        }
        return golesPorJugador;

    }

    public boolean noTieneJugadoresDisponibles(Equipo equipo){
        if(equipo.getJugadores() == null||equipo.getJugadores().isEmpty()){
            System.out.println(equipo.getNombre() + " no tiene jugadores suficientes para disputar el partido");
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public void minutosEIngresos(Equipo equipo){
        List<Jugador> titulares = jugadorService.jugadoresTitular(equipo);
        List<Jugador> suplentes = jugadorService.jugadoresSuplentes(equipo);
        if(suplentes == null || suplentes.isEmpty()){
            System.out.println("No hay jugadores para hacer cambios.");
            return;
        }
        for (Jugador titular : titulares){
            ((JugadorTitular) titular).agregarMinutosJugados(90);
        }
        System.out.println("Ingresó algún suplente?");
        int condition = 0;
        if (siNoMenu.seleccionarOpcionMenu()==1){
            do{
                if(titulares.isEmpty()){
                    System.out.println("No hay más jugadores para hacer cambios.");
                    return;
                }

                System.out.println("Qué jugador salió?");
                JugadorTitular jugadorRetirado =  (JugadorTitular) seleccionadorDeJugadores.seleccionar(titulares);
                titulares.remove(jugadorRetirado);
                System.out.println("En qué minuto (m) salió? ");
                int minutoSalida = scanner.nextInt();
                scanner.nextLine();//agregar validador de entero positivo
                jugadorRetirado.restarMinutosJugados(90-minutoSalida);
                System.out.println("Qué jugador ingresó?");
                JugadorSuplente jugadorIngresado = (JugadorSuplente)seleccionadorDeJugadores.seleccionar(suplentes);
                suplentes.remove(jugadorIngresado);
                jugadorIngresado.agregarPartidosIngresados();

                System.out.println("Hubo algún otro cambio?");
                condition = siNoMenu.seleccionarOpcionMenu();
            }while (condition!=2);
        }
    }
}
