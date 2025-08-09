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
public class EstadisticasAño extends Sistema{
    
    public EstadisticasAño(Carrera unaCarrera, int cantAños){
        super(unaCarrera, cantAños);
    }
    
    public int recorrerAños(int unAño){
        int cant = 0;
        int posAño = reemplazarAño(unAño);
        
        for(int j=0; j<getTrimestres(); j++){
            cant+= obtenerEgresados(posAño, j);
        }
        
    return cant;
    }
    
    public String toString(){
        int vecAños[] = new int [getCantAños()];
        for(int i=0; i<getCantAños(); i++){
            vecAños[i] = obtenerPrimerAño() + i;
        }
        
        String aux = super.toString();
        
        for(int i=0; i<getCantAños(); i++){
            aux+= "Año " + vecAños[i] + " - " + recorrerAños(vecAños[i]) + " egresados. \n";
        }
        return aux;
    }
}
