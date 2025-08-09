/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parciales;

/**
 *
 * @author Usuario
 */
public class Paciente {
    private String nombre;
    private boolean tieneObraSocial;
    private double costo;
    
    public Paciente(String unNombre, boolean tieneObra){
        nombre = unNombre;
        tieneObraSocial = tieneObra;
        if (tieneObraSocial){
            costo = 11500.5;
        } else
            costo = 6500.5;
    }
    
    public String toString(){
        String aux = "Nombre del paciente: " + nombre;
        return aux;
    }
    
    public double getCosto(){
        return costo;
    }
}
