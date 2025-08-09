/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRACTICA4;


public class ReporteMensual extends Sistema{
    private double [] promediosMensuales;

    
    public ReporteMensual(String nombreEstacion, double suLongitud, double suLatitud,
                          int cantAños, int añoInicial){
    super(nombreEstacion, suLongitud, suLatitud, cantAños, añoInicial);    
    promediosMensuales = new double[12];                   
        
    }
    
    public void calcularPromedios(){
        double sumaTemp;
        for (int i=0; i<12; i++){
            sumaTemp = 0;
            for(int j=0; j<super.getCantAños(); j++){
                sumaTemp+= super.obtenerTemperatura(i, j);
            }
            promediosMensuales[i] = (sumaTemp/super.getCantAños());
        }
    }
    
    public String toString(){
        String aux = super.toString();
        
        String[] nombreMeses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo",
                                "Junio", "Julio", "Agosto", "Septiembre", "Octubre",
                                "Noviembre", "Diciembre"};
        for (int i=0; i<12; i++){
            aux+= nombreMeses[i] + ": " + promediosMensuales[i] + " °C ; \n";
        }
                
    return aux;
    }
}
