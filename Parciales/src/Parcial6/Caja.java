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
public class Caja {
    private boolean disponible;
    private int maxTickets;
    public int dimL;
    private Ticket[]tickets;
    
    public Caja(int maxTickets){
        this.maxTickets = maxTickets;
        this.tickets = new Ticket[maxTickets];
        isDisponible(true);
        this.dimL = 0;
    }
    
    public Caja(){        
    }
    
    public void isDisponible(boolean estado){
        this.disponible = estado;
    }
    
    public boolean estaDisponible(){
        return disponible;
    }
    
    public void generarTicket(int numVenta, int dni, int cantLibros, double monto, String metodo){
        if(dimL < maxTickets){
            tickets[dimL] = new Ticket(numVenta,dni,cantLibros,monto,metodo);
            dimL++;
        }
    }
    
    public void compararLibros(int valor){
        for(int i=0; i<dimL; i++){
            if (tickets[i].getCantLibros() < valor){
                isDisponible(false);
            }
        }
    }
    
    public Ticket obtenerTicketMax(){
        double max = -1;
        Ticket aux = null;
        for(int i=0; i<dimL; i++){
          if(tickets[i].getMonto() > max){
              max = tickets[i].getMonto();
              aux = tickets[i];
          }  
        }
        return aux;
    }
    
    public String toString(){
        String aux = " ";
        if(estaDisponible()){
            aux += "Esta disponible; ";
        }else
            aux += "No esta disponible; ";
        
        aux+= "Tickets emitidos: ";
        for(int i=0; i<dimL; i++){
            aux+= "[" + tickets[i].toString() + "] ";
        }
     return aux;
    }
}
