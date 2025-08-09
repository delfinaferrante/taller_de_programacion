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
public class BancoDigital extends Banco{
    private String direccionWeb;
    
    public BancoDigital(String nombre, int cantEmpleados, int maxCuentas, String direccionWeb){
       super(nombre, cantEmpleados, maxCuentas);
       this.direccionWeb = direccionWeb;
    }
    
    public boolean agregarUnaCuenta(Cuenta unaCuenta){
        boolean agregada = false;
        if (getMisCuentas() < getMaxCuentas()){
            agregarCuenta(unaCuenta);
            agregada = true;
        }
        return agregada;
    }
    
    public boolean puedeRecibirTarjeta(int unCBU){
        Cuenta unaCuenta = obtenerCuenta(unCBU);
        if (unaCuenta != null){
            if (unaCuenta.getMoneda().equals("pesos") && (unaCuenta.getMonto() > 100000))
                return true;           
        }
        return false;
    }
    
    
}
