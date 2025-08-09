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
public class SitioAmateur extends SitioWeb{
    private int cantTorneos;
    private int cantClicks;
    
    public SitioAmateur(String nombre, String direccion){
        super(nombre, direccion);
        setCantTorneos(0);
        setCantClicks(0);
    }

    public void setCantTorneos(int cantTorneos) {
        this.cantTorneos = cantTorneos;
    }

    public void setCantClicks(int cantClicks) {
        this.cantClicks = cantClicks;
    }

    public int getCantTorneos() {
        return cantTorneos;
    }

    public int getCantClicks() {
        return cantClicks;
    }
     
    public double cotizarSitio(){
        double cotizacion = 0;
        cotizacion = (getCantClicks()*10) + (getCantUsuarios()*50);
        return cotizacion;
    }
    
    public void registrarTorneoAmateur(int clicks){
        setCantClicks(getCantClicks()+clicks);
        setCantTorneos(getCantTorneos()+1);
    }
}
