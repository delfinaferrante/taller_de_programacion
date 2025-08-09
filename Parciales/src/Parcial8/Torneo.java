/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial8;

/**
 *
 * @author fer_m
 */
public class Torneo {
    private String nombre;
    private String fecha;
    private double montoInscripciones;
    private double montoPremios;
    
    public Torneo(String nombre, String fecha, double montoInscripciones, double montoPremios){
        setNombre(nombre);
        setFecha(fecha);
        setMontoInscripciones(montoInscripciones);
        setMontoPremios(montoPremios);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getMontoInscripciones() {
        return montoInscripciones;
    }

    public void setMontoInscripciones(double montoInscripciones) {
        this.montoInscripciones = montoInscripciones;
    }

    public double getMontoPremios() {
        return montoPremios;
    }

    public void setMontoPremios(double montoPremios) {
        this.montoPremios = montoPremios;
    }
    
}
