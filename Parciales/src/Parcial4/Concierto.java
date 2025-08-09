/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial4;

/**
 *
 * @author Delfi
 */
public class Concierto {
    private String nombreArtista;
    private double precioEntrada;
    private int entradasVendidas;
    
    public Concierto(String nombreArtista, double precioEntrada,int entradasVendidas){
        setNombreArtista(nombreArtista);
        setPrecioEntrada(precioEntrada);
        setEntradasVendidas(entradasVendidas);
    }

    public void setNombreArtista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
    }

    public void setPrecioEntrada(double precioEntrada) {
        this.precioEntrada = precioEntrada;
    }

    public void setEntradasVendidas(int entradasVendidas) {
        this.entradasVendidas = entradasVendidas;
    }

    public String getNombreArtista() {
        return nombreArtista;
    }

    public double getPrecioEntrada() {
        return precioEntrada;
    }

    public int getEntradasVendidas() {
        return entradasVendidas;
    }
    
    
    public String toString(){
        String aux = getNombreArtista() + ", $" + getPrecioEntrada() + ", " + getEntradasVendidas() + " entradas vendidas. \n";
        return aux;
    }
}
