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
public class MembresiaVip extends Membresia {
    private double costo;
    
    public MembresiaVip(String nombre, String fechaCreacion, int dimF, double costo){
        super(nombre, fechaCreacion,dimF);
        this.costo = costo;
    }
    
    public Jugador obtenerMejorJugador(){
        double puntajeMax = -1;
        Jugador aux = null;
        for(int i=0; i<super.cantJugadores();i++){
            if(super.obtenerJugador(i).getPuntaje() > puntajeMax){
                puntajeMax = super.obtenerJugador(i).getPuntaje();
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