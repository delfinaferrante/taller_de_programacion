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
public abstract class Compras {
    private int numero;
    private int dimF;
    private int dimL;
    private Productos[] vProductos;
    
    public Compras(int numero, int dimF){
        setNumero(numero);
        this.dimF = dimF;
        this.vProductos = new Productos[dimF];
        this.dimL = 0;
    }

    public int getNumero() {
        return numero;
    }
    
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public boolean hayLugar(){
        return dimL < dimF;
    }
    
    public void agregarProducto(Productos unProducto){
        if(hayLugar()){
            vProductos[dimL] = unProducto;
            dimL++;
        }
    }
    
    public double obtenerPrecioCompra(){
        double total = 0;
        for(int i=0; i<dimL;i++){
            total += vProductos[i].getPrecio();
        }
        double iva = total * 0.21; 
        return total + iva;
    }
    
    public String toString(){
        String aux = "Nro " + getNumero() + ", ";
        for(int i=0; i<dimL; i++){
            aux+= vProductos[i].toString();
        }
        aux+= "Precio de la compra: $" + obtenerPrecioCompra();
        return aux;
    }
}
