/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRACTICA4;

/**
 *
 * @author Usuario
 */
public class Ejercicio1 {
    public static void main(String[]args){
        Triangulo trian = new Triangulo(10.5, 10.5, 13.5, "azul", "amarillo");
        Circulo circ = new Circulo(13.5, "Rosa", "Dorado");
        
        System.out.println(trian.toString());
        System.out.println(circ.toString());
        
        circ.despintar();
        System.out.println(circ.toString());

    }
}
