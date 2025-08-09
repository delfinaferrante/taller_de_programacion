/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRACTICA1;

import PaqueteLectura.GeneradorAleatorio;

public class Ejercicio2 {
    
    public static void main(String[] args){
        int DF = 15;
        double [] alturas = new double[DF];
        
        GeneradorAleatorio.iniciar();
        double sumaAlturas = 0;
        int i;
        for (i=0; i<DF; i++){
            alturas[i] = GeneradorAleatorio.generarDouble(2)+1;
            sumaAlturas += alturas[i];
            System.out.println("Jugador "+ (i+1) + ": " + alturas[i]);
        }
        double promedioAltura = (sumaAlturas/DF);
        System.out.println("El promedio de alturas es de: " + promedioAltura);
        
        int cant = 0;
        for (i=0; i<DF; i++){
            if (alturas[i] > promedioAltura)
                cant ++;
        }
        System.out.println("Cantidad de jugadores con altura encima del promedio: " + cant);
        
    }
    
    
}
