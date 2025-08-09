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
public class Mayorista extends Compras{
    private int cuit;
    
    public Mayorista(int numero, int dimF, int cuit){
        super(numero,dimF);
        setCuit(cuit);
    }

    public void setCuit(int cuit) {
        this.cuit = cuit;
    }
    public int getCuit(){
        return cuit;
    }
    
    public String toString(){
        String aux = super.toString() + " - CUIT " + getCuit();
        return aux;
    }    
}
