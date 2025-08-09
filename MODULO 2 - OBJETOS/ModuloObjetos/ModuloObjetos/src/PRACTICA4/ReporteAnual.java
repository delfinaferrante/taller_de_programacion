/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRACTICA4;


public class ReporteAnual extends Sistema{
    private double [] promediosAnuales;
    
    public ReporteAnual(String nombreEstacion, double suLongitud, double suLatitud,
                        int cantAños, int añoInicial){
    super(nombreEstacion, suLongitud, suLatitud, cantAños, añoInicial);
    promediosAnuales = new double[super.getCantAños()]; //vector de tantas posiciones como años hay
        
    }
    
    public void calcularPromedios(){
        double sumaTemp;
        for (int j=0; j<super.getCantAños(); j++){
            sumaTemp = 0;
            for (int i=0; i<12; i++){
                sumaTemp+= super.obtenerTemperatura(i, j);
            }
            promediosAnuales[j] = (sumaTemp/12);
        }
    }
    
    public String toString(){
        String aux = super.toString();
        for (int i=0; i<getCantAños(); i++){
            aux+= "Año " + (super.getAñoInicial()+i) + ": " + promediosAnuales[i] + " °C ; \n";
        }
                
        return aux;
    }
}
