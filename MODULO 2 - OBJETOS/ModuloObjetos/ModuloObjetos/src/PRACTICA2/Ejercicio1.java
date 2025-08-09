/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRACTICA2;

import PaqueteLectura.Lector;

public class Ejercicio1 {
    
    public static void main(String[]args){
        System.out.print("Nombre: ");
        String nombre = Lector.leerString();
        
        System.out.print("Dni: ");
        int dni = Lector.leerInt();
        
        System.out.print("Edad: ");
        int edad = Lector.leerInt();
        
        Persona persona = new Persona(nombre, dni, edad);
        System.out.print(persona.toString());
    }
    
    
}
