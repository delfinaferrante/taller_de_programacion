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
public abstract class Membresia {
    private String nombre;
    private String fechaCreacion;
    private int dimF;
    private int dimL;
    private Jugador[]jugadores;
    
    public Membresia(String nombre, String fechaCreacion, int dimF){
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.dimF = dimF;
        this.jugadores = new Jugador[dimF];
        this.dimL = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public boolean hayLugar(){
        return dimL < dimF;
    }
    public void agregarJugador(Jugador unJugador){
        if(hayLugar()){
            jugadores[dimL]= unJugador;
            dimL++;
        }
    }
    public int cantJugadores(){
        return dimL;
    }
    
    public boolean valorValido(int valor){
        return (valor < dimF);
    }
    
    public Jugador obtenerJugador(int valor){
       if(valorValido(valor)){
           return jugadores[valor];
       }else
           return null;
    }
    
    public void aumentarPuntos(double puntaje, String nombre){
        int pos = 0;
        while ((pos<dimL)&&(!jugadores[pos].getNombre().equals(nombre))){
            pos++;
        }
        if(pos < dimL){
            jugadores[pos].aumentarPuntos(puntaje);
            jugadores[pos].actualizarApuestas();
        }else
            System.out.println("El jugador llamado " + nombre + " no esta en la membresia.");
    }
    
    public abstract Jugador obtenerMejorJugador();
    
    public String toString(){
        String aux = "";
        aux = "MEMBRESIA " + getNombre() + "\n Fecha de creacion: " + getFechaCreacion() + "/ Mejor jugador: " + this.obtenerMejorJugador();
        return aux;
    }
}
