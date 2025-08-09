/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRACTICA2;

import PaqueteLectura.GeneradorAleatorio;

public class Ejercicio2 {
    public static void main(String[]args){
        GeneradorAleatorio.iniciar();
        
        int dimF = 15;
        Persona [] vector = new Persona[dimF];
        
        int dimL = 0;
        String nombre;
        int dni, edad;       
        
        edad = GeneradorAleatorio.generarInt(101);
        
        while ((dimL < dimF) && (edad != 0)) {
            nombre = GeneradorAleatorio.generarString(8);
            dni = GeneradorAleatorio.generarInt(9999);
            vector[dimL]= new Persona(nombre,dni,edad);
            dimL++;
            edad = GeneradorAleatorio.generarInt(101);
        }
        
        // IMPRIMO VECTOR, cuento personas mayores a 50 y persona con menor dni //
        int mayores = 0;
        Persona personaMenorDni = new Persona();
        int minDni = 99999;
        
        for (int i=0; i<dimL; i++){
            System.out.println("Persona " + (i+1));
            System.out.println(vector[i].toString());
           
            if (vector[i].getEdad() > 50)
                mayores+= 1;
            
            if (vector[i].getDNI() < minDni){
                minDni = vector[i].getDNI();
                personaMenorDni = vector[i];
            }
            
            System.out.println("---------");
        }
        
        System.out.println("Cantidad de personas mayores a 50 años: " + mayores);
        System.out.println("Persona con menor DNI: " + personaMenorDni.toString());
        
        
    }
}
