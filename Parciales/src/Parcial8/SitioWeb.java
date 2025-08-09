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
public abstract class SitioWeb {
    private String nombre;
    private String localidad;
    private int cantUsuarios;
    
    public SitioWeb(String nombre, String localidad){
        setNombre(nombre);
        setLocalidad(localidad);
        setCantUsuarios(0);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public int getCantUsuarios() {
        return cantUsuarios;
    }

    public void setLocalidad(String direccion) {
        this.localidad = direccion;
    }

    public void setCantUsuarios(int cantUsuarios) {
        this.cantUsuarios = cantUsuarios;
    }
    
    public abstract double cotizarSitio();
    
    public String toString(){
        String aux = "Nombre: " + getNombre() + ", " + getLocalidad() + ", " + getCantUsuarios() +
                    " usuarios; cotización comercial: $" + this.cotizarSitio();
        return aux;                   
    }
}
