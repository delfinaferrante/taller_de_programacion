/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5ej2;

    public class Auto {
        private String nombreDueño;
        private String patente;

    public Auto(String nomDueño, String unaPatente){
        this.nombreDueño = nomDueño;
        this.patente = unaPatente;
    }

    public String getPatente(){
        return patente;
    }
    
    public String toString(){
        String aux = "auto a nombre de " + nombreDueño + ", patente: " + patente + "\n";
        return aux;
    }
}
