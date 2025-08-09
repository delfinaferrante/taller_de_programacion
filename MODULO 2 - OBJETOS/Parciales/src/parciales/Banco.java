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
public abstract class Banco {
    private String nombre;
    private int cantEmpleados;
    private int maxCuentas;
    private int misCuentas;
    private Cuenta[] cuentas;
    
    public Banco(String nombre, int cantEmpleados, int maxCuentas){
        this.nombre = nombre;
        this.cantEmpleados = cantEmpleados;
        this.maxCuentas = maxCuentas;
        this.misCuentas = 0;
        this.cuentas = new Cuenta[maxCuentas];
    }
    
    public int getMisCuentas(){
        return misCuentas;
    }
    public int getMaxCuentas(){
        return maxCuentas;
    }
    
    public boolean agregarCuenta(Cuenta unaCuenta){
        cuentas[misCuentas] = unaCuenta;
        misCuentas++;
        return true;
    }
    
    public Cuenta obtenerCuenta(int unCBU){
        int pos = 0;
        while ( (pos < misCuentas) && (cuentas[pos].getCbu() != unCBU )){
            pos++;
        }
        if ( (pos < misCuentas) && cuentas[pos].getCbu() == unCBU ){
            return cuentas[pos];
        } else
            return null;
    }
    
    public void depositarDinero(int unCBU, double unMonto){
        Cuenta unaCuenta = obtenerCuenta(unCBU);     
        if (unaCuenta != null){   //si es distinto de null, es porque encontro el cbu y la cuenta existe
            unMonto += unaCuenta.getMonto();
            unaCuenta.incrementarMonto(unMonto);
        } else
            System.out.println("La cuenta con cbu " + unCBU + " no existe.");
    }
    
    public abstract boolean agregarUnaCuenta(Cuenta unaCuenta);
    public abstract boolean puedeRecibirTarjeta(int unCBU);
    
}
