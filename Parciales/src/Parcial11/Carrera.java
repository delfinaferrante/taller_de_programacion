/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial11;

/**
 *
 * @author fer_m
 */
public class Carrera {
    private String nombre;
    private String facultad;
    private int añoCreacion;
    
    public Carrera(String nombre, String facultad, int añoCreacion){
        setNombre(nombre);
        setFacultad(facultad);
        setAñoCreacion(añoCreacion);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public void setAñoCreacion(int añoCreacion) {
        this.añoCreacion = añoCreacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFacultad() {
        return facultad;
    }

    public int getAñoCreacion() {
        return añoCreacion;
    }
    
    public String toString(){
        String aux = "Carrera " + getNombre() + ". " + getFacultad() + ". Año de creacion: " + getAñoCreacion() + "\n";
        return aux;
    }
    
}
