/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial9;

/**
 *
 * @author fer_m
 */
public class Pan extends Comun{
    private String calidad; //premium o normal
    
    public Pan(String nombre, double monto, String calidad){
        super(nombre, monto);
        setCalidad(calidad);
    }

    public void setCalidad(String calidad) {
        this.calidad = calidad;
    }

    public String getCalidad() {
        return calidad;
    }
    
    public double costoFinal(){
        if(getCalidad().equals("premium")){
            setCosto(getCosto() * 1.20);
        }
      return getCosto();
    }
    
    public String toString(){
        String aux = "PAN: " + super.toString() + getCalidad() + "\n";
        return aux;
    }
}
