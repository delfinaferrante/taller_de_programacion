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
public class Jugador {
    private String nombre;
    private int apuestasGanadas;
    private double puntaje;
    
    public Jugador(String nombre){
        this.nombre = nombre;
        this.apuestasGanadas = 0;
        this.puntaje = 0;
    }
    public String getNombre(){
        return nombre;
    }
    
    public int getApuestasGanadas() {
        return apuestasGanadas;
    }

    public void setApuestasGanadas(int apuestasGanadas) {
        this.apuestasGanadas = apuestasGanadas;
    }

    public double getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(double puntaje) {
        this.puntaje = puntaje;
    }
    
    public double aumentarPuntos(double p){
        double actualizacion = getPuntaje() + p;
        setPuntaje(actualizacion);
        return actualizacion;
    }
    public int actualizarApuestas(){
        int apuestas = getApuestasGanadas()+ 1;
        setApuestasGanadas(apuestas);
        return apuestas;
    }
    
    public String toString(){
        String aux = getNombre() + ", " + getApuestasGanadas() + ", " + getPuntaje() + "\n";
        return aux;
    }
}
