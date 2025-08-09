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
public class BancoTradicional extends Banco{
    private String direccion;
    private String localidad;
    private int maxCuentasDolares;
    private int misCuentasDolares;
    
    public BancoTradicional(String nombre, int cantEmpleados, int maxCuentas, String direccion, String localidad){
        super(nombre, cantEmpleados, maxCuentas);
        this.direccion = direccion;
        this.localidad = localidad;
        this.maxCuentasDolares = 100;
        this.misCuentasDolares = 0;
    }
    
    public boolean puedoAgregarUnaCuenta(){
        return (misCuentasDolares < maxCuentasDolares);
    }
    
    public boolean agregarUnaCuenta(Cuenta unaCuenta){
        boolean agregada = false;
        if (getMisCuentas() < getMaxCuentas()){
            if (unaCuenta.getMoneda().equals("dolares") && (puedoAgregarUnaCuenta())){
                agregarCuenta(unaCuenta);
                misCuentasDolares++;
                agregada = true;
            }                
        } else  //si la cuenta no es en dolares, la agrego directo
            super.agregarCuenta(unaCuenta);   
    
        return agregada;
    }
    
    public boolean puedeRecibirTarjeta(int unCBU){
        Cuenta unaCuenta = obtenerCuenta(unCBU);
        if ( unaCuenta != null){
            if ( unaCuenta.getMoneda().equals("dolares") && (unaCuenta.getMonto() > 500)){
                return true;                  
            }
            if (unaCuenta.getMoneda().equals("pesos") && (unaCuenta.getMonto() > 70000)){
                return true;
            }
        }
        return false;
    }
    
}
