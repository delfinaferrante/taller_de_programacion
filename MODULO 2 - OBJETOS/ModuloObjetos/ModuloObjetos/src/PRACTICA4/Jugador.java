/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRACTICA4;


public class Jugador extends Empleado{
    private int partidosJugados;
    private int goles;
    
    public Jugador(int partidos, int cantGoles, String unNombre, double unSueldo, int añosAntiguedad){
        super(unNombre, unSueldo, añosAntiguedad);
        setPartidosJugados(partidos);
        setGoles(cantGoles);
    }
    
    public int getPartidosJugados(){
        return partidosJugados;
    }
    public void setPartidosJugados(int partidos){
        partidosJugados = partidos;
    }
    public int getGoles(){
        return goles;
    }
    public void setGoles(int cantGoles){
        goles = cantGoles;
    }
    
    public double calcularEfectividad(){
        if (partidosJugados == 0){
            return 0;
        } else
        return partidosJugados/goles;
    }
    
    public double calcularPlusSueldo(){
        if (calcularEfectividad() > 0.5){
            return calcularSueldoACobrar() + getSueldo();
        } else
            return calcularSueldoACobrar();
    }
    
    public String toString(){
        String aux = super.toString() + " - Sueldo a cobrar: $" + calcularPlusSueldo();
        return aux;
    }
}
