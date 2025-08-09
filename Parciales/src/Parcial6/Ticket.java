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
public class Ticket {
    private int numTicket;
    private int dniCliente;
    private int cantLibros;
    private double monto;
    private String metodoPago;
    
    public Ticket(int numTicket, int dniCliente, int cantLibros, double monto, String metodoPago){
        setNumTicket(numTicket);
        setDniCliente(dniCliente);
        setCantLibros(cantLibros);
        setMonto(monto);
        setMetodoPago(metodoPago);
    }

    public int getNumTicket() {
        return numTicket;
    }

    public int getDniCliente() {
        return dniCliente;
    }

    public String getMetodoPago() {
        return metodoPago;
    }
    
    public void setNumTicket(int numTicket) {
        this.numTicket = numTicket;
    }

    public void setDniCliente(int dniCliente) {
        this.dniCliente = dniCliente;
    }

    public void setCantLibros(int cantLibros) {
        this.cantLibros = cantLibros;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public int getCantLibros() {
        return cantLibros;
    }

    public double getMonto() {
        return monto;
    }
    
    public String toString(){
        String aux =  getNumTicket() + ", " + getDniCliente() + ", " + getCantLibros() + " libros, monto abonado: $" 
                     + getMonto() + ", pago con " + getMetodoPago() ;
        return aux;
    }
}
