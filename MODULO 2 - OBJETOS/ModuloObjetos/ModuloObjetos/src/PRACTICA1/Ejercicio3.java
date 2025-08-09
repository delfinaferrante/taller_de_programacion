/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRACTICA1;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

public class Ejercicio3 {
    
    public static void main(String[]args){
        
        GeneradorAleatorio.iniciar();
        
        int dim = 5;
        int [][] matriz = new int[dim][dim];
        
        int i, j;
        for (i=0; i<dim; i++){
            System.out.println("-------");
            for (j=0; j<dim; j++){
               matriz[i][j] = GeneradorAleatorio.generarInt(31);
               System.out.print("(" + i + "," + j + ") " + matriz[i][j] + " | ");
            }
        }
        System.out.println("-------");
       
        
        int sumaFila1 = 0;
        for (i=0; i<dim; i++)
            sumaFila1 += matriz[1][i];
        
        System.out.println("Suma de los elementos de la FILA 1: " + sumaFila1);
        
        int [] vector = new int[dim];
        int suma;
        for (j=0; j<dim; j++){
            suma = 0;
            for (i=0; i<dim; i++){
                suma += matriz[i][j];          
            }
            vector[j]= suma; 
        }
       
        for (j=0;j<dim;j++)
            System.out.println("Posicion " + j + ": " + vector[j]);
        
        System.out.println("Ingrese un valor entero: ");
        int num = Lector.leerInt();
        int fila = -1 , columna = -1;
        boolean esta = false;
        
        for (i=0;i<dim;i++){
            for(j=0;j<dim;j++){
                if (matriz[i][j] == num){
                    esta = true;
                    fila = i;
                    columna = j;
                }
            }
        }
        
        if (esta)
            System.out.println("El valor "+ num + " esta en la posicion " + fila + ", " + columna);
        else
            System.out.println("No se encontro el elemento.");
            
        
        
        
        
    }
}
