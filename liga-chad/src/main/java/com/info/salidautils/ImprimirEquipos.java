package com.info.salidautils;

import com.info.dominio.Equipo;
import com.info.servicios.gestorEquipo.EquipoService;

import java.util.List;

public class ImprimirEquipos {
    public static void imprimir(EquipoService equipoService){
        for(Equipo e : equipoService.getEquipos()){
            System.out.println(e.getNombre());
        }
    }
    public static void imprimirOrdenado(EquipoService equipoService){
        for(Equipo e : equipoService.equiposOrdenados()){
            System.out.println(e.getNombre() + " goles: " + equipoService.calcularGolesEquipo(e));
        }
    }
}
