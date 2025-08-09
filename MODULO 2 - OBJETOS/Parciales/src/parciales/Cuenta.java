/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parciales;

/**
 *
 * @author Usuario
 */
public class Cuenta {
    private int cbu;
    private String alias;
    private int dniTitular;
    private String moneda;
    private double monto;
    
    public Cuenta(int cbu, String alias, String moneda){
        this.cbu = cbu;
        this.alias = alias;
        this.moneda = moneda;
        this.monto = 0;
    }
    public String getMoneda(){
        return moneda;
    }
    public int getCbu(){
        return cbu;
    }
    public double getMonto(){
        return monto;
    }
    public void incrementarMonto(double unMonto){
        monto = unMonto;
    }
}
