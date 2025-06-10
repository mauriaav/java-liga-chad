package com.info.salidautils;

import com.info.dominio.Equipo;

import java.util.List;

public class ImprimirEquipos {
    public static void imprimir(List<Equipo> equipos){
        for(Equipo e : equipos){
            System.out.println(e.getNombre());
        }
    }
}
