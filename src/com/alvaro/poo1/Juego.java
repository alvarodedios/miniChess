package com.alvaro.poo1;

import java.util.Scanner;

public class Juego {

    //Atributos
    private boolean turno;

    //Accesores
    public boolean isTurno() {
        return turno;
    }
    public void setTurno(boolean turno) {
        this.turno = turno;
    }

    //Metodo para transformar un string de input de usuario a una jugada que el juego pueda entender
    public Movimiento jugada(String jugada) {
        Posicion posInicial = new Posicion(jugada.toLowerCase().charAt(1)-49,jugada.toLowerCase().charAt(0)-97);
        Posicion posFinal = new Posicion(jugada.toLowerCase().charAt(3)-49,jugada.toLowerCase().charAt(2)-97);
        return new Movimiento(posInicial,posFinal);
    }

    //Metodo que contiene el bucle de juego. Cada vuelta del bucle corresponde a un turno
    public void juego(Tablero tablero) {
        boolean ganador = false;
        int contadorTurno = 0;
        Scanner sc = new Scanner(System.in);
        tablero.pintarTablero();
        while (!ganador) {
            if (contadorTurno % 2 == 0) {
                turno = true;
            } else {
                turno = false;
            }
            if (turno) {
                System.out.println("-------------------------");
                System.out.println("Turno blancas " + new String(Character.toChars(127024)));
                System.out.println("-------------------------");
            } else {
                System.out.println("-------------------------");
                System.out.println("Turno negras " + new String(Character.toChars(127025)));
                System.out.println("-------------------------");
            }
            boolean esValido = false;
            Movimiento movimiento = new Movimiento(null,null);
            while (!esValido) {
                String mov;
                do {
                    System.out.println("Introduce un movimiento: ");
                    System.out.println("-------------------------");
                    mov = sc.nextLine();
                    if (mov.length() != 4) {
                        System.out.println("Las coordenadas deben estar estar en el siguiente formato:\n" +
                                "Letra-Numero-Letra-Numero");
                        System.out.println("-------------------------");
                    } else {
                        esValido = true;
                    }
                    if (esValido) {
                        movimiento.setPosInicial(jugada(mov).getPosInicial());
                        movimiento.setPosFinal(jugada(mov).getPosFinal());
                        esValido = movimiento.movimiento(jugada(mov).getPosInicial(),jugada(mov).getPosFinal());
                    }
                    if (esValido) {
                        esValido = tablero.validacion(tablero,jugada(mov),turno);
                    }
                    if (esValido) {
                        esValido = tablero.mover(movimiento);
                    }

                } while (mov.length() > 4 || !esValido);
            }
            tablero.pintarTablero();
            promocionPeon(tablero);
            contadorTurno++;
            System.out.println("-------------------------");
            System.out.println("¿Quieres terminar la partida? (S/n)");
            String respuesta = sc.nextLine();
            int puntosBlancas = 0;
            int puntosNegras = 0;
            if (respuesta.toLowerCase().charAt(0) == 115) {
                puntosBlancas = puntuacion(tablero,true);
                puntosNegras = puntuacion(tablero,false);
                if (puntosBlancas > puntosNegras) {
                    System.out.println("Han ganado Blancas!");
                    System.out.println("Puntos Blancas: " + puntosBlancas);
                    System.out.println("Puntos Negras: " + puntosNegras);
                } else if (puntosNegras > puntosBlancas){
                    System.out.println("Han ganado Negras!");
                    System.out.println("Puntos Blancas: " + puntosBlancas);
                    System.out.println("Puntos Negras: " + puntosNegras);
                } else {
                    System.out.println("Empate!");
                    System.out.println("Puntos Blancas: " + puntosBlancas);
                    System.out.println("Puntos Negras: " + puntosNegras);
                }
                ganador = true;
            }
        }
    }

