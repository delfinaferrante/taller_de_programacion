/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parciales;

/**
 *
 * @author Usuario
 */
public class Parcial2 {
    public static void main(String[]args){
        Sistema sistema = new Sistema();
        Paciente p1 = new Paciente("Fermin Moras", true);
        Paciente p2 = new Paciente("Delfina Ferrante", false);
        Paciente p3 = new Paciente("Juan Segobia", false);
        Paciente p4 = new Paciente("Karina Lopez", false); 
        Paciente p5 = new Paciente("Micaela Lobos", true);
        
        sistema.agendarPaciente(p1, 1, 1);
        sistema.agendarPaciente(p2, 1, 3);
        sistema.agendarPaciente(p3, 3, 2);
        sistema.agendarPaciente(p4, 4, 1);
        sistema.agendarPaciente(p5, 3, 5);
        
        
        System.out.println(sistema.liberarTurnos(3));
    }
}
