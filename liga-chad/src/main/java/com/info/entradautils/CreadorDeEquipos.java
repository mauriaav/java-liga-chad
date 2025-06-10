package com.info.entradautils;

import java.util.Scanner;

public class CreadorDeEquipos {
    private Scanner scanner;

    public CreadorDeEquipos(Scanner scanner){
        this.scanner = scanner;
    }

    public String crearEquipo(){
        System.out.print("Ingrese el nombre del equipo: ");
        return leerNombreValido();
    }

    private String leerNombreValido(){
        String nombre = "";
        while(nombre.isBlank()){
            try{
                nombre = scanner.nextLine();
            } catch (RuntimeException e) {
                System.out.print("Entrada invalida. Ingrese un nombre: ");
            }
        }
        return nombre;
    }

}
