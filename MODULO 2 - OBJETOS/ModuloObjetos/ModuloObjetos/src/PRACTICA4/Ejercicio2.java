/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRACTICA4;

/**
 *
 * @author Usuario
 */
public class Ejercicio2 {
    public static void main(String[]args){
        Jugador unJugador = new Jugador(10, 5, "Edinson Cavani", 520.6, 20);
        Entrenador DT = new Entrenador(40, "Guillermo Arruabarrena", 2010.5, 25);
        
        System.out.println(unJugador.calcularSueldoACobrar());
        System.out.println(unJugador.calcularPlusSueldo());
        
        System.out.println(unJugador.toString());
        DT.calcularPlusSueldo();
        System.out.println(DT.toString());
        
    }
}
