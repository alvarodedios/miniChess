package com.alvaro.poo1;

public class Torre extends Pieza{

    //Constructor
    public Torre (boolean color, String nombre,int puntos) { super(color,nombre,puntos); }

    //Metodos

    //Metodo para comprobar si el movimiento de la pieza esta sujeto a las restricciones de su clase
    @Override
    public boolean validoMovimiento(Movimiento mov,Tablero tablero) {
        boolean respuesta = false;
        if (mov.esHorizontal() || mov.esVertical())
            respuesta = true;
        return respuesta;
    }

    //Metodo que imprime el nombre de la pieza
    public void pintarPieza() {
        System.out.print(getNombre());
    }
}
