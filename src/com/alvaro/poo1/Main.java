package com.alvaro.poo1;

import javax.swing.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("  __     __  ____  ____  ____  ____  ____ \n" +
                " / _\\  _(  )(  __)(    \\(  _ \\(  __)(__  )\n" +
                "/    \\/ \\) \\ ) _)  ) D ( )   / ) _)  / _/ \n" +
                "\\_/\\_/\\____/(____)(____/(__\\_)(____)(____)\n" +
                "-------------------------------------------");

        //Tester
//        Pieza pieza1 = new Rey(true,"Rey",50);
//        Pieza pieza2 = new Reina(false,"Reina",40);
//        Tablero tablero = new Tablero(pieza1,pieza2);

        Tablero tablero = new Tablero();
        Juego juego = new Juego();

        juego.juego(tablero);
    }
}