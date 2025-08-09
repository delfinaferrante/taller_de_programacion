/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRACTICA1;

import PaqueteLectura.Lector;

public class Ejercicio5 {
    
    public static void main(String[]args){
        int clientes = 5;
        int aspectos = 4;
        int[][] calific = new int[clientes][aspectos];
        
        int i;
        for (i=0; i<clientes; i++){
            System.out.println("Puntajes cliente " + (i+1) + ": ");
            System.out.print("Atencion al cliente: ");
            calific[i][0]= Lector.leerInt();
                
            System.out.print("Calidad de la comida: ");
            calific[i][1]= Lector.leerInt();
                
            System.out.print("Precio: ");
            calific[i][2]= Lector.leerInt();
                
            System.out.print("Ambiente: ");
            calific[i][3]= Lector.leerInt();
        }
        
        System.out.println("-- MATRIZ --");
        for (i=0; i<clientes; i++){
            System.out.println("-- Cliente " + (i+1) + " -- ");
            System.out.print(" Atencion al cliente: " + calific[i][0]);   
            System.out.print(" / Calidad de la comida: " + calific[i][1]);               
            System.out.print(" / Precio: " + calific[i][2]);      
            System.out.print(" / Ambiente: " +  calific[i][3]);
            
            System.out.println(" ------------ ");
        }
        
        double suma;
        for (i=0; i<aspectos;i++){
            suma = 0;
            for (int j=0; j<clientes; j++)
                suma += calific[i][j];
            System.out.println("Promedio de cliente " + (i+1) + ": " + (suma/aspectos));
        }
    }
    
}
