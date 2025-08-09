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
public class Empresa {
    private String nombre;
    private ProgramadorLider pLider;
    private int dimL;
    private int dimF;
    private Programador[] programadores;
    
    public Empresa(String nombre, ProgramadorLider pLider, int dimF){
        setNombre(nombre);
        this.pLider = pLider;
        this.dimF = dimF;
        this.programadores = new Programador[dimF];
    }

    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public boolean hayLugar(){
        return dimL < dimF;
    }
    
    public void agregarProgramador(Programador unProgramador){
        if(hayLugar()){
            programadores[dimL] = unProgramador;
            dimL++;
        }
    }
    
    public double calcularMontoTotal(){
        double total = 0;
        for(int i=0; i<dimL; i++){
            total += programadores[i].calcularSueldoFinal();
        }
        total += pLider.calcularSueldoFinal();
        return total;
    }
    
    public void aumentarSueldoBasico(double unMonto){
        for(int i=0; i<dimL; i++){
            programadores[i].aumentarSueldo(unMonto);
        }
        pLider.aumentarSueldo(unMonto);
    }
    
    public String toString(){
        String aux = "EMPRESA " + getNombre() + "\n" + "Programador Lider: " + pLider.toString() + "\n";
        for(int i=0; i<dimL; i++){
            aux+= "Programador " + (i+1) + ": " + programadores[i].toString() + "\n";
        }
        aux += "Monto total a abonar por la empresa: $" + calcularMontoTotal();
        return aux;
    }

}
