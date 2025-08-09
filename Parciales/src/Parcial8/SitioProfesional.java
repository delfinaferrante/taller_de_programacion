/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial8;

/**
 *
 * @author fer_m
 */
public class SitioProfesional extends SitioWeb{
    private int maxTorneos;
    private int dimL;
    private Torneo [] torneos;
    
    public SitioProfesional(String nombre, String direccion, int maxTorneos){
        super(nombre, direccion);
        this.maxTorneos = maxTorneos;
        this.dimL = 0;
        this.torneos = new Torneo[maxTorneos];
    }
    
    public boolean registrarTorneo(Torneo unTorneo){
       if(dimL < maxTorneos){
           torneos[dimL] = unTorneo;
           return true;
       } else
           return false;
    }
    
    public double cotizarSitio(){
        double cotizacion = 0;
        double recaudacion = 0;
        for(int i=0; i<dimL; i++){
            recaudacion = torneos[i].getMontoInscripciones() - torneos[i].getMontoPremios();
            cotizacion += 1000 + recaudacion;
        }
        return cotizacion;
    }
}
