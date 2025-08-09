/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRACTICA3;


public class Ejercicio1 {
   public static void main(String[]args){
       Triangulo triangulo1 = new Triangulo(10.5, 10.5, 15.7, "rojo", "azul");
       System.out.println(triangulo1.toString());
       System.out.println("El area de mi triangulo es de: " + triangulo1.calcularArea());
       System.out.println("El perimetro de mi triangulo es de: " + triangulo1.calcularPerimetro());
   } 
}
