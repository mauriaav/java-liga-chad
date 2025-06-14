package com.info.servicios.generadorCSV;

import com.info.dominio.Equipo;

import java.util.List;

public interface GeneradorCVSService {
    void exportarDatos(Equipo equipo);
}
