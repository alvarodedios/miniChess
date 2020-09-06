package com.alvaro.poo1;

public class Movimiento {

    //Atributos
    private Posicion posInicial;
    private Posicion posFinal;

    //Accesores
    public Posicion getPosInicial() {
        return posInicial;
    }
    public void setPosInicial(Posicion posInicial) {
        this.posInicial = posInicial;
    }

    public Posicion getPosFinal() {
        return posFinal;
    }
    public void setPosFinal(Posicion posFinal) {
        this.posFinal = posFinal;
    }

    //Constructor
    public Movimiento(Posicion posInicial, Posicion posFinal) {
        this.posInicial = posInicial;
        this.posFinal = posFinal;
    }

    //Metodos

    //Metodo para comprobar si las posiciones final e inicial se encuentran dentro de los limites del tablero
    public boolean movimiento(Posicion posInicial,Posicion posFinal) {
        boolean esValido = false;
        if (posInicial.getColumna() < 0 || posInicial.getColumna() > 7) {
            System.out.println("La columna inicial no se encuentra en el tablero");
            System.out.println("-------------------------");
        } else if (posInicial.getFila() < 0 || posInicial.getFila() > 7) {
            System.out.println("La fila inicial no se encuentra en el tablero");
            System.out.println("-------------------------");
        } else if (posFinal.getColumna() < 0 || posFinal.getColumna() > 7){
            System.out.println("La columna final no se encuentra en el tablero");
            System.out.println("-------------------------");
        } else if (posFinal.getFila() < 0 || posFinal.getFila() > 7) {
            System.out.println("La fila final no se encuentra en el tablero");
            System.out.println("-------------------------");
        } else {
            esValido = true;
            this.posInicial = posInicial;
            this.posFinal = posFinal;
        }
        return esValido;
    }

    //Metodo que devuelve true si un movimiento es vertical
    public boolean esVertical() {
        boolean vertical = false;
        if (posInicial.getColumna() == posFinal.getColumna())
            vertical = true;
        return vertical;
    }

    //Metodo que devuelve true si un movimiento es horizontal
    public boolean esHorizontal() {
        boolean horizontal = false;
        if (posInicial.getFila() == posFinal.getFila())
            horizontal = true;
        return horizontal;
    }

    //Metodo que devuelve true si un movimiento es diagonal
    public boolean esDiagonal() {
        boolean diagonal = false;
        if ((Math.abs(posInicial.getFila() - posFinal.getFila())) == (Math.abs(posInicial.getColumna() - posFinal.getColumna())))
            diagonal = true;
        return diagonal;
    }

    //Metodo que devuelve en valor absoluto el salto vertical que se da en un movimiento
    public int saltoVertical() {
        return Math.abs(posInicial.getFila() - posFinal.getFila());
    }

    //Metodp que devuelve el salto vertical que se da en un movimiento
    public int saltoVerticalNoAbsoluto() { return posInicial.getFila() - posFinal.getFila(); }

    //Metodo que devuelve en valor absoluto el salto horizontal que se da en un movimiento
    public int saltoHorizontal() {
        return Math.abs(posInicial.getColumna() - posFinal.getColumna());
    }
}
