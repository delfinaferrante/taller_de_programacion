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
public class Encargado extends Empleados{
    private int empleadosACargo; 
    
    public Encargado(String unNombre, int unDni, int antiguedad, double sueldo, int cantEmpleados){
        super(unNombre, unDni, antiguedad, sueldo);
        this.empleadosACargo = cantEmpleados;
    }
    
    public double adicionalSueldo(){
        return (sueldoACobrar() + (1000 * empleadosACargo)); 
    }
    public String toString(){
      String aux = super.toString() + " - Sueldo a cobrar: $" + adicionalSueldo();
      return aux; 
    }
}
