/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parciales;


public class Torneo {
    private String nombre;
    private int fechas;                 //filas
    private int cantGoleadores;         //columnas
    private int[] goleadoresPorFecha;   //dimension logica, guarda cant goleadores por fecha
    private Goleador[][] goleadores;
    
    public Torneo(String nombre, int cantFechas, int cantGoleadores){
        this.nombre = nombre;
        this.fechas = cantFechas;
        this.cantGoleadores = cantGoleadores;
        this.goleadores = new Goleador[fechas][cantGoleadores];
        this.goleadoresPorFecha = new int[fechas];
        
        for (int i=0; i<fechas; i++){
            goleadoresPorFecha[i]= 0;
        }
    }
    
    public void agregarGoleador(int unaFecha, Goleador unGoleador){
        goleadores[unaFecha-1][goleadoresPorFecha[unaFecha-1]] = unGoleador;
        goleadoresPorFecha[unaFecha-1]+= 1;
    }
    
    public Goleador goleadorConMenosGoles(int unaFecha){
        Goleador menosGoles = null;   
        
        if (goleadoresPorFecha[unaFecha-1] != 0){
           menosGoles = goleadores[unaFecha-1][0];  //inicializo con el primer goleador

           for (int i=0; i < goleadoresPorFecha[unaFecha-1]; i++){
                if (goleadores[unaFecha-1][i].getCantGoles() < menosGoles.getCantGoles()){
                    menosGoles = goleadores[unaFecha-1][i];
                }
            }
           
       } else
           System.out.println("No hay ningun goleador en la fecha " + unaFecha);

        return menosGoles;
    }
    
    public int cantGoleadoresEnElTorneo(){
        int cant = 0;
        for (int i=0; i<fechas; i++)
            cant+= goleadoresPorFecha[i];
        
        return cant;
    }
    
    public String toString(){
        String aux = "TORNEO 2022: " + nombre + "\n";
        for (int i=0; i<fechas; i++){
            aux+= "Fecha #" + (i+1) + " | Cantidad de goleadores de la fecha: " + goleadoresPorFecha[i];
            
            if (goleadoresPorFecha[i] != 0)
                aux+= " | Goleadores: ";
            
            for (int j=0; j<cantGoleadores; j++){
                    if (goleadores[i][j] != null)
                        aux += goleadores[i][j].toString();                   
            }
        }
        return aux;
        }
     
    
    
}
