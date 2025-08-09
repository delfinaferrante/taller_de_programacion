/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parciales;


public abstract class Empleados {
    private String nombre;
    private int dni;
    private int añosAntiguedad; 
    private double sueldoBasico;
    
    public Empleados(String unNombre, int unDni, int antiguedad, double sueldo){
        this.nombre = unNombre;
        this.dni = unDni;
        this.añosAntiguedad =  antiguedad;
        this.sueldoBasico = sueldo;
    }
    
    public double sueldoACobrar(){
        if (this.añosAntiguedad > 20){
            return (this.sueldoBasico + (this.sueldoBasico * 0.10));
        }
        return (this.sueldoBasico);
    }
    
    
    public String toString(){
        String aux = " Nombre " + this.nombre + " - DNI: " + this.dni;
        return aux;
    }
}
