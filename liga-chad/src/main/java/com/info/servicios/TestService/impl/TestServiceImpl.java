package com.info.servicios.TestService.impl;

import com.info.dominio.Equipo;
import com.info.servicios.TestService.TestService;
import com.info.servicios.gestorEquipo.EquipoService;
import com.info.servicios.gestorJugadores.JugadorService;


public class TestServiceImpl implements TestService {
    private final EquipoService equipoService;
    private final JugadorService jugadorService;

    public TestServiceImpl (EquipoService equipoService, JugadorService jugadorService){
        this.equipoService = equipoService;
        this.jugadorService = jugadorService;
    }
    @Override
    public void cargarDatos(){
        Equipo river = equipoService.crearEquipoTest("River");
        jugadorService.crearJugadoresTest(river,"Franco Armani",37,1);
        jugadorService.crearJugadoresTest(river, "Milton Casco", 35, 1);
        jugadorService.crearJugadoresTest(river, "Paulo Díaz", 29, 1);
        jugadorService.crearJugadoresTest(river, "Leandro González Pirez", 32, 1);
        jugadorService.crearJugadoresTest(river, "Enzo Díaz", 28, 1);
        jugadorService.crearJugadoresTest(river, "Rodrigo Aliendro", 33, 1);
        jugadorService.crearJugadoresTest(river, "Nicolás De La Cruz", 26, 1);
        jugadorService.crearJugadoresTest(river, "Ignacio Fernández", 34, 1);
        jugadorService.crearJugadoresTest(river, "Esequiel Barco", 25, 1);
        jugadorService.crearJugadoresTest(river, "Facundo Colidio", 24, 1);
        jugadorService.crearJugadoresTest(river, "Miguel Borja", 31, 1);
        jugadorService.crearJugadoresTest(river, "Santiago Simón", 22, 2);
        jugadorService.crearJugadoresTest(river, "Agustín Palavecino", 27, 2);
        jugadorService.crearJugadoresTest(river, "Pablo Solari", 23, 2);
        jugadorService.crearJugadoresTest(river, "Matías Kranevitter", 31, 2);
        jugadorService.crearJugadoresTest(river, "David Martínez", 26, 2);

        Equipo boca = equipoService.crearEquipoTest("Boca");
        jugadorService.crearJugadoresTest(boca, "Sergio Romero", 37, 1);
        jugadorService.crearJugadoresTest(boca, "Luis Advíncula", 34, 1);
        jugadorService.crearJugadoresTest(boca, "Nicolás Figal", 30, 1);
        jugadorService.crearJugadoresTest(boca, "Marcos Rojo", 34, 1);
        jugadorService.crearJugadoresTest(boca, "Frank Fabra", 33, 1);
        jugadorService.crearJugadoresTest(boca, "Ezequiel Fernández", 21, 1);
        jugadorService.crearJugadoresTest(boca, "Pol Fernández", 32, 1);
        jugadorService.crearJugadoresTest(boca, "Cristian Medina", 21, 1);
        jugadorService.crearJugadoresTest(boca, "Kevin Zenón", 22, 1);
        jugadorService.crearJugadoresTest(boca, "Miguel Merentiel", 28, 1);
        jugadorService.crearJugadoresTest(boca, "Edinson Cavani", 37, 1);
        jugadorService.crearJugadoresTest(boca, "Leandro Brey", 21, 2);
        jugadorService.crearJugadoresTest(boca, "Jabes Saralegui", 21, 2);
        jugadorService.crearJugadoresTest(boca, "Lucas Janson", 29, 2);
        jugadorService.crearJugadoresTest(boca, "Norberto Briasco", 28, 2);
        jugadorService.crearJugadoresTest(boca, "Nicolás Valentini", 23, 2);

        Equipo racing = equipoService.crearEquipoTest("Racing");
        jugadorService.crearJugadoresTest(racing, "Gabriel Arias", 36, 1);
        jugadorService.crearJugadoresTest(racing, "Gastón Martirena", 24, 1);
        jugadorService.crearJugadoresTest(racing, "Leonardo Sigali", 37, 1);
        jugadorService.crearJugadoresTest(racing, "Germán Conti", 30, 1);
        jugadorService.crearJugadoresTest(racing, "Gabriel Rojas", 27, 1);
        jugadorService.crearJugadoresTest(racing, "Juan Ignacio Nardoni", 22, 1);
        jugadorService.crearJugadoresTest(racing, "Bruno Zuculini", 31, 1);
        jugadorService.crearJugadoresTest(racing, "Agustín Almendra", 24, 1);
        jugadorService.crearJugadoresTest(racing, "Johan Carbonero", 25, 1);
        jugadorService.crearJugadoresTest(racing, "Adrián Martínez", 31, 1);
        jugadorService.crearJugadoresTest(racing, "Maximiliano Salas", 26, 1);
        jugadorService.crearJugadoresTest(racing, "Facundo Mura", 25, 2);
        jugadorService.crearJugadoresTest(racing, "Baltasar Rodríguez", 22, 2);
        jugadorService.crearJugadoresTest(racing, "Roger Martínez", 29, 2);
        jugadorService.crearJugadoresTest(racing, "Santiago Sosa", 25, 2);
        jugadorService.crearJugadoresTest(racing, "Emiliano Vecchio", 35, 2);

        Equipo independiente = equipoService.crearEquipoTest("Independiente");
        jugadorService.crearJugadoresTest(independiente, "Rodrigo Rey", 33, 1);
        jugadorService.crearJugadoresTest(independiente, "Mauricio Isla", 36, 1);
        jugadorService.crearJugadoresTest(independiente, "Joaquín Laso", 34, 1);
        jugadorService.crearJugadoresTest(independiente, "Ayrton Costa", 25, 1);
        jugadorService.crearJugadoresTest(independiente, "Damián Pérez", 35, 1);
        jugadorService.crearJugadoresTest(independiente, "Iván Marcone", 34, 1);
        jugadorService.crearJugadoresTest(independiente, "Federico Mancuello", 35, 1);
        jugadorService.crearJugadoresTest(independiente, "Lucas González", 23, 1);
        jugadorService.crearJugadoresTest(independiente, "Matías Giménez Rojas", 24, 1);
        jugadorService.crearJugadoresTest(independiente, "Gabriel Ávalos", 33, 1);
        jugadorService.crearJugadoresTest(independiente, "Santiago Toloza", 22, 1);
        jugadorService.crearJugadoresTest(independiente, "Diego Tarzia", 22, 2);
        jugadorService.crearJugadoresTest(independiente, "Tomás Pozzo", 23, 2);
        jugadorService.crearJugadoresTest(independiente, "Alexis Canelo", 32, 2);
        jugadorService.crearJugadoresTest(independiente, "Baltasar Barcia", 22, 2);
        jugadorService.crearJugadoresTest(independiente, "Javier Ruiz", 20, 2);

        Equipo sanlorenzo = equipoService.crearEquipoTest("San Lorenzo");
        jugadorService.crearJugadoresTest(sanlorenzo, "Facundo Altamirano", 27, 1);
        jugadorService.crearJugadoresTest(sanlorenzo, "Agustín Giay", 20, 1);
        jugadorService.crearJugadoresTest(sanlorenzo, "Federico Gattoni", 25, 1);
        jugadorService.crearJugadoresTest(sanlorenzo, "Gastón Campi", 33, 1);
        jugadorService.crearJugadoresTest(sanlorenzo, "Malcom Braida", 27, 1);
        jugadorService.crearJugadoresTest(sanlorenzo, "Jalil Elías", 27, 1);
        jugadorService.crearJugadoresTest(sanlorenzo, "Elián Irala", 21, 1);
        jugadorService.crearJugadoresTest(sanlorenzo, "Cristian Ferreira", 24, 1);
        jugadorService.crearJugadoresTest(sanlorenzo, "Nahuel Barrios", 26, 1);
        jugadorService.crearJugadoresTest(sanlorenzo, "Adam Bareiro", 27, 1);
        jugadorService.crearJugadoresTest(sanlorenzo, "Iván Leguizamón", 22, 1);
        jugadorService.crearJugadoresTest(sanlorenzo, "Nicolás Blandi", 34, 2);
        jugadorService.crearJugadoresTest(sanlorenzo, "Gastón Ramírez", 33, 2);
        jugadorService.crearJugadoresTest(sanlorenzo, "Gonzalo Luján", 22, 2);
        jugadorService.crearJugadoresTest(sanlorenzo, "Iván Tapia", 25, 2);
        jugadorService.crearJugadoresTest(sanlorenzo, "Ezequiel Cerutti", 32, 2);

        Equipo estudiantes = equipoService.crearEquipoTest("Estudiantes");
        jugadorService.crearJugadoresTest(estudiantes, "Matías Mansilla", 26, 1);
        jugadorService.crearJugadoresTest(estudiantes, "Leonardo Godoy", 28, 1);
        jugadorService.crearJugadoresTest(estudiantes, "Zaid Romero", 24, 1);
        jugadorService.crearJugadoresTest(estudiantes, "Luciano Lollo", 37, 1);
        jugadorService.crearJugadoresTest(estudiantes, "Eros Mancuso", 25, 1);
        jugadorService.crearJugadoresTest(estudiantes, "Enzo Pérez", 38, 1);
        jugadorService.crearJugadoresTest(estudiantes, "José Sosa", 38, 1);
        jugadorService.crearJugadoresTest(estudiantes, "Fernando Zuqui", 32, 1);
        jugadorService.crearJugadoresTest(estudiantes, "Benjamín Rollheiser", 23, 1);
        jugadorService.crearJugadoresTest(estudiantes, "Guido Carrillo", 32, 1);
        jugadorService.crearJugadoresTest(estudiantes, "Javier Correa", 31, 1);
        jugadorService.crearJugadoresTest(estudiantes, "Tiago Palacios", 23, 2);
        jugadorService.crearJugadoresTest(estudiantes, "Santiago Ascacibar", 27, 2);
        jugadorService.crearJugadoresTest(estudiantes, "Pablo Piatti", 35, 2);
        jugadorService.crearJugadoresTest(estudiantes, "Mauro Méndez", 25, 2);
        jugadorService.crearJugadoresTest(estudiantes, "Brian Orosco", 24, 2);

        Equipo huracan = equipoService.crearEquipoTest("Huracán");
        jugadorService.crearJugadoresTest(huracan, "Hernán Galíndez", 37, 1);
        jugadorService.crearJugadoresTest(huracan, "Lucas Souto", 25, 1);
        jugadorService.crearJugadoresTest(huracan, "Fernando Tobio", 34, 1);
        jugadorService.crearJugadoresTest(huracan, "Lucas Carrizo", 26, 1);
        jugadorService.crearJugadoresTest(huracan, "César Ibáñez", 25, 1);
        jugadorService.crearJugadoresTest(huracan, "Federico Fattori", 31, 1);
        jugadorService.crearJugadoresTest(huracan, "Rodrigo Echeverría", 28, 1);
        jugadorService.crearJugadoresTest(huracan, "Héctor Fértoli", 29, 1);
        jugadorService.crearJugadoresTest(huracan, "Walter Mazzantti", 28, 1);
        jugadorService.crearJugadoresTest(huracan, "Ignacio Pussetto", 29, 1);
        jugadorService.crearJugadoresTest(huracan, "Ignacio Russo", 24, 1);
        jugadorService.crearJugadoresTest(huracan, "Guillermo Benítez", 30, 2);
        jugadorService.crearJugadoresTest(huracan, "Jonás Acevedo", 26, 2);
        jugadorService.crearJugadoresTest(huracan, "Matías Cóccaro", 26, 2);
        jugadorService.crearJugadoresTest(huracan, "Patricio Pizarro", 21, 2);
        jugadorService.crearJugadoresTest(huracan, "Santiago Hezze", 22, 2);

        Equipo argentinos = equipoService.crearEquipoTest("Argentinos Juniors");
        jugadorService.crearJugadoresTest(argentinos, "Alexis Martín Arias", 32, 1);
        jugadorService.crearJugadoresTest(argentinos, "Kevin Mac Allister", 26, 1);
        jugadorService.crearJugadoresTest(argentinos, "Miguel Torrén", 36, 1);
        jugadorService.crearJugadoresTest(argentinos, "Francisco Álvarez", 23, 1);
        jugadorService.crearJugadoresTest(argentinos, "Román Vega", 21, 1);
        jugadorService.crearJugadoresTest(argentinos, "Alan Rodríguez", 23, 1);
        jugadorService.crearJugadoresTest(argentinos, "Luciano Sánchez", 28, 1);
        jugadorService.crearJugadoresTest(argentinos, "Francisco González Metilli", 27, 1);
        jugadorService.crearJugadoresTest(argentinos, "Gabriel Ávalos", 33, 1);
        jugadorService.crearJugadoresTest(argentinos, "Maximiliano Romero", 25, 1);
        jugadorService.crearJugadoresTest(argentinos, "Santiago Montiel", 22, 1);
        jugadorService.crearJugadoresTest(argentinos, "Gastón Verón", 22, 2);
        jugadorService.crearJugadoresTest(argentinos, "Franco Moyano", 27, 2);
        jugadorService.crearJugadoresTest(argentinos, "Thiago Nuss", 23, 2);
        jugadorService.crearJugadoresTest(argentinos, "Leonel González", 30, 2);
        jugadorService.crearJugadoresTest(argentinos, "Matías Perelló", 21, 2);

        Equipo talleres = equipoService.crearEquipoTest("Talleres");
        jugadorService.crearJugadoresTest(talleres, "Guido Herrera", 32, 1);
        jugadorService.crearJugadoresTest(talleres, "Gastón Benavídez", 28, 1);
        jugadorService.crearJugadoresTest(talleres, "Matías Catalán", 31, 1);
        jugadorService.crearJugadoresTest(talleres, "Kevin Mantilla", 20, 1);
        jugadorService.crearJugadoresTest(talleres, "Blas Riveros", 26, 1);
        jugadorService.crearJugadoresTest(talleres, "Rodrigo Villagra", 23, 1);
        jugadorService.crearJugadoresTest(talleres, "Ulises Ortegoza", 27, 1);
        jugadorService.crearJugadoresTest(talleres, "Marcos Portillo", 23, 1);
        jugadorService.crearJugadoresTest(talleres, "Rubén Botta", 34, 1);
        jugadorService.crearJugadoresTest(talleres, "Ramón Sosa", 24, 1);
        jugadorService.crearJugadoresTest(talleres, "Federico Girotti", 25, 1);
        jugadorService.crearJugadoresTest(talleres, "Valentín Depietri", 23, 2);
        jugadorService.crearJugadoresTest(talleres, "Nahuel Bustos", 26, 2);
        jugadorService.crearJugadoresTest(talleres, "Matías Esquivel", 25, 2);
        jugadorService.crearJugadoresTest(talleres, "Christian Oliva", 28, 2);
        jugadorService.crearJugadoresTest(talleres, "Miguel Navarro", 25, 2);

        Equipo lanus = equipoService.crearEquipoTest("Lanús");
        jugadorService.crearJugadoresTest(lanus, "Lucas Acosta", 29, 1);
        jugadorService.crearJugadoresTest(lanus, "Juan Cáceres", 23, 1);
        jugadorService.crearJugadoresTest(lanus, "Cristian Lema", 34, 1);
        jugadorService.crearJugadoresTest(lanus, "Felipe Aguilar", 31, 1);
        jugadorService.crearJugadoresTest(lanus, "Julio Soler", 24, 1);
        jugadorService.crearJugadoresTest(lanus, "Luciano Boggio", 27, 1);
        jugadorService.crearJugadoresTest(lanus, "Tomás Belmonte", 26, 1);
        jugadorService.crearJugadoresTest(lanus, "Raúl Loaiza", 30, 1);
        jugadorService.crearJugadoresTest(lanus, "Pedro De La Vega", 23, 1);
        jugadorService.crearJugadoresTest(lanus, "Leandro Díaz", 32, 1);
        jugadorService.crearJugadoresTest(lanus, "Walter Bou", 30, 1);
        jugadorService.crearJugadoresTest(lanus, "Matías Pérez", 25, 2);
        jugadorService.crearJugadoresTest(lanus, "Franco Orozco", 22, 2);
        jugadorService.crearJugadoresTest(lanus, "Juan Sánchez Miño", 34, 2);
        jugadorService.crearJugadoresTest(lanus, "Nicolás Pasquini", 33, 2);
        jugadorService.crearJugadoresTest(lanus, "David González", 21, 2);




    }
}
