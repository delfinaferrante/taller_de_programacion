/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parciales;

/**
 *
 * @author Usuario
 */
public class Goleador {
    private String nombre;
    private String equipo;
    private int cantGoles;
    
    public Goleador(String nombre, String equipo, int cantGoles){
        this.nombre = nombre;
        this.equipo = equipo;
        this.cantGoles = cantGoles;
    }
    
    public int getCantGoles(){
        return cantGoles;
    }
    
    public String toString(){
        String aux = nombre + ", " + equipo + ", cant de goles: " + cantGoles + "\n";
        return aux;
    }
            
}
