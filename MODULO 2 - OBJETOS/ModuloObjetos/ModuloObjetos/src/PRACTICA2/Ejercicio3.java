/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRACTICA2;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;


public class Ejercicio3 {
    
    public static void main(String[]args){
      int dias = 5;
      int turnos = 8;
      Persona [][] casting = new Persona[dias][turnos];
      
      String nombre;
      int dni, edad;
      int dia = 0;    //filas
      int turno = 0;  //columnas
  
      //nombre = GeneradorAleatorio.generarString(8);
      System.out.print("Ingrese nombre: ");
      nombre = Lector.leerString();
      
      while (( dia < dias) && (!nombre.equals("ZZZ"))){
          System.out.println("---- DIA " + (dia+1)+ " ----");
          
          while ((turno < turnos) && (!nombre.equals("ZZZ"))){
              System.out.println("// Turno " + (turno+1));
              
              dni = GeneradorAleatorio.generarInt(9999);
              edad = GeneradorAleatorio.generarInt(100)+18;
              casting[dia][turno] = new Persona(nombre, dni, edad);
              System.out.println("Persona a entrevistar el dia " + (dia+1) + " en el turno " + (turno+1) + 
                                 ": " + casting[dia][turno].getNombre());
              turno++;
              
              if (turno < turnos){
                System.out.print("Ingrese nombre: ");
                nombre = Lector.leerString();
              } else {
                System.out.println("Ya no hay mas cupos en el dia " + (dia+1));
              }  
              
          }
          //cuando sale del while turno > turnos, no hay mas cupos en ese dia.
          turno = 0;
          dia++;   
          if ((dia < dias) && (!nombre.equals("ZZZ"))){
            System.out.print("Ingrese nombre: ");
            nombre = Lector.leerString();
          } else {
              System.out.println("Ya se completaron todos los dias del casting o el nombre ingresado es ZZZ. ");
          } 
      }
      
      
        
    }
}
