package com.alvaro.poo1;

public class Caballo extends Pieza{

    public Caballo (boolean color, String nombre,int puntos) {
        super(color,nombre,puntos);
    }


    //Metodo para comprobar si el movimiento de la pieza esta sujeto a las restricciones de su clase
    @Override
    public boolean validoMovimiento(Movimiento mov,Tablero tablero) {
        boolean respuesta = false;
        if (Math.abs(mov.saltoVertical() - mov.saltoHorizontal()) == 1 && ((mov.saltoVertical() == 2 || mov.saltoHorizontal() == 2)))
            respuesta = true;
        return respuesta;
    }

    //Metodo que imprime el nombre de la pieza
    public void pintarPieza() {
        System.out.print(getNombre());
    }
}
