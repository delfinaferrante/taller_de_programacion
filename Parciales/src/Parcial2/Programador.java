/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial2;

/**
 *
 * @author Delfi
 */
public class Programador {
    private String nombre;
    private int dni;
    private double sueldo;
    private int cantLineas;
    private String lenguajeFav;
    
    public Programador(String nombre, int dni, double sueldo, int cantLineas, String lenguajeFav){
        setNombre(nombre);
        setDni(dni);
        setSueldo(sueldo);
        setCantLineas(cantLineas);
        setLenguajeFav(lenguajeFav);     
    }

    public String getNombre() {
        return nombre;
    }

    public int getDni() {
        return dni;
    }

    public String getLenguajeFav() {
        return lenguajeFav;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public double getSueldo() {
        return sueldo;
    }
    
    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public int getCantLineas() {
        return cantLineas;
    }
    
    public void setCantLineas(int cantLineas) {
        this.cantLineas = cantLineas;
    }

    public void setLenguajeFav(String lenguajeFav) {
        this.lenguajeFav = lenguajeFav;
    }
    
    public double calcularSueldoFinal(){
        double sueldoActualizado = 0;
        if(getCantLineas() > 200){
            sueldoActualizado = getSueldo()+5000;
            setSueldo(sueldoActualizado);
        }
        return getSueldo();
    }
    
    public void aumentarSueldo(double unMonto){
        double aumento = getSueldo() + unMonto;
        setSueldo(aumento);
    }
    
    public String toString(){
        String aux = "{ " + getNombre() + ", " +  getDni() + ", " + getLenguajeFav() + ", sueldo final: $" + calcularSueldoFinal() + " }";
        return aux;
    }
}
