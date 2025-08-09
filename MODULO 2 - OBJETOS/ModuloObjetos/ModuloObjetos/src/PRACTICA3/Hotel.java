/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRACTICA3;

import PaqueteLectura.GeneradorAleatorio;


public class Hotel {
    private int dimF;
    private Habitacion[] hotel;

    public Hotel(int cantHabitaciones) {
        GeneradorAleatorio.iniciar();
        this.dimF = cantHabitaciones;
        this.hotel = new Habitacion[dimF];
        
        for (int i=0; i<dimF; i++){
            hotel[i]= new Habitacion(); 
            hotel[i].setEstaOcupado(false);
            hotel[i].setCostoNoche(GeneradorAleatorio.generarInt(8000-2000+1)+2000);
        }
    }
    
    public Hotel(){
    }
    
    public void agregarCliente(int unaHabitacion, Cliente unCliente){
        if (hotel[unaHabitacion-1].isEstaOcupado() == false){  //si la habitacion esta desocupada
            hotel[unaHabitacion-1] = new Habitacion(unCliente, hotel[unaHabitacion-1].getCostoNoche());
            hotel[unaHabitacion-1].setEstaOcupado(true);
            System.out.println("Cliente agregado en la habitacion " + unaHabitacion);
        } else {
            System.out.println("La habitacion " + unaHabitacion + " ya esta ocupada.");
        }
    }
    
    public void aumentarPrecio(int unMonto){
        int aumento;
        for (int i=0; i<dimF; i++){
            aumento = hotel[i].getCostoNoche() + unMonto;
            hotel[i].setCostoNoche(aumento);
        }
    }
    
    @Override
    public String toString(){
        String aux = " ";
        for (int i=0; i<dimF; i++){
            aux+= " Habitacion " + (i+1) + hotel[i].toString(); 
        }
        return aux;      
    }
}
