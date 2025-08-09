/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5ej3;


public class Fecha {
   private String ciudad;
   private String dia;
   
   Fecha(String unaCiudad, String unDia){
       ciudad = unaCiudad;
       dia = unDia;
   }
   
   public String getCiudad(){
       return ciudad;
   }
}

