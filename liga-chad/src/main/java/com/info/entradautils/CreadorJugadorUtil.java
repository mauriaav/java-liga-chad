package com.info.entradautils;


import java.util.Scanner;

public class CreadorJugadorUtil {
    private final Scanner scanner;

    public CreadorJugadorUtil(Scanner scanner){
        this.scanner = scanner;
    }


    public String nombreJugador(){
        System.out.print("Ingrese el nombre del jugador: ");
        return leerNombreValido();
    }

    public int edadJugador(){
        System.out.print("Ingrese la edad del jugador: ");
        return leerEnteroPositivo();
    }


    private String leerNombreValido(){
        String nombre = "";
        while(nombre.isBlank()){
            try{
                nombre = scanner.nextLine().trim();
            } catch (RuntimeException e) {
                System.out.print("Entrada invalida. Ingrese un nombre: ");
            }
        }
        return nombre;
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
