package com.info.servicios.seleccionadorDeEquipos;

import com.info.dominio.Equipo;

import java.util.List;
import java.util.Scanner;

public interface SeleccionadorDeEquipos {
    Equipo seleccionar(List<Equipo> equipos, Scanner scanner);
}
