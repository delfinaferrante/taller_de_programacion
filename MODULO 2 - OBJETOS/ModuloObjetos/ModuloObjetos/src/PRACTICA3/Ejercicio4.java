/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRACTICA3;

/**
 *
 * @author alumnos
 */
public class Ejercicio4 {
	public static void main(String[] args) {
	   Hotel unHotel = new Hotel(5);	
           
           Cliente cliente1 = new Cliente("Delfina Ferrante", 42490681, 24);
           unHotel.agregarCliente(1, cliente1);
           
           Cliente cliente2 = new Cliente("Fermin Moras", 41986823, 25);
           unHotel.agregarCliente(3, cliente2);
           
           Cliente cliente3 = new Cliente("Gustavo Gomez", 29074434, 45);
           unHotel.agregarCliente(3, cliente3);
           
           Cliente cliente4 = new Cliente("Maria Laura Lopez", 37912771, 31);
           unHotel.agregarCliente(2, cliente4);
           
           System.out.println(unHotel.toString());
	}
}
