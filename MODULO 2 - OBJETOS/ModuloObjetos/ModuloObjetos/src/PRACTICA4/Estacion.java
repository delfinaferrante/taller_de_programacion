/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRACTICA4;


public class Estacion {
    private String nombre;
    private double longitud;
    private double latitud;
    
    public Estacion(String nombreEstacion, double suLongitud, double suLatitud){
        setNombre(nombreEstacion);
        setLongitud(suLongitud);
        setLatitud(suLatitud);
    }
    
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombreEstacion){
        nombre = nombreEstacion;
    }
    
    public double getLongitud(){
        return longitud;
    }
    public void setLongitud(double suLongitud){
        longitud = suLongitud;
    }
        
    public double getLatitud(){
        return latitud;
    }
    public void setLatitud(double suLatitud){
        latitud = suLatitud;
    }

    public String toString(){
        String aux = nombre + "(" + latitud + "S - " + longitud + "O): \n";
        return aux;
    }
}
