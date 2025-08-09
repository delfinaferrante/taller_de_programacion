/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial10;

/**
 *
 * @author fer_m
 */
public class Producto {
    private int cod;
    private String nombre;
    private String marca;
    private int unidades;
    private double precioUnidad;
    
    public Producto(int cod, String nombre, String marca, int unidades, double precioUnidad){
        setCod(cod);
        setNombre(nombre);
        setMarca(marca);
        setUnidades(unidades);
        setPrecioUnidad(precioUnidad);
    }

    public void setCod(int cod) {
        this.cod = cod;
    }
    
    public int getCod(){
        return cod;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre(){
        return nombre;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    public String getMarca(){
        return marca;
    }
    
    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }
    
    public int getUnidades(){
        return unidades;
    }

    public void setPrecioUnidad(double precioUnidad) {
        this.precioUnidad = precioUnidad;
    }
    
    public double getPrecioUnidad(){
        return precioUnidad;
    }
    
    public String toString(){
        String aux = "  Producto: (cod: " + getCod() + " - " + getNombre() + " - " + getMarca() + " - " +
                        getUnidades() + " unidades exhibidas - Precio por unidad: $" + getPrecioUnidad();
        return aux;
    }
}
