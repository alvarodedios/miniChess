package com.alvaro.poo1;

public class Peon extends Pieza{

    public Peon (boolean color, String nombre,int puntos) {
        super(color,nombre,puntos);
    }


    //Metodo para comprobar si el movimiento de la pieza esta sujeto a las restricciones de su clase
    @Override
    public boolean validoMovimiento(Movimiento mov,Tablero tablero) {
        boolean respuesta = false;
        if (this.getColor()) {
            if (mov.saltoVerticalNoAbsoluto() == -1 && !mov.esDiagonal()) {
                respuesta = true;
            } else if (mov.saltoVerticalNoAbsoluto() == -1 && mov.esDiagonal() && tablero.hayPieza(mov.getPosFinal().getFila(),mov.getPosFinal().getColumna())) {
                respuesta = true;
            }
        } else {
            if (mov.saltoVerticalNoAbsoluto() == 1 && !mov.esDiagonal()) {
                respuesta = true;
            } else if (mov.saltoVerticalNoAbsoluto() == 1 && mov.esDiagonal() && tablero.hayPieza(mov.getPosFinal().getFila(),mov.getPosFinal().getColumna())) {
                respuesta = true;
            }
        }
        return respuesta;
    }

    //Metodo que imprime el nombre de la pieza
    public void pintarPieza() {
        System.out.print(getNombre());
    }
}
