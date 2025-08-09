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
public class Ejercicio3 {
    public static void main(String[]args){
    Persona unaPersona = new Persona("Delfina Ferrante", 42490681, 24);
    Trabajador unTrabajador = new Trabajador ("Encaragdo de sistemas", "Fermin Moras", 41975352, 25);
    
    System.out.println(unTrabajador.toString());
    System.out.println(unaPersona.toString());
    
    }
}
