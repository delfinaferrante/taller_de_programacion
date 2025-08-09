/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5_1;

/**
 *
 * @author Usuario
 */
public class Practica5_1 {

    public static void main(String[] args) {
        Proyecto proyecto = new Proyecto("Taller de Programacion", 45, "Laura Giusti");
        
        Investigadores inv1 = new Investigadores("Delfina Ferrante", 1, "Análisis de datos");
        Investigadores inv2 = new Investigadores("Fermin Moras", 3, "Estadísticas");
        Investigadores inv3 = new Investigadores("Olga Gallo", 2, "Modelado y maquetado");
        
        proyecto.agregarInvestigador(inv1);
        proyecto.agregarInvestigador(inv2);
        proyecto.agregarInvestigador(inv3);
        
        Subsidios sub1 = new Subsidios(546.5, "solventar gastos");
        Subsidios sub2 = new Subsidios(1195.4, "mejorar recursos");
        Subsidios sub3 = new Subsidios(2743.7, "actualizacion de software");
        Subsidios sub4 = new Subsidios(250.7, "propiedad privada");
        Subsidios sub5 = new Subsidios(7640.7, "desconocido");
        Subsidios sub6 = new Subsidios(853.7, "no aclara");


        inv1.agregarSubsidio(sub1);
        inv1.agregarSubsidio(sub2);

        inv2.agregarSubsidio(sub3);
        inv2.agregarSubsidio(sub4);

        inv3.agregarSubsidio(sub5);
        inv3.agregarSubsidio(sub6);

        sub3.isOtorgado(true);
        sub4.isOtorgado(true);
        sub1.isOtorgado(true);
        /*inv2.otorgarSubsidio();
        inv2.otorgarSubsidio();*/

        System.out.println(proyecto.toString());
        
    }
    
}
