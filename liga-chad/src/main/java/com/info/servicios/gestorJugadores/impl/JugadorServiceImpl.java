package com.info.servicios.gestorJugadores.impl;

import com.info.dominio.Equipo;
import com.info.dominio.Jugador;
import com.info.dominio.JugadorSuplente;
import com.info.dominio.JugadorTitular;
import com.info.entradautils.CreadorJugadorUtil;
import com.info.servicios.gestorJugadores.JugadorService;
import com.info.servicios.seleccionadores.seleccionadorDeJugadores.SeleccionadorDeJugadores;
import com.info.servicios.seleccionadores.seleccionadorDeJugadores.impl.SeleccionadorDeJugadoresImpl;
import com.info.servicios.seleccionadores.seleccionadorDeEquipos.SeleccionadorDeEquipos;
import com.info.servicios.seleccionadores.seleccionadorDeEquipos.impl.SeleccionadorDeEquiposImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JugadorServiceImpl implements JugadorService {
    private CreadorJugadorUtil creadorJugadorUtil;
    private final Scanner scanner;
    private final SeleccionadorDeJugadores seleccionadorDeJugadores;
    private final SeleccionadorDeEquipos seleccionadorDeEquipos;
    public JugadorServiceImpl(Scanner scanner){
        this.scanner = scanner;
        this.creadorJugadorUtil = new CreadorJugadorUtil(this.scanner);
        this.seleccionadorDeJugadores = new SeleccionadorDeJugadoresImpl(scanner);
        this.seleccionadorDeEquipos = new SeleccionadorDeEquiposImpl(scanner);
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

    @Override
    public void transferirJugadorEntreEquipos(List<Equipo>equipos){
        if (equipos == null || equipos.isEmpty()||equipos.size()<2) {
            System.out.println("No hay equipos suficientes para transferir.");
            return;
        }

        System.out.println("Seleccione el equipo del jugador a transferir:");
        Equipo equipoOrigen = seleccionadorDeEquipos.seleccionar(equipos);

        if (equipoOrigen.getJugadores().isEmpty()) {
            System.out.println("No hay jugadores en " + equipoOrigen.getNombre() + " para transferir.");
            return;
        }

        Jugador jugadorATransferir = seleccionadorDeJugadores.seleccionar(equipoOrigen.getJugadores());
        if (jugadorATransferir == null) {
            System.out.println("Selección inválida. Cancelando operación.");
            return;
        }

        List<Equipo> equiposDestino = new ArrayList<>(equipos);
        equiposDestino.remove(equipoOrigen);

        System.out.println("Seleccione el equipo destino:");
        Equipo equipoDestino = seleccionadorDeEquipos.seleccionar(equiposDestino);

        equipoOrigen.eliminarJugador(jugadorATransferir);
        jugadorATransferir.setEquipo(equipoDestino);
        equipoDestino.agregarJugador(jugadorATransferir);

        System.out.println("El jugador " + jugadorATransferir.getNombre() +
                " fue transferido de " + equipoOrigen.getNombre() +
                " a " + equipoDestino.getNombre() + ".");
    }

    @Override
    public void crearJugadoresTest(Equipo equipo){
        Jugador jugador1 = new JugadorTitular("Mastantuono"+equipo.getNombre(),17,equipo);
        equipo.agregarJugador(jugador1);
        Jugador jugador2 = new JugadorSuplente("Borja"+equipo.getNombre(),29,equipo);
        equipo.agregarJugador(jugador2);
    }
}
