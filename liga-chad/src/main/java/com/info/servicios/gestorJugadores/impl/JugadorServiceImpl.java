package com.info.servicios.gestorJugadores.impl;

import com.info.dominio.Equipo;
import com.info.dominio.Jugador;
import com.info.dominio.JugadorSuplente;
import com.info.dominio.JugadorTitular;
import com.info.entradautils.ValidadoresDeEntradas;
import com.info.servicios.gestorJugadores.JugadorService;
import com.info.servicios.seleccionadores.seleccionadorDeJugadores.SeleccionadorDeJugadores;
import com.info.servicios.seleccionadores.seleccionadorDeJugadores.impl.SeleccionadorDeJugadoresImpl;
import com.info.servicios.seleccionadores.seleccionadorDeEquipos.SeleccionadorDeEquipos;
import com.info.servicios.seleccionadores.seleccionadorDeEquipos.impl.SeleccionadorDeEquiposImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JugadorServiceImpl implements JugadorService {
    private final Scanner scanner;
    private final SeleccionadorDeJugadores seleccionadorDeJugadores;
    private final SeleccionadorDeEquipos seleccionadorDeEquipos;
    public JugadorServiceImpl(Scanner scanner){
        this.scanner = scanner;
        this.seleccionadorDeJugadores = new SeleccionadorDeJugadoresImpl(scanner);
        this.seleccionadorDeEquipos = new SeleccionadorDeEquiposImpl(scanner);
    }

    @Override
    public void crearJugador(Equipo equipo){
        String nombreJugador = ValidadoresDeEntradas.leerTextoNoVacio(scanner, "Ingrese el nombre del jugador:");
        int edadJugador = ValidadoresDeEntradas.leerEnteroRango(scanner,"Ingrese la edad del jugador: ",1,100);
        int tipoJugador = ValidadoresDeEntradas.leerEnteroRango(scanner,"Es titular o suplente? 1. Titular 2. Suplente ",1,2);
        if(tipoJugador==1){
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
        boolean opcion = Boolean.TRUE;
        do{
            System.out.println( "Crear jugadores para " + equipo.getNombre());
            this.crearJugador(equipo);
            opcion = ValidadoresDeEntradas.confirmar(scanner,"Deseas seguir creando jugadores?");
        }while(opcion);
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
    public void crearJugadoresTest(Equipo equipo, String nombre, int edad, int tipo){
        if(tipo ==1){
            Jugador jugador1= new JugadorTitular(nombre,edad,equipo);
            equipo.agregarJugador(jugador1);
        }
        if(tipo ==2){
            Jugador jugador1= new JugadorSuplente(nombre,edad,equipo);
            equipo.agregarJugador(jugador1);
        }
    }

    @Override
    public List<Jugador> jugadoresTitular(Equipo equipo){
        List<Jugador> listaTitulares = new ArrayList<>();
        for(Jugador jugador : equipo.getJugadores()){
            if (jugador.getTipoJugador().equals("Titular")){
                listaTitulares.add(jugador);
            }
        }
        return listaTitulares;
    }

    @Override
    public List<Jugador> jugadoresSuplentes(Equipo equipo){
        List<Jugador> listaSuplentes = new ArrayList<>();
        for(Jugador jugador : equipo.getJugadores()){
            if (jugador.getTipoJugador().equals("Suplente")){
                listaSuplentes.add(jugador);
            }
        }
        return listaSuplentes;
    }
}
