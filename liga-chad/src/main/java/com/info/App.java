package com.info;

import com.info.dominio.Equipo;
import com.info.dominio.Jugador;
import com.info.dominio.Partido;
import com.info.servicios.gestorEquipo.EquipoService;
import com.info.servicios.menu.MenuService;
import com.info.servicios.menu.impl.MenuServiceImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        /*
        Partido partido;
        Jugador jugador;
        Equipo equipo;
        Equipo equipo2;

        equipo = new Equipo("River");
        equipo2 = new Equipo("Boca");


        jugador = new Jugador("Borja",28);
        equipo.agregarJugador(jugador);
        jugador.setEquipo(equipo);

        Jugador jugador2 = new Jugador("Mastan",17);
        equipo.agregarJugador(jugador2);
        jugador2.setEquipo(equipo);

        Jugador jugador3 = new Jugador("Meirdon", 58);
        equipo2.agregarJugador(jugador3);
        jugador3.setEquipo(equipo2);

        partido = new Partido(equipo,equipo2);
        partido.agregarGol(jugador2);
        partido.agregarGol(jugador2);
        partido.agregarGol(jugador2);
        partido.agregarGol(jugador);
        partido.agregarGol(jugador3);

        for(Map.Entry<Jugador,Integer> entrada : partido.getGolesPorJugador().entrySet()){
            System.out.println("" + entrada.getKey().getNombre() +" hizo " + entrada.getValue() + " goles" );
        }

        System.out.println("El partido terminó " + partido.getResultado().get(equipo) + " a " + partido.getResultado().get(equipo2));
*/
        MenuService menu = new MenuServiceImpl();
        menu.seleccionarOpcionMenu();

    }
}
