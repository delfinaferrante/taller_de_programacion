/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial5;

/**
 *
 * @author Delfi
 */
public class Canciones {
    private String nombre;
    private String compositor;
    private int id;
    private Estudiante ganador;
    private int puntaje;
    
    public Canciones(String nombre, String compositor, int id){
        setNombre(nombre);
        setCompositor(compositor);
        this.id = id;
        setPuntaje(0);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getId(){
        return id;
    }
    
    public void setCompositor(String compositor) {
        this.compositor = compositor;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
    public void cambiarGanador(Estudiante nuevoGanador){
        this.ganador = nuevoGanador;
    }

    public String getNombre() {
        return nombre;
    }

    public Estudiante getGanador() {
        return ganador;
    }

    public int getPuntaje() {
        return puntaje;
    }
    
    public void comparoYActualizoPuntaje(int unPuntaje, Estudiante interpretador){
        if(getPuntaje() < unPuntaje){
            setPuntaje(unPuntaje);
            cambiarGanador(interpretador);
        }
    }
    
    
}
