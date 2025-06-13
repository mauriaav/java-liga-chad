package com.info.servicios.ligaChad.impl;

import com.info.servicios.gestorEquipo.EquipoService;
import com.info.servicios.gestorJugadores.JugadorService;
import com.info.servicios.ligaChad.LigaChad;
import com.info.servicios.seleccionadores.seleccionadorDeEquipos.SeleccionadorDeEquipos;

import java.util.Scanner;

public class LigaChadImpl implements LigaChad {
    private Scanner scanner;
    private EquipoService equipoService;
    private SeleccionadorDeEquipos seleccionadorDeEquipos;
    private JugadorService jugadorService;

    public LigaChadImpl(Scanner scanner){
        this.scanner = scanner;
    }
    @Override
    public void iniciarLiga(){

    }
}
