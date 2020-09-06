package com.alvaro.poo1;

public class Tablero {

    //Atributos
    public Pieza[][] tablero;

    //Accesores
    public Pieza[][] getTablero() {
        return tablero;
    }
    public void setTablero(Pieza[][] tablero) {
        this.tablero = tablero;
    }

    //Constructores

    //Constructor principal del tablero: Inicializa las 32 piezas a sus posiciones iniciales
    public Tablero() {
        tablero = new Pieza[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i == 0 && j == 0) || (i == 0 && j == 7)){
                    tablero[i][j] = new Torre(true,"Torre",50);
                    tablero[i][j].setNombre(tablero[i][j].unicode(tablero[i][j].getNombre()));
                } else if ((i == 0 && j == 1) || (i == 0 && j == 6)) {
                    tablero[i][j] = new Caballo(true,"Caballo",30);
                    tablero[i][j].setNombre(tablero[i][j].unicode(tablero[i][j].getNombre()));
                } else if ((i == 0 && j == 2) || (i == 0 && j == 5)) {
                    tablero[i][j] = new Alfil(true,"Alfil",30);
                    tablero[i][j].setNombre(tablero[i][j].unicode(tablero[i][j].getNombre()));
                } else if ((i == 0 && j == 3)) {
                    tablero[i][j] = new Reina(true,"Reina",90);
                    tablero[i][j].setNombre(tablero[i][j].unicode(tablero[i][j].getNombre()));
                } else if (i == 0) {
                    tablero[i][j] = new Rey(true, "Rey",900);
                    tablero[i][j].setNombre(tablero[i][j].unicode(tablero[i][j].getNombre()));
                } else if (i == 1){
                    tablero[i][j] = new Peon(true,"Peon",10);
                    tablero[i][j].setNombre(tablero[i][j].unicode(tablero[i][j].getNombre()));
                } else if ((i == 7 && j == 0) || (i == 7 && j == 7)){
                    tablero[i][j] = new Torre(false,"Torre",50);
                    tablero[i][j].setNombre(tablero[i][j].unicode(tablero[i][j].getNombre()));
                } else if ((i == 7 && j == 1) || (i == 7 && j == 6)) {
                    tablero[i][j] = new Caballo(false,"Caballo",30);
                    tablero[i][j].setNombre(tablero[i][j].unicode(tablero[i][j].getNombre()));
                } else if ((i == 7 && j == 2) || (i == 7 && j == 5)) {
                    tablero[i][j] = new Alfil(false,"Alfil",30);
                    tablero[i][j].setNombre(tablero[i][j].unicode(tablero[i][j].getNombre()));
                } else if ((i == 7 && j == 3)) {
                    tablero[i][j] = new Reina(false,"Reina",90);
                    tablero[i][j].setNombre(tablero[i][j].unicode(tablero[i][j].getNombre()));
                } else if (i == 7) {
                    tablero[i][j] = new Rey(false,"Rey",900);
                    tablero[i][j].setNombre(tablero[i][j].unicode(tablero[i][j].getNombre()));
                } else if (i == 6){
                    tablero[6][j] = new Peon(false,"Peon",10);
                    tablero[i][j].setNombre(tablero[i][j].unicode(tablero[i][j].getNombre()));
                } else {
                    tablero[i][j] = null;
                }
            }
        }
    }

    //Constuctor de un Tablero para testeo que inicializa dos piezas
    public Tablero(Pieza piezaTester, Pieza piezaTester2) {
        tablero = new Pieza[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == 0 && j == 7){
                    tablero[i][j] = piezaTester;
                    tablero[i][j].setNombre(tablero[i][j].unicode(tablero[i][j].getNombre()));
                } else if (i == 1 && j == 6) {
                    tablero[i][j] = piezaTester2;
                    tablero[i][j].setNombre(tablero[i][j].unicode(tablero[i][j].getNombre()));
                } else {
                    tablero[i][j] = null;
                }
            }
        }
    }

    //Metodos

    //Metodo para pintar (hacer print) las casillas de blanco y negro y pintar piezas si la casilla no es null
    public void pintarTablero() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print("|");
                if (i % 2 == 0) {
                    if (tablero[i][j] == null && (j % 2 != 0)) {
                        System.out.print(new String(Character.toChars(127024)));
                    } else if (tablero[i][j] == null && (j % 2 == 0)) {
                        System.out.print(new String(Character.toChars(127025)));
                    }
                } else {
                    if (tablero[i][j] == null && (j % 2 != 0)) {
                        System.out.print(new String(Character.toChars(127025)));
                    } else if (tablero[i][j] == null && (j % 2 == 0)) {
                        System.out.print(new String(Character.toChars(127024)));
                    }
                }

                if (tablero[i][j] != null)
                    tablero[i][j].pintarPieza();
                if (j == 7)
                    System.out.println();
            }
        }
    }

    //Metodo para validar algunos errores que pueden ocurrir a la hora de mover una pieza
    public boolean validacion(Tablero tablero, Movimiento movimiento, boolean turno) {
        boolean esValido = false;
        if (tablero.getTablero()[movimiento.getPosInicial().getFila()][movimiento.getPosInicial().getColumna()] == null) {
            System.out.println("No hay ninguna pieza en la coordenada inicial!");
            System.out.println("-------------------------");
        } else {
            if ((tablero.getTablero()[movimiento.getPosInicial().getFila()][movimiento.getPosInicial().getColumna()].getColor()
                    && !turno) || (!tablero.getTablero()[movimiento.getPosInicial().getFila()][movimiento.getPosInicial().getColumna()].getColor()
                    && turno)) {
                System.out.println("No es el turno de ese color");
                System.out.println("-------------------------");
            } else if (tablero.getTablero()[movimiento.getPosFinal().getFila()][movimiento.getPosFinal().getColumna()] != null) {
                if (tablero.getTablero()[movimiento.getPosInicial().getFila()][movimiento.getPosInicial().getColumna()].getColor() ==
                        tablero.getTablero()[movimiento.getPosFinal().getFila()][movimiento.getPosFinal().getColumna()].getColor()) {
                    System.out.println("No puedes comer a una pieza de tu mismo color");
                    System.out.println("-------------------------");
                } else {
                    esValido = true;
                }
            } else if (!tablero.getTablero()[movimiento.getPosInicial().getFila()][movimiento.getPosInicial().getColumna()].validoMovimiento(movimiento,tablero)) {
                System.out.println("La pieza tiene prohibido ese movimiento");
                System.out.println("-------------------------");
            } else {
                esValido = true;
            }
        }
        return esValido;
    }

    //Metodo para mover una pieza de una posicion a otra o avisar de que hay una pieza entre medias de la coordenada
    public boolean mover(Movimiento mov) {
        boolean esValido = false;
        if (noHayPiezasEntre(mov)) {
            tablero[mov.getPosFinal().getFila()][mov.getPosFinal().getColumna()]
                    = tablero[mov.getPosInicial().getFila()][mov.getPosInicial().getColumna()];
            tablero[mov.getPosInicial().getFila()][mov.getPosInicial().getColumna()] = null;
            esValido = true;
        } else {
            System.out.println("Ojo! Hay una pieza entre medias de las dos coordenadas");
            System.out.println("-------------------------");
        }
        return esValido;
    }

    //Metodo para comprobar que no haya piezas en el recorrido de la pieza que se mueve
    public boolean noHayPiezasEntre(Movimiento mov) {
        boolean noHayPiezas = true;
        if (mov.esVertical()) {
            if (mov.getPosInicial().getFila() < mov.getPosFinal().getFila()) {
                for (int i = mov.getPosInicial().getFila() + 1; i <= mov.getPosFinal().getFila() - 1; i++) {
                    if (hayPieza(i,mov.getPosInicial().getColumna())) {
                        noHayPiezas = false;
                    }
                }
            } else {
                for (int i = mov.getPosInicial().getFila() - 1; i >= mov.getPosFinal().getFila() + 1; i--) {
                    if (hayPieza(i,mov.getPosInicial().getColumna())) {
                        noHayPiezas = false;
                    }
                }
            }
        } else if (mov.esHorizontal()) {
            if (mov.getPosInicial().getColumna() < mov.getPosFinal().getColumna()) {
                for (int i = mov.getPosInicial().getColumna() + 1; i <= mov.getPosFinal().getColumna() - 1; i++) {
                    if (hayPieza(mov.getPosInicial().getFila(),i)) {
                        noHayPiezas = false;
                    }
                }
            } else {
                for (int i = mov.getPosInicial().getColumna() - 1; i >= mov.getPosFinal().getColumna() + 1; i--) {
                    if (hayPieza(mov.getPosInicial().getFila(),i)) {
                        noHayPiezas = false;
                    }
                }
            }
        } else if (mov.esDiagonal()) {
            if (mov.getPosInicial().getColumna() < mov.getPosFinal().getColumna() && mov.getPosInicial().getFila() < mov.getPosFinal().getFila()) {
                for (int i = mov.getPosInicial().getFila() + 1; i <= mov.getPosFinal().getFila() - 1; i++) {
                    for (int j = mov.getPosInicial().getColumna(); j <= mov.getPosFinal().getColumna(); j++) {
                        if (Math.abs(i - mov.getPosInicial().getFila()) == Math.abs(j - mov.getPosInicial().getColumna())){
                            if (hayPieza(i,j)) {
                                noHayPiezas = false;
                            }
                        }
                    }
                }
            } else if (mov.getPosInicial().getColumna() > mov.getPosFinal().getColumna() && mov.getPosInicial().getFila() < mov.getPosFinal().getFila()) {
                for (int i = mov.getPosInicial().getFila() + 1; i <= mov.getPosFinal().getFila() - 1; i++) {
                    for (int j = mov.getPosInicial().getColumna(); j >= mov.getPosFinal().getColumna(); j--) {
                        if (Math.abs(i - mov.getPosInicial().getFila()) == Math.abs(j - mov.getPosInicial().getColumna())){
                            if (hayPieza(i,j)) {
                                noHayPiezas = false;
                            }
                        }
                    }
                }
            } else if (mov.getPosInicial().getColumna() < mov.getPosFinal().getColumna() && mov.getPosInicial().getFila() > mov.getPosFinal().getFila()) {
                for (int i = mov.getPosInicial().getFila() - 1; i >= mov.getPosFinal().getFila() + 1; i--) {
                    for (int j = mov.getPosInicial().getColumna(); j <= mov.getPosFinal().getColumna(); j++) {
                        if (Math.abs(i - mov.getPosInicial().getFila()) == Math.abs(j - mov.getPosInicial().getColumna())){
                            if (hayPieza(i,j)) {
                                noHayPiezas = false;
                            }
                        }
                    }
                }
            } else {
                for (int i = mov.getPosInicial().getFila() - 1; i >= mov.getPosFinal().getFila() + 1; i--) {
                    for (int j = mov.getPosInicial().getColumna(); j >= mov.getPosFinal().getColumna(); j--) {
                        if (Math.abs(i - mov.getPosInicial().getFila()) == Math.abs(j - mov.getPosInicial().getColumna())){
                            if (hayPieza(i,j)) {
                                noHayPiezas = false;
                            }
                        }
                    }
                }
            }
        }
        return noHayPiezas;
    }

    //Metodo para averiguar si hay una pieza en una casilla determinada
    public boolean hayPieza(int fila, int columna) {
        boolean hayPieza = false;
        if (this.tablero[fila][columna] != null)
            hayPieza = true;
        return hayPieza;
    }
}
