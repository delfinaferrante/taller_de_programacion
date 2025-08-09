/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5ej2;

/**
 *
 * @author alumnos
 */
public class Practica5Ej2 {

    public static void main(String[] args) {
        Estacionamiento unEstacionamiento = new Estacionamiento("Avenida 13", "13 1532", "09:30", "22:00", 3, 3);
        Auto auto1 = new Auto("Delfina Ferrante", "PAM65H");
        Auto auto2 = new Auto("Fermin Moras", "IU8JTD");
        Auto auto3 = new Auto("Carlos Gomez", "KHI423");
        Auto auto4 = new Auto("Ana Garcia", "ASUT74");
        Auto auto5 = new Auto("Catalina Nuevo", "MYTRD44");
        Auto auto6 = new Auto("Lucila Fernandez", "OPU763");
        
        unEstacionamiento.registrarAuto(auto1, 0, 0);
        unEstacionamiento.registrarAuto(auto2, 1, 0);
        unEstacionamiento.registrarAuto(auto3, 1, 1);
        unEstacionamiento.registrarAuto(auto4, 2, 0);
        unEstacionamiento.registrarAuto(auto5, 0, 2);
        unEstacionamiento.registrarAuto(auto6, 2, 2);
        
        System.out.println(unEstacionamiento.toString());
        System.out.println(unEstacionamiento.buscarAuto("OPU763"));
    }
}   