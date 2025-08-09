/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial11;

/**
 *
 * @author fer_m
 */
public class Parcial11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Carrera carrera1 = new Carrera("Licenciatura en Informatica", "Facultad de Informatica", 2010);
        Carrera carrera2 = new Carrera("Licenciatura en Diseño Multimedial", "Facultad de Artes", 2000);
        
        EstadisticasAño ea = new EstadisticasAño(carrera1, 3);
        EstadisticasTrimestre et = new EstadisticasTrimestre(carrera2, 2);
        
        ea.registrarEgresados(10, 2010, 1);
        ea.registrarEgresados(26, 2012, 2);
        ea.registrarEgresados(5, 2012, 1);
        
        et.registrarEgresados(54, 2002, 1);
        et.registrarEgresados(224, 2001, 2);
        et.registrarEgresados(5, 2003, 3);
        et.registrarEgresados(14, 2003, 3);
        
        System.out.println(ea.toString());
        System.out.println(et.toString());
    }
    
}
