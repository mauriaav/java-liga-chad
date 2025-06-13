package com.info.servicios.gestorPartidos.impl;

import com.info.dominio.Equipo;
import com.info.dominio.Jugador;
import com.info.dominio.Partido;
import com.info.entradautils.CrearGolesUtil;
import com.info.servicios.gestorPartidos.PartidoService;
import com.info.servicios.seleccionadores.seleccionadorDeEquipos.SeleccionadorDeEquipos;
import com.info.servicios.seleccionadores.seleccionadorDeEquipos.impl.SeleccionadorDeEquiposImpl;
import com.info.servicios.seleccionadores.seleccionadorDeJugadores.SeleccionadorDeJugadores;
import com.info.servicios.seleccionadores.seleccionadorDeJugadores.impl.SeleccionadorDeJugadoresImpl;

import java.util.*;

public class PartidoServiceImpl implements PartidoService {
    private final SeleccionadorDeEquipos seleccionadorDeEquipos;
    private final SeleccionadorDeJugadores seleccionadorDeJugadores;
    private final CrearGolesUtil crearGolesUtil;

    public PartidoServiceImpl(Scanner scanner){
        this.seleccionadorDeEquipos = new SeleccionadorDeEquiposImpl(scanner);
        this.seleccionadorDeJugadores = new SeleccionadorDeJugadoresImpl(scanner);
        this.crearGolesUtil = new CrearGolesUtil(scanner);
    }

    @Override
    public Partido crearPartido(List<Equipo> equipos){
        if (equipos == null || equipos.isEmpty()||equipos.size()<2){
            System.out.println("No hay equipos para que jueguen un partido.");
            return null;
        }
        System.out.println("Seleccione el equipo local:");
        Equipo equipoLocal = seleccionadorDeEquipos.seleccionar(equipos);

        List<Equipo> posiblesVisitantes = new ArrayList<>(equipos);
        posiblesVisitantes.remove(equipoLocal);

        System.out.println("Seleccione el equipo visitante:");
        Equipo equipoVisitante = seleccionadorDeEquipos.seleccionar(posiblesVisitantes);

        System.out.println("\nCuántos goles hizo el local?");
        int golesLocal = crearGolesUtil.crearGol();
        Map<Jugador,Integer> golesPorJugador = new HashMap<>(this.quienHizoGoles(equipoLocal,golesLocal));
        System.out.println("\nCuántos goles hizo el vistante?");
        int golesVisitante = crearGolesUtil.crearGol();
        golesPorJugador.putAll(this.quienHizoGoles(equipoVisitante,golesVisitante));

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
            golesPorJugador.put(autorGol,autorGol.getCantidadGoles()+1);
        }
        return golesPorJugador;

    }
}
