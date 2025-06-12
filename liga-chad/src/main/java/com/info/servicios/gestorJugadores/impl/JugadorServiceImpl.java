package com.info.servicios.gestorJugadores.impl;

import com.info.dominio.Equipo;
import com.info.dominio.Jugador;
import com.info.dominio.JugadorSuplente;
import com.info.dominio.JugadorTitular;
import com.info.entradautils.CreadorJugadorUtil;
import com.info.servicios.gestorJugadores.JugadorService;

import java.util.Scanner;

public class JugadorServiceImpl implements JugadorService {
    private CreadorJugadorUtil creadorJugadorUtil;
    private final Scanner scanner;
    public JugadorServiceImpl(Scanner scanner){
        this.scanner = scanner;
        this.creadorJugadorUtil = new CreadorJugadorUtil(this.scanner);
    }

    @Override
    public void crearJugador(Equipo equipo){
        String nombreJugador = creadorJugadorUtil.nombreJugador();
        int edadJugador = creadorJugadorUtil.edadJugador();
        if(creadorJugadorUtil.tipoDeJugador()==1){
            Jugador nuevoJugador = new JugadorTitular(nombreJugador,edadJugador,equipo);
            equipo.agregarJugador(nuevoJugador);
        }
        else{
            Jugador nuevoJugador = new JugadorSuplente(nombreJugador,edadJugador,equipo);
            equipo.agregarJugador(nuevoJugador);
        }

    }

    @Override
    public void crearJugadores(Equipo equipo){
        String opcion = "";
        while(!opcion.equals("2")){
            System.out.println("-----Crear jugadores para " + equipo.getNombre());
            this.crearJugador(equipo);
            System.out.print("Deseas seguir creando jugadores?\n1.Si\n2.No\nOpción: ");
            opcion = scanner.nextLine();
        }
    }
}
