/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRACTICA3;

import PaqueteLectura.Lector;

/**
 *
 * @author Usuario
 */
public class Ejercicio5 {
    public static void main(String[]args){
        
        System.out.println("Radio: ");
        double radio = Lector.leerDouble();
        System.out.println("Color de relleno: ");
        String colorR = Lector.leerString();
        System.out.println("Color de linea: ");
        String colorL = Lector.leerString();
        Circulo unCirculo = new Circulo(radio, colorR, colorL);
        
        System.out.println("Perimetro: " + unCirculo.calcularPerimetro());
        System.out.println("Area: " + unCirculo.calcularArea());
    }
}
