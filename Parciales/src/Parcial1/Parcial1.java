/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial1;

/**
 *
 * @author Delfi
 */
public class Parcial1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MembresiaVip mv = new MembresiaVip("VIP", "4/10/2022", 5, 5500.5);
        MembresiaProfesional mp = new MembresiaProfesional("PROFESIONAL", "22/04/2024", 4);
        
        Jugador j1 = new Jugador("Delfina Ferrante");
        mv.agregarJugador(j1);
        Jugador j2 = new Jugador("Delfina Lopez");
        mv.agregarJugador(j2);
        Jugador j3 = new Jugador("Delfina Menendez");
        mv.agregarJugador(j3);
        
        Jugador j11 = new Jugador("Fermin Moras");
        mp.agregarJugador(j11);
        Jugador j22 = new Jugador("Fermin Rosales");
        mp.agregarJugador(j22);
        Jugador j33 = new Jugador("Fermin Fernandez");
        mp.agregarJugador(j33);
        Jugador j44 = new Jugador("Fermin Garcia");
        mp.agregarJugador(j44);
        
        mv.aumentarPuntos(10, "Delfina Lopez");
        System.out.println(mv.toString());
        System.out.println(mp.obtenerJugador(2));
        System.out.println(mp.toString());
    }
    
}
