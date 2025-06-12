package com.info.servicios.seleccionadores.seleccionadorDeJugadores;

import com.info.dominio.Jugador;

import java.util.List;
import java.util.Scanner;

public interface SeleccionadorDeJugadores {
    Jugador seleccionar(List<Jugador> jugadores);
}
