/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial3;

/**
 *
 * @author Delfi
 */
public class Productos {
    private int cod;
    private double precio;
    private String descripcion;
    
    public Productos(int cod, double precio, String descripcion){
        setCod(cod);
        setPrecio(precio);
        setDescripcion(descripcion);
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }
    public int getCod(){
        return cod;
    }
    public String getDescripcion(){
        return descripcion;
    }
    
    public String toString(){
        String aux = "Productos (" + getCod() + ", " + getPrecio() + ", " + getDescripcion() + ") \n";
        return aux;
    }
}
