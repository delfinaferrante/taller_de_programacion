/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRACTICA3;

/**
 *
 * @author Usuario
 */
public class Habitacion {
    private int costoNoche;
    private boolean estaOcupado;
    private Cliente unCliente;

    public Habitacion(Cliente unCliente, int costoNoche) {
       this.unCliente = unCliente;
       this.costoNoche = costoNoche;
       this.estaOcupado = true;
    }
    
    public Habitacion(){
        this.unCliente = null;
        this.estaOcupado = false;
    }

    public int getCostoNoche() {
        return costoNoche;
    }

    public void setCostoNoche(int costoNoche) {
        this.costoNoche = costoNoche;
    }

    public boolean isEstaOcupado() {
        return estaOcupado;
    }

    public void setEstaOcupado(boolean estaOcupado) {
        this.estaOcupado = estaOcupado;
    }

    public String getCliente(){
        return unCliente.toString();
    }
    
    @Override
    public String toString(){
        String aux;
        aux = " / Costo: $" + getCostoNoche();
        if (isEstaOcupado())
            aux += " - Ocupado por Cliente: " + getCliente();
        else
            aux += " - Libre. ";
        
      return aux;
    }
    
}
