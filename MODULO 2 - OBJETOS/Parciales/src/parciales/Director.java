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
public class Director extends Empleados{
    private double montoViaticos;
    
    public Director(String unNombre, int unDni, int antiguedad, double sueldo, double viaticos){
        super(unNombre, unDni, antiguedad, sueldo);
        this.montoViaticos = viaticos;
    }
    
    public double adicionalSueldo(){
        return (sueldoACobrar() + montoViaticos);
    }
    
    public String toString(){
        String aux = super.toString() + " - Sueldo a cobrar: $" + adicionalSueldo() + "\n";
        return aux;
    }
}
