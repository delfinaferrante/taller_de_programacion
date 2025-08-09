/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial5;

/**
 *
 * @author Delfi
 */
public class Parcial5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Concurso c = new Concurso(3, 5);
        
        Canciones c1 = new Canciones("Hechizao", "Silvestre y la naranja", 23); 
        Canciones c2 = new Canciones("Altar", "Luz Gaggi", 60);
        Canciones c3 = new Canciones("Imperio", "Duki y Judeline", 120);
        Canciones c4 = new Canciones("Como eran las cosas", "Babasonicos", 5);
        Canciones c5 = new Canciones("No love", "Anuel", 700);
        
        c.agregarCancion(c1, 1);
        c.agregarCancion(c2, 2);
        c.agregarCancion(c3, 3);
        c.agregarCancion(c4, 2);
        c.agregarCancion(c5, 1);
       
        c.buscarGanador(120);
    }
    
}
