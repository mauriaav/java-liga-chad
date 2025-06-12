package com.info.servicios.gestorEquipo.impl;

import com.info.dominio.Equipo;
import com.info.entradautils.CreadorDeEquiposUtil;
import com.info.servicios.gestorEquipo.EquipoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


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
}
