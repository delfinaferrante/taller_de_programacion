/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRACTICA4;


public class Trabajador extends Persona{
    private String tarea;
    
    public Trabajador(String unaTarea, String unNombre, int unDNI, int unaEdad){
        super(unNombre, unDNI, unaEdad);
        setTarea(unaTarea);
    }
    public Trabajador(){
        
    }
    
    public String getTarea(){
        return tarea;
    }
    public void setTarea(String unaTarea){
        tarea = unaTarea;
    }
    
    public String toString(){
        String aux = "";
        aux += super.toString() + " Soy " + getTarea() + ".";
        return aux;
    }
}
