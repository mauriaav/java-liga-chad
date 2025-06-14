package com.info.servicios.generadorCSV.impl;

import com.info.dominio.Equipo;
import com.info.dominio.Jugador;
import com.info.servicios.generadorCSV.GeneradorCVSService;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GeneradorCVSServiceImpl implements GeneradorCVSService {
    private final String UBICACION_ARCHIVO = "\\src\\main\\java\\com\\info\\recursos\\";
    CSVWriter csvWriter;

    @Override
    public void exportarDatos(Equipo equipo){
        String ruta = System.getProperty("user.dir").concat(UBICACION_ARCHIVO).concat("datos-liga.csv");
        try {
            this.csvWriter = new CSVWriter(new FileWriter(ruta));

            String[] encabezado = {"Titular SI/NO","Nombre","Edad", "Cantidad goles"};
            this.csvWriter.writeNext(encabezado);
            for (Jugador jugador : equipo.getJugadores()){
                String[] datos = {
                        jugador.getTipoJugador().equals("Titular")? "SI":"NO",
                        jugador.getNombre(),
                        Integer.toString(jugador.getEdad()),
                        Integer.toString(jugador.getCantidadGoles())
                };
                this.csvWriter.writeNext(datos);
            }
            System.out.println("Exportación exitosa.");
            this.cerrarWriter();
        }catch (IOException e){
            System.out.println("Algo salió mal, motivo: " + e.getMessage().concat(" ubicación archivo: " +ruta));
        }
    }

    public void cerrarWriter(){
        if(this.csvWriter !=null){
            try {
                this.csvWriter.close();
            }catch (IOException e){
                System.out.println("Algo salió mal, motivo: " + e.getMessage());
            }
        }
    }
}
