/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRACTICA4;


public class Ejercicio4 {

    public static void main(String[] args) {
       ReporteAnual reporteanual1 = new ReporteAnual("La Plata", -57.955, -34.921, 3, 2021);
       
       for (int i=0; i<12; i++){
         for (int j=0; j<reporteanual1.getCantAños(); j++){
            reporteanual1.registrarTemperatura(i, j);
            System.out.println(reporteanual1.obtenerTemperatura(i, j) + "\n");
         }
       }
       
       reporteanual1.calcularPromedios();
       System.out.println(reporteanual1.toString());
       System.out.println(reporteanual1.mayorTemperatura());
       
       ReporteMensual reportemensual1 = new ReporteMensual("Mar Del Plata", -57.556, -38.002, 4, 2020);
       for (int i=0; i<12; i++){
         for (int j=0; j<reportemensual1.getCantAños(); j++){
            reportemensual1.registrarTemperatura(i, j);
            System.out.println(reportemensual1.obtenerTemperatura(i, j) + "\n");
         }
       }
       reportemensual1.calcularPromedios();
       System.out.println(reportemensual1.toString());
       System.out.println(reportemensual1.mayorTemperatura());

    }
    
}
