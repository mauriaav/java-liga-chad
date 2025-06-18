package com.info;

import com.info.servicios.menu.MenuService;
import com.info.servicios.menu.impl.MenuServiceImpl;

public class App {
    public static void main(String[] args) {
        MenuService menu = new MenuServiceImpl();
        menu.seleccionarOpcionMenu();
    }
}
