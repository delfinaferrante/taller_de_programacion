/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial9;

/**
 *
 * @author fer_m
 */
public class Ingrediente extends Comun{
    private String grupo;
    
    public Ingrediente(String nombre, double costo, String grupo){
        super(nombre, costo);
        setGrupo(grupo);
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
    public String getGrupo(){
        return grupo;
    }
    
    public double costoFinal(){
        if(getGrupo().equals("B")){
            setCosto(getCosto() * 1.10);
        }
        return getCosto();
    }
    
    public String toString(){
        String aux = super.toString() + getGrupo();
        return aux;
    }
}
