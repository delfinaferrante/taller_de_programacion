/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5_1;

/**
 *
 * @author Usuario
 */
public class Subsidios {
    private double montoPedido;
    private String motivo;
    private boolean otorgado;
    
    public Subsidios(double monto, String unMotivo){
        this.montoPedido = monto;
        this.motivo = unMotivo;
        this.otorgado = false;
    }
    
    public boolean getOtorgado(){
        return otorgado;
    }
    
    public void isOtorgado(boolean fueOtorgado){
        this.otorgado = fueOtorgado;
    }
    
    public double getMontoPedido(){
        return montoPedido;
    }
}
