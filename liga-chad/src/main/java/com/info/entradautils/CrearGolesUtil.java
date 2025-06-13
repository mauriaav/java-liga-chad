package com.info.entradautils;

import java.util.Scanner;

public class CrearGolesUtil {
    private final Scanner scanner;

    public CrearGolesUtil(Scanner scanner){
        this.scanner = scanner;
    }

    public int crearGol(){
        System.out.print("Ingrese la cantidad de goles: ");
        return leerEnteroPositivo();
    }

    private int leerEnteroPositivo(){
        int valor = -1;

        while ( valor < 0 ){
            try {
                valor = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Entrada invalida. Ingrese un numero entero : ");
            }
        }
        return valor;
    }
}
