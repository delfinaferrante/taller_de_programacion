/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRACTICA2;

import PaqueteLectura.Lector;
import PaqueteLectura.GeneradorAleatorio;

public class Ejercicio4 {
    
    public static void main(String[]args){
      int dias = 5;
      int turnos = 8;
      Persona [][] casting = new Persona[dias][turnos];
      
      String nombre;
      int dni, edad;
      
      int diaQueQuiere;   
      int cupos = 0;
        
      System.out.print("Nombre: ");
      nombre = Lector.leerString();
      
      while((cupos < 40) && (!nombre.equals("ZZZ"))){
        dni = GeneradorAleatorio.generarInt(9999);
        edad = GeneradorAleatorio.generarInt(100)+18;
        System.out.println("Dia de casting que prefiere: ");
        diaQueQuiere = Lector.leerInt();
        
        if (((diaQueQuiere-1) < dias)){   //si el dia que quiere es valido
            boolean turnoAsignado = false;
            int turno = 0;
            
            while ((turno < turnos) && (!turnoAsignado)){
                
                    if (casting[diaQueQuiere-1][turno] == null){   //si esta vacia esa posicion
                        casting[diaQueQuiere-1][turno] = new Persona(nombre, dni, edad);
                        System.out.print("Inscripcion exitosa el dia " + diaQueQuiere + " , turno " + (turno+1) + ". ");
                        turnoAsignado = true;
                        cupos++;
                    } else {
                        turno++;
                    }
            } 
            
            if (!turnoAsignado){
               System.out.println("No hay mas turnos disponibles en el dia " + diaQueQuiere);
            }
            
        } else {   //si el dia es invalido
            System.out.println("Dia inválido. Ingrese un dia entre 1 y " + dias);
        }
        
        if (cupos < 40){
            System.out.println("Nombre: ");
            nombre = Lector.leerString();
        }
      } // cierra el while principal
      
      System.out.println("Inscripciones cerradas. Cupos completos o se ingresó el nombre ZZZ.");
      int cantInscriptos; 
      
      for (int i=0; i<dias; i++){
          cantInscriptos = 0;
          System.out.println("--- DIA " + (i+1) + " ---");
          
          for (int j=0; j<turnos; j++){
              if (casting[i][j] != null){ //si hay alguna persona en ese turno
                  cantInscriptos++;
                  System.out.println("Persona a entrevistar en el turno " + (j+1) + ": " + casting[i][j].getNombre());
              } else {
                  System.out.println("No hay ninguna persona inscripta en el turno " + (j+1));
              }
          }
          
          System.out.println("Cantidad de inscriptos en el dia " + (i+1) + ": " + cantInscriptos);
      }
    }
}
