package com.alvaro.poo1;

public abstract class Pieza {

    //Atributos
    private boolean color;
    private String nombre;
    private int puntos;

    //Accesores
    public boolean getColor() { return color; }
    public void setColor(boolean color) { this.color = color; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getPuntos() { return puntos; }
    public void setPuntos(int puntos) { this.puntos = puntos; }

    //Constructor
    public Pieza (boolean color, String nombre, int puntos) {
        this.color = color;
        this.nombre = nombre;
        this.puntos = puntos;
    }

    //Metodos abstractos que se definiran en la clase hija
    public abstract boolean validoMovimiento(Movimiento mov, Tablero tablero);
    public abstract void pintarPieza();

    //Metodo para transformar un nombre de pieza en el caracter unicode de su clase
    public String unicode(String nombre) {
        String unicode = null;
        if (getColor()) {
            switch (nombre) {
                case "Torre":
                    unicode = "\u265C";
                    break;
                case "Caballo":
                    unicode = "\u265E";
                    break;
                case "Alfil":
                    unicode = "\u265D";
                    break;
                case "Reina":
                    unicode = "\u265B";
                    break;
                case "Rey":
                    unicode = "\u265A";
                    break;
                case "Peon":
                    unicode = "\u265F";
                    break;
            }
        } else {
            switch (nombre) {
                case "Torre" :
                    unicode = "\u2656";
                    break;
                case "Caballo" :
                    unicode = "\u2658";
                    break;
                case "Alfil" :
                    unicode = "\u2657";
                    break;
                case "Reina" :
                    unicode = "\u2655";
                    break;
                case "Rey" :
                    unicode = "\u2654";
                    break;
                case "Peon" :
                    unicode = "\u2659";
                    break;
            }
        }
        return unicode;
    }
}
