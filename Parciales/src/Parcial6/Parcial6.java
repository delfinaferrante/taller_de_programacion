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
public class Parcial6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Libreria l = new Libreria("Leete Esta", 10);
        
        l.agregarTicket(1, 2456, 8, 100000, "Credito");
        l.agregarTicket(1, 567, 8, 80000, "Efectivo");
        l.agregarTicket(1, 4673, 8, 70000, "Debito");
        l.agregarTicket(2, 9745, 1, 200000, "Debito");
        l.agregarTicket(3, 7984, 1, 70000, "Efectivo");
        l.agregarTicket(4, 3225, 1, 20000, "Credito");
        
        
        System.out.println("El ticket con mayor monto fue:");
        System.out.println(l.buscarTicketMax());
        System.out.println("");
        
        l.marcarNoDisponible(5);
        
        System.out.println(l.toString());
    }
    
}
