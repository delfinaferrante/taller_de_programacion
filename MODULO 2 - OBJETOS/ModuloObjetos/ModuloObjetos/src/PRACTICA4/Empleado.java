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
public abstract class Empleado {
    private String nombre;
    private double sueldo;
    private int antiguedad;
    
    Empleado(String unNombre, double unSueldo, int añosAntiguedad){
        setNombre(unNombre);
        setSueldo(unSueldo);
        setAntiguedad(añosAntiguedad);
    }
    
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String unNombre){
        nombre = unNombre;
    }

    public double getSueldo(){
        return sueldo;
    }
    public void setSueldo(double unSueldo){
        sueldo = unSueldo;
    }
    
    public int getAntiguedad(){
        return antiguedad;
    }
    public void setAntiguedad(int añoAntiguedad){
        antiguedad = añoAntiguedad;
    }
    
    public double calcularSueldoACobrar(){
        double incrementoSueldo = sueldo + ( (sueldo*0.10) * antiguedad);
        return incrementoSueldo;
    }
    
   /* public double calcularSueldoACobrar(){
        double incrementoSueldo = sueldo + ( (sueldo * 0.10) * antiguedad);      
  
        incrementoSueldo+= calcularPlusSueldo();
        return incrementoSueldo;
    }*/

    public String toString(){
      String aux = "Nombre " + getNombre() +
                   " - Efectividad del " + calcularEfectividad();
     return aux;
    }
        
    public abstract double calcularEfectividad();
    //public abstract double calcularPlusSueldo();
    
}
