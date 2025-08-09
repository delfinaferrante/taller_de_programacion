/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial1;

/**
 *
 * @author Delfi
 */
public class MembresiaProfesional extends Membresia{
   
    public MembresiaProfesional(String nombre, String fechaCreacion, int dimF){
        super(nombre, fechaCreacion,dimF);
     }
    
   /* public String mejorJugador(){
        Jugador mejor = super.masApuestasGanadas();
        return mejor.toString();
    }*/
    public Jugador obtenerMejorJugador(){
        int apuestasMax = -1;
        Jugador aux = null;
        for(int i=0; i<super.cantJugadores();i++){
            if(super.obtenerJugador(i).getApuestasGanadas() > apuestasMax){
                apuestasMax = super.obtenerJugador(i).getApuestasGanadas();
                aux = super.obtenerJugador(i);
            }
        }
        return aux;
    }
    
    public String toString(){
        String aux = super.toString();
        return aux;
    }
}
