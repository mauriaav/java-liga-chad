package com.info.servicios.menu.impl;

import com.info.servicios.menu.MenuService;

import java.util.Scanner;

public class MenuSiNoImpl implements MenuService {
    private Scanner scanner;
    public MenuSiNoImpl(Scanner scanner){
        this.scanner = scanner;
    }
    @Override
    public int seleccionarOpcionMenu(){
        int condition = 0;

        do {
            System.out.println("INDIQUE UNA OPCION : ");
            System.out.println("1. Si");
            System.out.println("2. No");
            condition = this.scanner.nextInt();
        } while (condition != 1 && condition!=2);
        scanner.close();
        return condition;

    }
    @Override
    public void ejecutarOpcion(int opcion){

    }
}
