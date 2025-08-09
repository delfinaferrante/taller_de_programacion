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
public class Parcial1 {


    public static void main(String[] args) {
        Director director = new Director("Delfina Ferrante", 42490681, 15, 5679.4, 1530.40);
        Empresa empresa = new Empresa("Arcor", "Uruguay 172, Buenos Aires", director, 8);
        
        Encargado enc1 = new Encargado("Olga Gallo", 37912771, 5, 1467.4, 3);
        Encargado enc2 = new Encargado("Ana Garcia", 1267845, 10, 5584.2, 6);
        Encargado enc3 = new Encargado("Carlos Fernandez", 27916453, 11, 1290.5, 15);
        Encargado enc4 = new Encargado("Maria Laura Ferrari", 29047877, 8, 8065.7, 5);
        
        empresa.asignarEncargado(1, enc1);
        empresa.asignarEncargado(5, enc2);
        empresa.asignarEncargado(2, enc3);
        empresa.asignarEncargado(7, enc4);
        
        System.out.println(empresa.toString());

    }
    
}
