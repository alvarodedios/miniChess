package com.alvaro.poo1;

public class Posicion {

    //Atributos
    private int fila;
    private int columna;

    //Accessores
    public int getFila() {
        return fila;
    }
    public void setFila(int fila) { this.fila = fila; }

    public int getColumna() {
        return columna;
    }
    public void setColumna(int columna) {
        this.columna = columna;
    }

    //Constructor
    public Posicion (int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }
}
