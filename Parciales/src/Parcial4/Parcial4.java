/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial4;

/**
 *
 * @author Delfi
 */
public class Parcial4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Estadio est = new Estadio("Movistar Arena", "Buenos Aires", 5500);
        
        Concierto c1 = new Concierto("No Te Va Gustar", 14600, 20);
        Concierto c2 = new Concierto("Lali", 1500, 40);
        Concierto c3 = new Concierto("Callejeros", 4500, 36);
        Concierto c4 = new Concierto("Los Piojos", 8965, 78);
        
        est.registrarConcierto(c1, 1);
        est.registrarConcierto(c2, 1);
        est.registrarConcierto(c3, 2);
        est.registrarConcierto(c4, 6);
        est.registrarConcierto(c4, 6);
        est.registrarConcierto(c4, 6);
        
        System.out.println(est.toString());
        System.out.println("Ganancias obtenidas: $" + est.obtenerGanancias(1));
    }
    
}
