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
public class Entrenador extends Empleado {
    private int campeonatos;
    
   public Entrenador(int campeonatosGanados, String unNombre, double unSueldo, int añosAntiguedad){
       super(unNombre, unSueldo, añosAntiguedad);
       setCampeonatos(campeonatosGanados);
   }
   
   public int getCampeonatos(){
       return campeonatos;
   }
   public void setCampeonatos(int campeonatosGanados){
       campeonatos = campeonatosGanados;
   }
   
    public double calcularEfectividad(){
        return campeonatos/super.getAntiguedad();
    }
    public double calcularPlusSueldo(){
        if ( (campeonatos >= 1) && (campeonatos <= 4)){
            return calcularSueldoACobrar() + 5000;
        }  else if ( (campeonatos >= 5) && (campeonatos <= 10)){
            return calcularSueldoACobrar() + 30000;
        } else if ((campeonatos > 10)){
            return calcularSueldoACobrar() + 50000;
        } 
          return calcularSueldoACobrar();
    }
    
    public String toString(){
        String aux = super.toString() + " - Sueldo a cobrar: $" + calcularPlusSueldo();
        return aux;
    }
}

