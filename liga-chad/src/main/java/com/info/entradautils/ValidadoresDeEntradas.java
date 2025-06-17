package com.info.entradautils;

import java.util.Scanner;

public class ValidadoresDeEntradas {

    public static int leerEnteroRango(Scanner scanner, String mensaje, int minimo, int maximo){
        int valor = -1;
        do{
            System.out.println(mensaje);
            String input = scanner.nextLine().trim();
            try {
                valor = Integer.parseInt(input);
                if (valor < minimo || valor > maximo){
                    System.out.println("Ingresa un valor entre " + minimo + " y " + maximo);
                }
            }catch (NumberFormatException e){
                System.out.println("Respuesta inválida.");
            }
        }while (valor < minimo || valor > maximo);
        return valor;
    }

    public static int leerEnteroPositivo(Scanner scanner, String mensaje){
        int valor = -1;
        do{
            System.out.println(mensaje);
            String input = scanner.nextLine().trim();
            try {
                valor = Integer.parseInt(input);
                if (valor < 0){
                    System.out.println("Ingresa un valor mayor o igual a 0");
                }
            }catch (NumberFormatException e){
                System.out.println("Respuesta inválida.");
            }
        }while (valor < 0);
        return valor;
    }

    public static String leerTextoNoVacio(Scanner scanner, String mensaje){
        String input;
        do{
            System.out.println(mensaje);
            input = scanner.nextLine().trim();
            if (input.isEmpty()){
                System.out.println("Respuesta inválida. No puede estar vacía.");
            }
        }while (input.isEmpty());
        return input;
    }

    public static boolean confirmar(Scanner scanner, String mensaje) {
        String input;
        do {
            System.out.print(mensaje + " (s/n): ");
            input = scanner.nextLine().trim().toLowerCase();
        } while (!input.equals("s") && !input.equals("n"));
        return input.equals("s");
    }
}
