/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRACTICA2;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;


public class Ejercicio5 {
    public static void main(String[]args){
        int dimF = 20;
        int dimL = 0;
        Partido[] campeonato = new Partido[dimF];
        
        String local;
        int golesL, golesV;
        
        System.out.println("Equipo visitante: ");
        String visitante = Lector.leerString();
       
        while (!visitante.equals("ZZZ") && (dimL < dimF)){
            System.out.println("Equipo local: ");
            local = Lector.leerString();
            golesL = GeneradorAleatorio.generarInt(8);
            golesV = GeneradorAleatorio.generarInt(8);
            campeonato[dimL]= new Partido(local, visitante, golesL, golesV);
           
            System.out.println("Equipo visitante: ");
            visitante = Lector.leerString();
            dimL++;
        }
        int cantPartidosRiver = 0;
        int totalGolesBoca = 0;
        
        for (int i=0; i<dimL; i++){
            System.out.println(campeonato[i].toString());
                if (campeonato[i].getGanador().equals("river")){
                   cantPartidosRiver++; 
                }
                if (campeonato[i].getLocal().equals("boca")){
                    totalGolesBoca += campeonato[i].getGolesLocal();
                }
        }
        System.out.println("River gano " + cantPartidosRiver + " partidos.");
        System.out.println("En total, boca hizo " + totalGolesBoca + " goles jugando de local. ");
    }
}
