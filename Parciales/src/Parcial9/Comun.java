/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial9;

/**
 *
 * @author fer_m
 */
public abstract class Comun {
    private String nombre;
    private double costo;
    
    public Comun(String nombre, double costo){
        setNombre(nombre);
        setCosto(costo);
    }
    public Comun(String nombre){
        setNombre(nombre);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getCosto() {
        return costo;
    }
    
    public abstract double costoFinal();
    
    public String toString(){
        String aux = getNombre() + " - " + getCosto() + " - ";
        return aux;
    }
}
