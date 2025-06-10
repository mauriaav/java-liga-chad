package com.info.servicios.gestorEquipo.impl;

import com.info.dominio.Equipo;
import com.info.servicios.gestorEquipo.EquipoService;

import java.util.ArrayList;
import java.util.List;


public class EquipoServiceImpl implements EquipoService {
    public List<Equipo> equipos = new ArrayList<>();

    @Override
    public Equipo crearEquipo (String nombre){
        Equipo equipo = new Equipo(nombre);
        equipos.add(equipo);
        return equipo;
    }

    @Override
    public List<Equipo> getEquipos(){
        return equipos;
    }
}
