/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRACTICA4;

import PaqueteLectura.GeneradorAleatorio;


public abstract class Sistema extends Estacion{
    private double [][] temperaturas;
    private int meses = 12;
    private int añoInicial;
    private int añoFinal;
    private int cantAños;
    
    public Sistema(String nombreEstacion, double suLongitud, double suLatitud,
                    int cantAños, int añoInicial){
    super(nombreEstacion, suLongitud, suLatitud);
    this.añoInicial = añoInicial;
    this.cantAños = cantAños;
    this.añoFinal = añoInicial + (cantAños-1);      //saca el año final de la matriz
    temperaturas = new double [meses][cantAños];
    
    for (int i=0; i<meses; i++){
        for (int j=0; j<cantAños; j++)
            temperaturas[i][j] = 9999;  //inicializo todas las temperaturas en un valor alto
    }
    }
    
    public int getCantAños(){
        return cantAños;
    }
    public int getAñoInicial(){
        return añoInicial;
    }
    
    public void registrarTemperatura(int unMes, int unAño){
        GeneradorAleatorio.iniciar();
        /*if ( (unMes > 1) && (unMes < 12)){
            if ( (unAño > añoInicial) && (unAño < añoFinal))*/
        
         if ( ((unMes+1) >= 1) && ((unMes+1) <= 12)){
            if ( ((unAño+añoInicial) >= añoInicial) && ((unAño+añoInicial) <= añoFinal))
                temperaturas[unMes][unAño] = GeneradorAleatorio.generarDouble(40-5+1)+5; //random de 5 a 40°
        }
    }
    
    public double obtenerTemperatura(int unMes, int unAño){
       /*if ( (unMes > 1) && (unMes < 12)){
            if ( (unAño > añoInicial) && (unAño < añoFinal))*/
       
        if ( ((unMes+1) >= 1) && ((unMes+1) <= 12)){
            if ( ((unAño+añoInicial) >= añoInicial) && ((unAño+añoInicial) <= añoFinal))
                return temperaturas[unMes][unAño];
        } 
        return 9999;     
    }
    
    public String mayorTemperatura(){
        double tempMax = 0;
        int mesMax = -1;
        int añoMax = -1;
        for (int i=0; i<meses; i++){
            for (int j=0; j<cantAños; j++){
                if (temperaturas[i][j] > tempMax){
                    mesMax = i;
                    añoMax = j;
                    tempMax = temperaturas[i][j];
                }
            }
        }
        int añoConvertido = añoInicial + añoMax;
        return "La temperatura maxima fue de " + tempMax + "°C en la fecha " + (mesMax+1) + "/" + añoConvertido;
    } 
    
    public abstract void calcularPromedios();
    
}
