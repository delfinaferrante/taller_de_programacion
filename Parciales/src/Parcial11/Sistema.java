/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial11;

/**
 *
 * @author fer_m
 */
public abstract class Sistema {
    private Carrera unaCarrera;
    private int trimestres;         //filas
    private int cantAños;           //columnas
    private int [][] egresados;
    
    public Sistema(Carrera unaCarrera, int cantAños){
        this.unaCarrera = unaCarrera;
        this.cantAños = cantAños;
        this.trimestres = 4;
        this.egresados = new int [trimestres][cantAños];
        
        for(int t=0; t<trimestres;t++){
            for(int a=0; a<cantAños; a++){
                egresados[t][a] = 0;
            }
        }
    }
    
    public boolean añoValido(int posAño){
        return posAño < cantAños;
    }
    
    public int getCantAños(){
        return cantAños;
    }
    
    public int getTrimestres(){
        return trimestres;
    }
    
    public boolean trimestreValido(int unTrimestre){
        return unTrimestre < trimestres;
    }
    
    public int reemplazarAño(int unAño){
       return (unAño - unaCarrera.getAñoCreacion());
    }
    
    public void registrarEgresados(int cantEgresados, int unAño, int unTrimestre){
        int posAño = reemplazarAño(unAño);
        if((añoValido(posAño)&&(trimestreValido(unTrimestre)))) {
            egresados[unTrimestre-1][posAño] = cantEgresados;
        }
    }
    
    public int obtenerEgresados(int unAño, int unTrimestre){
        return egresados[unTrimestre][unAño];
    }
    
    public int encontrarCantidadEgresados(int X){
        int cant = 0;
        for(int t=0; t<trimestres; t++){
            for(int a=0; a<cantAños; a++){
                if(egresados[t][a] == X){
                    cant++;
                }
            }
        }
      return cant;
    }
    
    public int obtenerPrimerAño(){
        return unaCarrera.getAñoCreacion();
    }
    
    public String toString(){
        String aux = unaCarrera.toString();
        return aux;
    }
    
}
