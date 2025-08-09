/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRACTICA1;

import PaqueteLectura.Lector;

public class Ejercicio4 {
    
    public static void main(String[]args){
        int pisos = 8;
        int oficinas = 4;
        int[][] edificio = new int [pisos][oficinas];
        
        System.out.println("Numero de piso (de 1 a 8): ");
        int piso = Lector.leerInt();
        int ofic;
        while (piso != 9){
            System.out.println("Numero de oficina (de 1 a 4): ");
            ofic = Lector.leerInt();
            edificio[piso-1][ofic-1] += 1;
            System.out.println("Numero de piso (de 1 a 8): ");
            piso = Lector.leerInt();
        }
        
        for (int i=0; i<pisos; i++){
            System.out.println("  ");
            System.out.println("--- Piso " + (i+1) + " ---");
            for (int j=0; j<oficinas; j++)
                System.out.print("Oficina "+ (j+1) + ": " + edificio[i][j] + " personas. | ");
        }
         System.out.println("------");

    }
}
