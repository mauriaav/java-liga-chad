package com.info.servicios.ligaChad;

import com.info.dominio.Equipo;

import java.util.List;

public interface LigaChadService {
    void iniciarLiga();
    void goleadorDeLaLiga(List<Equipo> equipos);
}
