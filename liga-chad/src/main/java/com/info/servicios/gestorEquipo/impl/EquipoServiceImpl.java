package com.info.servicios.gestorEquipo.impl;

import com.info.dominio.Equipo;
import com.info.dominio.Partido;
import com.info.entradautils.CreadorDeEquiposUtil;
import com.info.servicios.gestorEquipo.EquipoService;

import java.util.*;


public class EquipoServiceImpl implements EquipoService {
    private List<Equipo> equipos = new ArrayList<>();
    private Scanner scanner;
    private CreadorDeEquiposUtil creadorDeEquiposUtil;

    public EquipoServiceImpl(Scanner scanner){
        this.scanner = scanner;
        this.creadorDeEquiposUtil = new CreadorDeEquiposUtil(scanner);
    }

    @Override
    public Equipo crearEquipo (){
        Equipo equipo = new Equipo(creadorDeEquiposUtil.crearEquipo());
        equipos.add(equipo);
        return equipo;
    }

    @Override
    public List<Equipo> getEquipos(){
        return equipos;
    }

    @Override
    public void crearEquipoTest(){
        Equipo equipoTest = new Equipo("RiverT");
        Equipo equipoTest2 = new Equipo("BocaT");
        equipos.add(equipoTest);
        equipos.add(equipoTest2);
    }

    @Override
    public int calcularGolesEquipo(Equipo equipo){
        List<Partido> partidosJugadosE = new ArrayList<>(equipo.getPartidosJugados());
        if(equipo.getPartidosJugados().isEmpty()){
            return 0;
        }
        int totalGoles = 0;
        for(Partido partido : partidosJugadosE){
            Map<Equipo, Integer> resultado = partido.getResultado();
            totalGoles += resultado.get(equipo);
        }
        return totalGoles;
    }

    @Override
    public List<Equipo> equiposOrdenados(){
        Map<Equipo,Integer> golesPorEquipo = new HashMap<>();
        for(Equipo equipo : equipos){
            golesPorEquipo.put(equipo,calcularGolesEquipo(equipo));
        }

        List<Equipo> listaOrdenada = new ArrayList<>(equipos);
        listaOrdenada.sort((e1,e2) -> Integer.compare(golesPorEquipo.get(e2),golesPorEquipo.get(e1)));
        return listaOrdenada;
    }
}
