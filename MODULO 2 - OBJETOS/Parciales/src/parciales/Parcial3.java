/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parciales;

/**
 *
 * @author Usuario
 */
public class Parcial3 {
    public static void main(String[]args){
        Torneo unTorneo = new Torneo("Liga Universitaria del Interior", 6, 6);
       
        Goleador g1 = new Goleador("Lucila Fernandez", "CarlosCa", 4);
        Goleador g2 = new Goleador("Delfina Ferrante", "CarlosCa", 2);
        Goleador g3 = new Goleador("Jimena Lucero", "Gonnet", 1);
        Goleador g4 = new Goleador("Constanza Gomez", "Quilmes", 6);
        Goleador g5 = new Goleador("Agustina Soto", "Lincoln", 10);
        
        unTorneo.agregarGoleador(1, g1);
        unTorneo.agregarGoleador(3, g2);
        unTorneo.agregarGoleador(2, g3);
        unTorneo.agregarGoleador(4, g4);
        unTorneo.agregarGoleador(1, g5);
        
        System.out.println("Cantidad de goleadores en el torneo: " + unTorneo.cantGoleadoresEnElTorneo());
        System.out.println("Goleador con menos goles: " + unTorneo.goleadorConMenosGoles(1));
        System.out.println(unTorneo.toString());
    }
}