    //Metodo para calcular los puntos totales de un color dado en un momento dado de la partida
    public int puntuacion(Tablero tablero,boolean color) {
        int puntos = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (tablero.hayPieza(i,j)) {
                    if (tablero.getTablero()[i][j].getColor() == color)
                        puntos = puntos + tablero.getTablero()[i][j].getPuntos();
                }
            }
        }
        return puntos;
    }

    //Metodo para promocionar un peon
    public void promocionPeon(Tablero tablero) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (tablero.hayPieza(i,j)) {
                    if (tablero.getTablero()[i][j].getNombre().equals("\u265F") && i == 7) {
                        do {
                            System.out.println("-------------------------\n" +
                                    "Peon promociona! Elige una pieza por la que cambiarlo\n" +
                                    "--->  1.Reina\n" +
                                    "--->  2.Alfil\n" +
                                    "--->  3.Caballo\n" +
                                    "--->  4.Torre\n" +
                                    "-------------------------");
                            opcion = sc.nextInt();
                            switch (opcion) {
                                case 1 :
                                    tablero.getTablero()[i][j] = new Reina(true,"Reina",40);
                                    tablero.getTablero()[i][j].setNombre(tablero.getTablero()[i][j].unicode(tablero.getTablero()[i][j].getNombre()));
                                    tablero.pintarTablero();
                                    break;
                                case 2 :
                                    tablero.getTablero()[i][j] = new Alfil(true,"Alfil",30);
                                    tablero.getTablero()[i][j].setNombre(tablero.getTablero()[i][j].unicode(tablero.getTablero()[i][j].getNombre()));
                                    tablero.pintarTablero();
                                    break;
                                case 3 :
                                    tablero.getTablero()[i][j] = new Caballo(true,"Caballo",30);
                                    tablero.getTablero()[i][j].setNombre(tablero.getTablero()[i][j].unicode(tablero.getTablero()[i][j].getNombre()));
                                    tablero.pintarTablero();
                                    break;
                                case 4 :
                                    tablero.getTablero()[i][j] = new Torre(true,"Torre",20);
                                    tablero.getTablero()[i][j].setNombre(tablero.getTablero()[i][j].unicode(tablero.getTablero()[i][j].getNombre()));
                                    tablero.pintarTablero();
                                    break;
                                default :
                                    System.out.println("Tienes que elegir una opcion de la 1 a la 4\n" +
                                            "-------------------------");
                                    break;
                            }
                        } while (opcion > 4 || opcion < 1);

                    } else if (tablero.getTablero()[i][j].getNombre().equals("\u2659") && i == 0) {
                        do {
                            System.out.println("-------------------------\n" +
                                    "Peon promociona! Elige una pieza por la que cambiarlo\n" +
                                    "--->  1.Reina\n" +
                                    "--->  2.Alfil\n" +
                                    "--->  3.Caballo\n" +
                                    "--->  4.Torre\n" +
                                    "-------------------------");
                            opcion = sc.nextInt();
                            switch (opcion) {
                                case 1 :
                                    tablero.getTablero()[i][j] = new Reina(false,"Reina",40);
                                    tablero.getTablero()[i][j].setNombre(tablero.getTablero()[i][j].unicode(tablero.getTablero()[i][j].getNombre()));
                                    tablero.pintarTablero();
                                    break;
                                case 2 :
                                    tablero.getTablero()[i][j] = new Alfil(false,"Alfil",30);
                                    tablero.getTablero()[i][j].setNombre(tablero.getTablero()[i][j].unicode(tablero.getTablero()[i][j].getNombre()));
                                    tablero.pintarTablero();
                                    break;
                                case 3 :
                                    tablero.getTablero()[i][j] = new Caballo(false,"Caballo",30);
                                    tablero.getTablero()[i][j].setNombre(tablero.getTablero()[i][j].unicode(tablero.getTablero()[i][j].getNombre()));
                                    tablero.pintarTablero();
                                    break;
                                case 4 :
                                    tablero.getTablero()[i][j] = new Torre(false,"Torre",20);
                                    tablero.getTablero()[i][j].setNombre(tablero.getTablero()[i][j].unicode(tablero.getTablero()[i][j].getNombre()));
                                    tablero.pintarTablero();
                                    break;
                                default :
                                    System.out.println("Tienes que elegir una opcion de la 1 a la 4\n" +
                                            "-------------------------");
                                    break;
                            }
                        } while (opcion > 4 || opcion < 1);
                    }
                }
            }
        }
    }

    //Metodo para gestionar jaque
//    public void jaqueMate(Tablero tablero) {
//
//    }


//    //Metodo para enrocar
//    public void enroque(Tablero tablero) {
//        for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 8; j++) {
//                if (tablero.hayPieza(i, j)) {
//                    if (tablero.getTablero()[0][4].getNombre().equals("\u265A"))
//                }
//            }
//        }
//    }
}
