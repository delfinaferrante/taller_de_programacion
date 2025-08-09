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
public class Parcial2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ProgramadorLider lider = new ProgramadorLider("Fermin Moras", 41567432, 275.5, 230, "PHP", 3, 2);
        Empresa e = new Empresa("INFORMATICA", lider, 6);
        
        Programador p1 = new Programador("Juan Sanchez", 34657183, 150.6, 100, "C++");
        Programador p2 = new Programador("Lucia Romero", 45769124, 350.2, 290, "SQL");
        Programador p3 = new Programador("Pedro Zolezzi", 39542579, 400.5, 300, "JavaScript");
        Programador p4 = new Programador("Damian Betular", 19345965, 125.7, 50, "Pascal");
        
        e.agregarProgramador(p1);
        e.agregarProgramador(p2);
        e.agregarProgramador(p3);
        e.agregarProgramador(p4);
        
        System.out.println(e.toString());
        e.aumentarSueldoBasico(300);
        System.out.println(e.toString());
    }
    
}
