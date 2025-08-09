/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial7;

/**
 *
 * @author fer_m
 */
public class Parcial7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Plataforma p = new Plataforma("LUZU", 7893, 5);
        Estreno e1 = new Estreno("Patria y Familia", "serie", 550, 1369);
        Estreno e2 = new Estreno("Nadie Dice Nada", "pelicula", 156, 500);
        Estreno e3 = new Estreno("Pachu Streaming", "serie", 6588, 200);
        Estreno e4 = new Estreno("Antes Que Nadie", "pelicula", 215, 319);
        Estreno e5 = new Estreno("Tarde de Tertulia", "pelicula", 3333, 547);
        
        p.registrarEstreno(e1, 2);
        p.registrarEstreno(e2, 1);
        p.registrarEstreno(e3, 2);
        p.registrarEstreno(e4, 3);
        p.registrarEstreno(e5, 4);
        
        //System.out.println(p.imprimirEstrenos(2));
        System.out.println("Recaudacion en series: $" + p.calcularGananciaSeries());
        System.out.println(p.toString());
    }
    
}
