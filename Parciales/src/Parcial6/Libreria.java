/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial6;

/**
 *
 * @author fer_m
 */
public class Libreria {
    private String nombre;
    private int numVentaAct;
    private int maxCajas = 4;          
    private Caja[]cajas;
    
    public Libreria(String nombre, int maxTickets){
        setNombre(nombre);
        this.cajas = new Caja[maxCajas];
        this.numVentaAct = 0;
        
        for(int i=0; i<maxCajas; i++){
            Caja c = new Caja(maxTickets);
            cajas[i] = c;
        }
    }

    public String getNombre() {
        return nombre;
    }
    
    public void setNumVentaAct(int numVentaAct) {
        this.numVentaAct = numVentaAct;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public boolean cajaValida(int numCaja){
        return (numCaja-1)<maxCajas;
    }
    
    public void agregarTicket(int numCaja, int dni, int cantLibros, double monto, String metodo){
        if((numCaja-1) < maxCajas){
            setNumVentaAct(numVentaAct+1);
            cajas[numCaja-1].generarTicket(numVentaAct, dni, cantLibros, monto, metodo);
            numVentaAct++;
        } else
            System.out.println("Numero de caja inválido.");
    }
    
    public void marcarNoDisponible(int valor){
        for(int i=0;i<maxCajas;i++){
            cajas[i].compararLibros(valor);
        }
    }
    
    public Ticket buscarTicketMax(){
        Ticket aux = null;
        Ticket ticketMax = null;
        double max = -1;
        for(int i=0; i<maxCajas; i++){
            if(cajas[i] != null){
                aux = cajas[i].obtenerTicketMax();
                if (aux.getMonto() > max){
                    max = aux.getMonto();
                    ticketMax = aux;
                }
            }
        }
     return ticketMax;
    }
    
    public String toString(){
        String aux = "LIBRERIA " + getNombre() + "\n";
        for(int i=0; i<maxCajas; i++){
            aux += "CAJA " + (i+1) + ": " + cajas[i].toString() + "\n";
        }
      return aux;
    }
}
