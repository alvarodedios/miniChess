package com.alvaro.poo1;

public class Reina extends Pieza{

    public Reina (boolean color, String nombre,int puntos) {
        super(color,nombre,puntos);
    }


    //Metodo para comprobar si el movimiento de la pieza esta sujeto a las restricciones de su clase
    @Override
    public boolean validoMovimiento(Movimiento mov,Tablero tablero) {
        boolean respuesta = false;
        if (mov.esHorizontal() || mov.esVertical() || mov.esDiagonal()) {
            respuesta = true;
        }
        return respuesta;
    }

    //Metodo que imprime el nombre de la pieza
    public void pintarPieza() {
        System.out.print(getNombre());
    }
}
