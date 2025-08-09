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
public class Minorista extends Compras{
    private boolean esJubilado;
    
    public Minorista(int numero, int dimF, boolean esJubilado){
        super(numero,dimF);
        this.esJubilado = esJubilado;
    }
    public boolean estadoJubilado(){
        return esJubilado;
    }
    
    public String toString(){
        String aux = super.toString() + ". ";
        if(estadoJubilado()){
            aux+= "Es jubilado. \n";
        }else
            aux+= "No es jubilado.\n";
        return aux;
    }
}
