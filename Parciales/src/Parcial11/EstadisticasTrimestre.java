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
public class EstadisticasTrimestre extends Sistema{
    
    public EstadisticasTrimestre(Carrera unaCarrera, int cantAños){
        super(unaCarrera, cantAños);
    }
    
    public int recorrerTrimestres(int unTrimestre){
        int cant = 0;
        for(int j=0; j<getCantAños(); j++){
            cant += obtenerEgresados(j,unTrimestre);
        }
        return cant;
    }
    
    public String toString(){
        String aux = super.toString();
        
        for(int i=0; i<getTrimestres();i++){
            aux+= "Trimestre " + (i+1) + ": " + recorrerTrimestres(i) + " egresados. \n";
        }
        
        return aux;
    }
}
